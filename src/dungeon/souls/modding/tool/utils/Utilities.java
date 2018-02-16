/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Utilities library.
 * @author Diogo
 */
public final class Utilities
{

    //Makes this class non-instanceable.
    private Utilities()
    {        
    }
    
    /**
     * Recursively copies the contents from the project directory to the target directory.
     * @param projectDir The source directory to copy from.
     * @param targetDir The target directory to copy to.
     * @param filter The file filter to filter out files when copying.
     */
    public static void recurseCopy(File projectDir,File targetDir, ZipFileFilter filter)
    {
        if (projectDir.isDirectory())
        {
            File[] files = projectDir.listFiles();
            if (!targetDir.exists())
            {
                targetDir.mkdir();
            }
            String target = targetDir.getAbsolutePath();
            for (File element:files)
            {
                if (element.isFile())
                {
                    if (filter.isValid(element))
                    {
                        try
                        {
                            Files.copy(element.toPath(), new File(targetDir.getAbsoluteFile()+File.separator+element.getName()).toPath(), REPLACE_EXISTING);
                        }
                        catch (IOException ex)
                        {
                            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                {
                    recurseCopy(element, new File(target+File.separator+element.getName()), filter);
                }
            }
        }
    }
    
    /**
     * Zips the entire contents of the directory onto the zip stream.
     * @param dir (File) The directory to zip.
     * @param out The zip output stream.
     * @param filter The filter for the files to be zipped.
     * @param ignoreCurrentDir Whether the current directory folder should be copied,
     * or only its contents.
     */
    public static void zipDirectory(File dir, ZipOutputStream out,ZipFileFilter filter,boolean ignoreCurrentDir) throws IOException
    {
        if (dir!=null)
        {
            if (dir.isDirectory())
            {
                recurseZipDirectory((ignoreCurrentDir) ? "" : dir.getName(),dir,out,filter);
            }
        }
    }
    
    /**
     * Recursive version of zip directory.
     * @param baseDir The zip file's base directory path.
     * @param dir
     * @param out
     * @param filter
     * @throws IOException 
     */
    private static void recurseZipDirectory(String baseDir,File dir, ZipOutputStream out,ZipFileFilter filter) throws IOException
    {
        if (dir.isDirectory())
        {
            for (File element:dir.listFiles())
            {
                String base = (baseDir.isEmpty()) ? "" : baseDir+"/";
                if (element.isFile() && filter.isValid(element))
                {
                    ZipEntry entry = new ZipEntry(base+element.getName());
                    out.putNextEntry(entry);
                    out.write(fileToByteArray(element));
                    out.closeEntry();
                }
                else
                {
                    recurseZipDirectory(base+element.getName(),element, out,filter);
                }
            }
        }
    }
    
    /**
     * Writes or appends a line to a given file, depending on whether the
     * file has been created or not.
     * @param file The file to write or append to.
     * @param line The line to insert.
     * @throws IOException 
     */
    public static void writeOrAppendTo(File file,String line) throws IOException
    {
        BufferedWriter writer;
        if (file.exists())
        {
            writer = new BufferedWriter(new FileWriter(file,true));
        }
        else
        {
            writer = new BufferedWriter(new FileWriter(file));
        }
        writer.write(line);
        writer.newLine();
        writer.close();
    }
    
    /**
     * Extracts a file compiled within the java application.
     * @param folder The folder to extract to.
     * @param stream The input stream of the resource.
     * @param name The name of the file.
     * @param replace Replace if the extracted file is already present.
     * @return The extracted file.
     * @throws java.io.IOException
     */
    public static File extractPackagedFile(File folder,InputStream stream,String name,boolean replace) throws IOException
    {
        if (!folder.exists())
        {
            folder.mkdir();
        }
        if (folder.isDirectory())
        {
            File temp = new File(folder.getAbsolutePath()+File.separator+name);
            if (!temp.exists() || replace) //Not gonna copy if it already exists
            {
                String data = inputStreamAsString(stream);
                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(data.getBytes());
                fos.close();
            }
            return temp;
        }
        return null;
    }
    
    /**
     * Converts the contents of the file into a whole, single string.
     * @param file (File) The file to convert.
     * @return (String) The file's contents.
     * @throws IOException 
     */
    public static String fileAsString(File file) throws IOException
    {
        String result = "";
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String cache;
        while ((cache=buffer.readLine())!=null)
        {
            result+=cache+"\n";
        }
        buffer.close();
        return result;
    }
    
    /**
     * Converts the contents of the input stream into a whole, single string.
     * @param inputStream (InputStream) The input stream to convert.
     * @return (String) The input stream's contents.
     * @throws IOException 
     */
    public static String inputStreamAsString(InputStream inputStream) throws IOException
    {
        String result = "";
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        String cache;
        while ((cache=buffer.readLine())!=null)
        {
            result+=cache+"\n";
        }
        buffer.close();
        return result;
    }
    
    /**
     * Reads the contents of a file into a byte array.
     * @param file
     * @return
     * @throws IOException 
     */
    public static byte[] fileToByteArray(File file) throws IOException
    {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (fis.available()>0)
        {
            bos.write(fis.read());
        }
        return bos.toByteArray();
    }
    
    /**
     * Creates a random temporary directory. 
     * Should be deleted afterwards.
     * @return 
     */
    public static File createTemporaryDirectory()
    {
        Random rand = new Random();
        File tempDir = new File("Temp"+rand.nextInt(10000));
        tempDir.mkdir();
        return tempDir;
    }
    
    /**
     * Deletes a directory and all of its contents.
     * @param file (File) The directory to start deleting from.
     */
    public static void deleteDirectory(File file)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (File element:files)
            {
                deleteDirectory(element);
            }
        }
        file.delete();
    }
    
    /**
     * A filter to be used by zip utilities for filtering files.
     */
    public static interface ZipFileFilter
    {
        /**
         * Checks whether a given file is valid for zipping.
         * @param file The file to check.
         * @return True if the file can be zipped.
         */
        public boolean isValid(File file);
    }
}
