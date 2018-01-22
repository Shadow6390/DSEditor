/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import dungeon.souls.modding.tool.model.compiling.language.assembly.CodeBlockAssembly;
import dungeon.souls.modding.tool.model.compiling.language.assembly.MemoryAssignmentAssembly;
import dungeon.souls.modding.tool.model.module.ModuleProject;
import dungeon.souls.modding.tool.ui.EditorMain;
import dungeon.souls.modding.tool.utils.Utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
     * Creates an instance of {@ DungeonSoulsLanguageCompiler}.
     */
    public DungeonSoulsLanguageCompiler()
    {
        
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
        /*FileWriter writer = new FileWriter(dsaOutput);
        writer.write(temp, 0, temp.length());
        writer.close();*/
        
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
        BaseGrammarErrorListener listener = new BaseGrammarErrorListener();
        parser.addErrorListener(listener);
        BaseGrammarParser.StartContext context = parser.start();
        //Listener approach:
        ParseTreeWalker walker=new ParseTreeWalker();
        MemoryAssignmentAssembly.resetMemories();
        CodeBlockAssembly.resetCodeBlockCount();
        BaseGrammarBuildListener buildListener = new BaseGrammarBuildListener(parser);
        walker.walk(buildListener, context);
        String finalMessage="";
        if (listener.size()>0)
        {
            for (int i=0;i<listener.size();i++)
            {
                EditorMain.out.println(listener.getMessage(i));
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
        return (buildCode) ? buildListener.getCompilationAssemblyCode() : "";
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
