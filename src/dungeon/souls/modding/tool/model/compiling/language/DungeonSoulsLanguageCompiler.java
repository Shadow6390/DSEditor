/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import dungeon.souls.modding.tool.model.compiling.language.assembly.CodeBlockAssembly;
import dungeon.souls.modding.tool.model.compiling.language.assembly.MemoryAssignmentAssembly;
import dungeon.souls.modding.tool.model.module.ModuleProject;
import dungeon.souls.modding.tool.steam.SteamManager;
import dungeon.souls.modding.tool.ui.EditorMain;
import dungeon.souls.modding.tool.utils.Utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Represents a compiler for Dungeon Souls' Modding Language.
 * @author Diogo
 */
public class DungeonSoulsLanguageCompiler
{
    /**
     * The error listener for the last compilation process.
     */
    private BaseGrammarErrorListener errorListener;
    
    /**
     * The build listener for the last compilation process.
     */
    public BaseGrammarBuildListener buildListener;
    
    /**
     * Whether it should output the compilation process or not.
     */
    private boolean verbose;
    
    /**
     * The location of dungeon souls' content.
     */
    private final String DUNGEON_SOULS_FOLDER="DungeonSouls";
    
    /**
     * Creates an instance of {@ DungeonSoulsLanguageCompiler}.
     */
    public DungeonSoulsLanguageCompiler()
    {
        verbose=true;
    }
    
    public void compileAndRun(ModuleProject project) throws IOException
    {
        String targetDir = "";
        String osname = System.getProperty("os.name").toLowerCase();
        if (osname.contains("win"))
        {
            targetDir = Paths.get(System.getenv("LOCALAPPDATA"),DUNGEON_SOULS_FOLDER).toString();
        }
        else if (osname.contains("mac"))
        {
            targetDir = Paths.get(System.getProperty("user.home"),"Library","Application",DUNGEON_SOULS_FOLDER).toString();
        }
        else if (osname.contains("nix") || osname.contains("nux") || osname.contains("aix"))
        {
            targetDir = Paths.get(System.getProperty("user.home"),System.getProperty("user.name"),".config",DUNGEON_SOULS_FOLDER).toString();
        }
        File outputDir = new File(targetDir);
        if (!targetDir.equals("") && outputDir.exists()) //Should change to: If we haven't found a valid directory, we prompt the user.
        {
            outputDir = Paths.get(outputDir.getAbsolutePath(),"Mods").toFile();
            if (!outputDir.exists()) //Create "Mods" folder if it doesn't exist.
            {
                outputDir.mkdir();
            }
            compileProjectFolder(project,Paths.get(outputDir.getAbsolutePath(),project.getName()+".dsa").toFile());
            File modStart = new File(targetDir+File.separator+"MOD_START.ses");
            addModuleEntry(outputDir,project);
            if (!modStart.exists())
            {
                modStart.createNewFile();
            }
            try
            {
                Desktop.getDesktop().browse(new URI("steam://run/"+SteamManager.STEAM_APP_ID));
            }
            catch (URISyntaxException ex)
            {
                throw new IOException("Module instaled but failed to run Dungeon Souls due to '"+ex.getMessage()+"'");
            }
        }
        else
        {
            throw new IOException("Dungeon Souls' save location folder was not found.");
        }
    }
    
    /**
     * Sets whether the compiler should output messages to the editor's output
     * log.
     * @param value Output messages to editor if true.
     */
    public void setVerbose(boolean value)
    {
        verbose=value;
    }
    
    /**
     * Compiles the entire project onto a folder.
     * @param project (ModuleProject) The project to be compiled.
     * @param output (File) The output file of the code.
     * check compilation errors.
     * @return The path to the folder created.
     * @throws java.io.IOException 
     */
    public String compileProjectFolder(ModuleProject project,File output) throws IOException
    {
        String text;
        text=project.mergeCodeFiles();
        
        
        //Compile module into assembly.
        String moduleName = output.getName();
        moduleName = moduleName.substring(0,moduleName.lastIndexOf('.'))+".dsa";
        String temp = compileString(text, true);
        File dir = new File(output.getParent()+File.separator+project.getName());
        if (!dir.exists())
        {
            dir.mkdir();
        }
        output = new File(dir.getAbsolutePath()+File.separator+moduleName);
        FileWriter writer = new FileWriter(output);
        writer.write(temp, 0, temp.length());
        writer.close();
                
        //Zip the rest of the directory, without copying code files,
        File projectDir = project.getDirectory();
        Utilities.ZipFileFilter filter = (File file) ->
        {
            boolean notModdingFile=true;
            if (file.isFile())
            {
                String extension = file.getName();
                extension = extension.substring(extension.lastIndexOf(".")+1);
                notModdingFile = !(extension.equals("dsmod") || extension.equals("dsspr") || extension.equals("dsitem"));
            }
            return file.isDirectory() || (notModdingFile);
        };
        Utilities.recurseCopy(projectDir,dir,filter);
        
        EditorMain.out.println("Compiled mod into "+output.getAbsolutePath());
        return dir.getAbsolutePath();
    }
    
    /**
     * Compiles the entire project onto a zip file.
     * @param project (ModuleProject) The project to be compiled.
     * @param output (File) The output file of the code.
     * check compilation errors.
     */
    public void compileProject(ModuleProject project,File output) throws IOException
    {
        //File dir = Utilities.createTemporaryDirectory();
        String text;
        text=project.mergeCodeFiles();
        
        
        //Compile module into assembly.
        String temp = compileString(text, true);
        String moduleName = output.getName();
        moduleName = moduleName.substring(0,moduleName.lastIndexOf('.'))+".dsa";
        
        //Zip assembly and everything else in the directory.
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(output));
        ZipEntry entry = new ZipEntry(moduleName);
        out.putNextEntry(entry);
        out.write(temp.getBytes());
        out.closeEntry();
        
        //Zip the rest of the directory, without copying code files,
        File projectDir = project.getDirectory();
        Utilities.ZipFileFilter filter = (File file) ->
        {
            boolean notModdingFile=true;
            if (file.isFile())
            {
                String extension = file.getName();
                extension = extension.substring(extension.lastIndexOf(".")+1);
                notModdingFile = !(extension.equals("dsmod") || extension.equals("dsspr") || extension.equals("dsitem"));
            }
            return file.isDirectory() || (notModdingFile);
        };
        Utilities.zipDirectory(projectDir,out,filter,true);
        
        out.flush();
        out.finish();
        out.close();
        
        EditorMain.out.println("Compiled mod into "+output.getAbsolutePath());
    }
    
    /**
     * Compiles the specified string.
     * @param text (String) The text that contains the code to compile. The
     * written code must be according to Dungeon Souls' Modding Language standards.
     * @param buildCode (boolean) Whether the final code should be built.
     * @return 
     */
    public String compileString(String text,boolean buildCode)
    {
        CharStream input = CharStreams.fromString(text);
        BaseGrammarLexer lexer = new BaseGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        BaseGrammarParser parser = new BaseGrammarParser(tokens);
        parser.removeErrorListeners();
        errorListener = new BaseGrammarErrorListener();
        parser.addErrorListener(errorListener);
        BaseGrammarParser.StartContext context = parser.start();
        //Listener approach:
        ParseTreeWalker walker=new ParseTreeWalker();
        MemoryAssignmentAssembly.resetMemories();
        CodeBlockAssembly.resetCodeBlockCount();
        
        buildListener = new BaseGrammarBuildListener(parser);
        walker.walk(buildListener, context);
        
        String finalMessage="";
        if (verbose)
        {
            if (errorListener.size()>0)
            {
                for (int i=0;i<errorListener.size();i++)
                {
                    EditorMain.out.println(errorListener.getMessage(i));
                }
                if (!buildCode)
                {
                    finalMessage="File compilation-check failed";
                }
                else
                {
                    finalMessage = "Project build failed.";
                }
            }
            else
            {
                if (!buildCode)
                {
                    finalMessage="File compilation-check successful and return OK.";
                }
                else
                {
                    finalMessage="Project compiled.";
                }
            }
            EditorMain.out.println(finalMessage);
        }
        return (buildCode) ? buildListener.getCompilationAssemblyCode() : "";
    }
    
    public List<String> getCompiledVariables()
    {
        return (buildListener==null) ? null : buildListener.getVariableList();
    }
    
    /**
     * Returns a list of error messages from the compilation process.
     * @return The list of messages. Can be empty.
     */
    public List<CompilationErrorMessage> getErrorMessages()
    {
        List<CompilationErrorMessage> result = new LinkedList<>();
        if (errorListener!=null)
        {
            result = errorListener.getMessageList();
        }
        return result;
    }
    
    /**
     * Adds a module entry to the mods_location.config file.
     * @param outputDir The output directory where the file resides at.
     * @param mp The project module.
     * @throws IOException 
     */
    private void addModuleEntry(File outputDir,ModuleProject mp) throws IOException
    {
        File configFile = new File(outputDir.getAbsolutePath()+File.separator+"mods_location.config");
        String entry = mp.getName()+"/"+mp.getName()+".dsa";
        if (!modsLocationContains(configFile,entry))
        {
            Utilities.writeOrAppendTo(configFile, entry);
        }
    }
    
    /**
     * Checks whether the mods_location.config file contains the module entry or not.
     * @param configFile The file to check for.
     * @param entry The entry to check.
     * @return True if it does contain.
     */
    private boolean modsLocationContains(File configFile,String entry) throws IOException
    {
        boolean result = false;
        if (configFile.exists() && configFile.isFile())
        {
            List<String> lines = Files.readAllLines(configFile.toPath());
            result = lines.contains(entry);
        }
        return result;
    }
    
    /**
     * Converts the specified text to a variable name.
     * A variable name can only have letters, numbers and '_'.
     * @param text The text to be converted.
     * @return The variable name.
     */
    public static String convertToVarible(String text)
    {
        return (text!=null) ? text.replaceAll(" ","_").replaceAll("[^a-zA-Z0-9_]","") : "";
    }
}
