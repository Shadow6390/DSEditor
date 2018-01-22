/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a block of code in assembly.
 * @author Diogo
 */
public class CodeBlockAssembly implements AssemblyCode
{

    /**
     * The code inside this assembly block.
     */
    private List<AssemblyCode> code;
    
    /**
     * The current index of code blocks.
     */
    private static int CODE_BLOCK_INDEX=0;
    
    /**
     * The index of this code block.
     */
    private int index;
    
    public CodeBlockAssembly()
    {
        index=CODE_BLOCK_INDEX++;
        code = new LinkedList();
    }
    
    /**
     * Resets the counting of code blocks.
     */
    public static void resetCodeBlockCount()
    {
        CODE_BLOCK_INDEX=0;
    }
    
    /**
     * Adds a new assembly code line to this block of code.
     * @param codeLine
     * @return 
     */
    public boolean addAssemblyCode(AssemblyCode codeLine)
    {
        return code.add(codeLine);
    }
    
    @Override
    public String toAssembly()
    {
        String result=AssemblyCodeLibrary.ASSEMBLY_CODE_BLOCK_START+index+"\n";
        for (AssemblyCode line:code)
        {
            result+=line.toAssembly()+"\n";
        }
        result+=AssemblyCodeLibrary.ASSEMBLY_CODE_BLOCK_END;
        return result;
    }
    
    @Override
    public String toString()
    {
        return AssemblyCodeLibrary.ASSEMBLY_CODE_BLOCK+index;
    }
}
