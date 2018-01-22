/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.Block_codeContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.Explicit_codeContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.If_statementContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.StatementContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.ValueContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Assembly version of the sprite.
 * @author Diogo
 */
public class SpriteAssembly implements AssemblyCode
{
    
    /**
     * The name of the module's variable.
     */
    private String variableName;

    /**
     * The images to load.
     */
    private List<String> images;
    
    /**
     * The errors obtained.
     */
    private List<String> errors;
    
    private SpriteAssembly()
    {
        images = new LinkedList();
        errors = new LinkedList();
    }

    /**
     * Parses module data from the context.
     * @param ctx
     * @return
     */
    public static SpriteAssembly parseFrom(BaseGrammarParser.AssetSpriteContext ctx)
    {
        SpriteAssembly result = new SpriteAssembly();
        List<BaseGrammarParser.AssignmentContext> assignments = result.getAssigments(ctx);
        result.variableName=ctx.VARIABLE().getText();
        result.parseSprite(assignments);
        return result;
    }

    /**
     * Checks if all required fields are valid. In case they are not, a list of
     * reasons will be returned. If the info is valid, the list will be empty.
     *
     * @return
     */
    public List<String> validate()
    {
        List<String> result = new LinkedList();
        if (images.isEmpty())
        {
            result.add(variableName+" has no subimages");
        }
        result.addAll(errors);
        return result;
    }
    
    private void parseSprite(List<BaseGrammarParser.AssignmentContext> assignments)
    {
        for (BaseGrammarParser.AssignmentContext context : assignments)
        {
            TerminalNode gvar = context.variable().GAME_VARIABLE();
            if (gvar != null)
            {
                ValueContext vcon = context.math_value().value();
                if (gvar.getText().equals("[SUBIMAGE]"))
                {
                    if (vcon!=null)
                    {
                        if (vcon.STRING()!=null)
                        {
                            images.add(vcon.getText());
                        }
                        else
                        {
                            errors.add("Subimage value must be a string containing the path!");
                        }
                    }
                }
            }
        }
    }

    private List<BaseGrammarParser.AssignmentContext> getAssigments(BaseGrammarParser.AssetSpriteContext ctx)
    {
        List<BaseGrammarParser.AssignmentContext> result = new LinkedList();
        getAssigmentsRecurse(ctx, result);
        return result;
    }

    private void getAssigmentsRecurse(ParseTree tree, List<BaseGrammarParser.AssignmentContext> contextList)
    {
        if (tree.getChildCount() > 0)
        {
            for (int i = 0; i < tree.getChildCount(); i++)
            {
                getAssigmentsRecurse(tree.getChild(i), contextList);
            }
            if (tree.getClass().equals(BaseGrammarParser.AssignmentContext.class))
            {
                contextList.add((BaseGrammarParser.AssignmentContext) tree);
            }
        }
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = other!=null && getClass().equals(other.getClass());
        if (result)
        {
            SpriteAssembly assembly = (SpriteAssembly) other;
            result = (this==other) || (variableName.equals(assembly.variableName));
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.variableName);
        return hash;
    }
    
    @Override
    public String toString()
    {
        return variableName;
    }

    @Override
    public String toAssembly()
    {
        String result = String.format("modding_define_sprite %s",variableName);
        for (String image:images)
        {
            result+=" "+image;
        }
        return result;
    }
}
