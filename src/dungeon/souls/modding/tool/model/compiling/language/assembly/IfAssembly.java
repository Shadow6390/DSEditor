/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

/**
 * Represents an if/if_else in assembly.
 * @author Diogo
 */
public class IfAssembly implements AssemblyCode
{

    /**
     * The code to be executed after the if code.
     */
    private CodeBlockAssembly ifCode;
    
    /**
     * The code to be executed in the else statement. 
     * Can be empty and will always have one less element.
     */
    private CodeBlockAssembly elseCode;
    
    /**
     * The comparison conditions.
     */
    private ComparisonAssembly comparison;
    
    public IfAssembly()
    {
    }

    /**
     * @param ifCode the ifCode to set
     */
    public void setIfCode(CodeBlockAssembly ifCode)
    {
        this.ifCode = ifCode;
    }

    /**
     * @param elseCode the elseCode to set
     */
    public void setElseCode(CodeBlockAssembly elseCode)
    {
        this.elseCode = elseCode;
    }

    /**
     * @param comparison the comparison to set
     */
    public void setComparison(ComparisonAssembly comparison)
    {
        this.comparison = comparison;
    }
    
    @Override
    public String toAssembly()
    {
        String extra = "";
        if (elseCode!=null)
        {
            extra=" "+elseCode.toString();
        }
        String result = comparison.toAssembly()+"\n";
        result+=AssemblyCodeLibrary.ASSEMBLY_IF_THEN_ELSE_THEN+" "+comparison.getComparisonResultRegistry()+" "+ifCode.toString()+extra+"\n";
        result+=ifCode.toAssembly();
        if (elseCode!=null)
        {
            result+="\n"+elseCode.toAssembly();
        }
        return result;
    }
}
