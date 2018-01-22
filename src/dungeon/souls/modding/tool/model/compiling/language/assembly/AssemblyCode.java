/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

/**
 * Represents a Dungeon Souls Assembly Code.
 * @author Diogo
 */
public interface AssemblyCode
{
    /**
     * Converts the information stored on this code to Dugeon Souls assembly code,
     * in a string format.
     * @return (String) The Dungeon Souls Assembly code.
     */
    public String toAssembly();
}
