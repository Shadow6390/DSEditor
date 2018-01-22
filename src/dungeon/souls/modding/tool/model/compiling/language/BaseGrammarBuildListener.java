/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import dungeon.souls.modding.tool.model.compiling.language.assembly.FunctionAssembly;
import dungeon.souls.modding.tool.model.compiling.language.assembly.ItemAssembly;
import dungeon.souls.modding.tool.model.compiling.language.assembly.ModuleAssembly;
import dungeon.souls.modding.tool.model.compiling.language.assembly.SpriteAssembly;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Listener that builds the final code.
 *
 * @author Diogo
 */
public class BaseGrammarBuildListener extends BaseGrammarBaseListener
{

    //This is going to be a loooooong class...
    private enum Context
    {

        MODULE, NONE, FUNCTION, SPRITE, ITEM
    }

    /**
     * The parser.
     */
    private Parser parser;

    private Context context;

    private Context previousContext;

    /**
     * The defined variables.
     */
    private List<String> variables;

    /**
     * The amount of module definitions.
     */
    private int moduleDefinitions;

    /**
     * The amount of semantic errors detected on compilation time.
     */
    private int semanticErrors;

    /**
     * The amount of times a function definition has been called.
     */
    private int functionDepth;

    /**
     * The information of the module.
     */
    private ModuleAssembly module;
    
    private List<FunctionAssembly> functions;
    
    private List<SpriteAssembly> sprites;
    
    private List<ItemAssembly> items;

    public BaseGrammarBuildListener(Parser parser)
    {
        super();
        context = Context.NONE;
        previousContext = Context.NONE;
        variables = new ArrayList();
        moduleDefinitions = 0;
        this.parser = parser;
        this.semanticErrors = 0;
        items = new LinkedList();
        sprites = new LinkedList();
        functions=new LinkedList();
    }
    
    /**
     * Returns the amount of semantic errors obtained.
     * @return (int) The amount of semantic errors.
     */
    public int getSemanticErrors()
    {
        return semanticErrors;
    }
    
    /**
     * Returns all compiled assets into one full 'sheet' of code.
     * @return 
     */
    public String getCompilationAssemblyCode()
    {
        String result = "";
        if (module!=null)
        {
            result+=module.toAssembly();
        }
        for (SpriteAssembly element:sprites)
        {
            result+="\n"+element.toAssembly();
        }
        for (FunctionAssembly element:functions)
        {
            result+="\n"+element.toAssembly();
        }
        for (ItemAssembly element:items)
        {
            result+="\n"+element.toAssembly();
        }
        return result;
    }

    @Override
    public void exitAssetModule(@NotNull BaseGrammarParser.AssetModuleContext ctx)
    {
        moduleDefinitions++;
        if (moduleDefinitions > 1)
        {
            if (parser != null)
            {
                parser.notifyErrorListeners("Only one module can be defined per project! To define another module, please create another project!");
                semanticErrors++;
            }
        }
        else if (parser.getNumberOfSyntaxErrors() == 0 && semanticErrors == 0)
        {
            ModuleAssembly info = ModuleAssembly.parseFrom(ctx);
            List<String> reasons = info.validate();
            signalParserError(reasons);
            if (reasons.isEmpty())
            {
                this.module = info;
            }
        }
    }

    @Override
    public void enterAssetFunction(@NotNull BaseGrammarParser.AssetFunctionContext ctx)
    {
        functionDepth++;
    }

    @Override
    public void exitAssetFunction(@NotNull BaseGrammarParser.AssetFunctionContext ctx)
    {
        if (functionDepth > 1)
        {
            List<String> reasons = new LinkedList();
            reasons.add("cannot define function within function...");
            signalParserError(reasons);
        }
        else
        {
            FunctionAssembly info = FunctionAssembly.parseFrom(ctx);
            List<String> reasons = info.validate();
            signalParserError(reasons);
            if (semanticErrors==0)
            {
                if (functions.contains(info))
                {
                    signalParserError("duplicate function declaration found: "+info);
                }
                else
                {
                    functions.add(info);
                }
            }
        }
        functionDepth--;
    }

    @Override
    public void exitAssetSprite(@NotNull BaseGrammarParser.AssetSpriteContext ctx)
    {
        SpriteAssembly info = SpriteAssembly.parseFrom(ctx);
        List<String> reasons = info.validate();
        signalParserError(reasons);
        if (semanticErrors==0)
        {
            if (sprites.contains(info))
            {
                signalParserError("duplicate sprite definition found: "+info);
                semanticErrors++;
            }
            else
            {
                sprites.add(info);
            }
        }
    }

    @Override
    public void exitAssetItem(@NotNull BaseGrammarParser.AssetItemContext ctx)
    {
        ItemAssembly info = ItemAssembly.parseFrom(ctx);
        signalParserError(info.validate());
        if (semanticErrors==0)
        {
            if (items.contains(info))
            {
                signalParserError("duplicate item definition found: "+info);
                semanticErrors++;
            }
            else
            {
                items.add(info);
            }
        }
    }

    private void signalParserError(List<String> errors)
    {
        if (!errors.isEmpty())
        {
            for (String reason : errors)
            {
                signalParserError(reason);
            }
        }
    }
    
    private void signalParserError(String error)
    {
        if (parser != null)
        {
            parser.notifyErrorListeners(error);
        }
        semanticErrors++;
    }
}
