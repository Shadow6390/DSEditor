/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

/**
 * Represents an assembly assignment to a memory position.
 * @author Diogo
 */
public class MemoryAssignmentAssembly
{
    /**
     * Counts the amount of memory registries allocated and specifies the next available memory index.
     */
    private static int MEMORY_NEXT_INDEX=0;
    /**
     * The index of the memory.
     */
    private int memoryIndex;
    
    /**
     * Creates a new memory slot assignment.
     * @param memoryIndex (int) The index of the registry/slot of the memory.
     */
    private MemoryAssignmentAssembly(int memoryIndex)
    {
        this.memoryIndex=memoryIndex;
    }
    
    /**
     * Allocates a new registry to assign temporary values into memory.
     * @return 
     */
    public static MemoryAssignmentAssembly allocate()
    {
        return new MemoryAssignmentAssembly(MEMORY_NEXT_INDEX++);
    }
    
    /**
     * Resets the memory states.
     */
    public static void resetMemories()
    {
        MEMORY_NEXT_INDEX=0;
    }
    
    @Override
    public String toString()
    {
        return "$mr"+memoryIndex;
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = other!=null && getClass().equals(other.getClass());
        if (result)
        {
            MemoryAssignmentAssembly u = getClass().cast(other);
            result = (this==other) || (u.memoryIndex==memoryIndex);
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + this.memoryIndex;
        return hash;
    }
}
