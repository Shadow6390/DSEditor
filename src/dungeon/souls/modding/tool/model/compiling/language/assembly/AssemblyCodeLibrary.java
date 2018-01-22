/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

/**
 * Contains constants of the assembly methods.
 * @author Diogo
 */
public final class AssemblyCodeLibrary
{
    private AssemblyCodeLibrary()
    {
        //No one can instance this
    }
    
    public static final String ASSEMBLY_ASSIGN_REGISTRY_VALUE="modding_set_registry_with_value";
    
    public static final String ASSEMBLY_ASSIGN_REGISTRY_FUNCTION="modding_set_registry_with_function";
    
    public static final String ASSEMBLY_ASSIGN_REGISTRY_REGISTRY="modding_set_registry";
    
    public static final String ASSEMBLY_ASSIGN_REGISTRY_VARIABLE="modding_set_registry_with_variable";
    
    public static final String ASSEMBLY_CODE_BLOCK="$b";
    
    public static final String ASSEMBLY_CODE_BLOCK_START="block start "+ASSEMBLY_CODE_BLOCK;
    
    public static final String ASSEMBLY_CODE_BLOCK_END="block end";
    
    public static final String ASSEMBLY_FUNCTION_CALL="modding_call_function";
    
    public static final String ASSEMBLY_COMPARISON="modding_compare";
    
    public static final String ASSEMBLY_IF_THEN_ELSE_THEN="modding_if_then_else";
    
}
