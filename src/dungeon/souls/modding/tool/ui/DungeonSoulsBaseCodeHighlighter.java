/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.model.compiling.CodeTemplate;
import dungeon.souls.modding.tool.reflection.Property;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * The base code syntax highlighting for Dungeon Souls mods.
 * @author Diogo
 */
public class DungeonSoulsBaseCodeHighlighter implements CodeSyntaxHighlighter
{
    private final StyleContext context = StyleContext.getDefaultStyleContext();
    private final AttributeSet ingameAttribute = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, new Color(132, 62, 173));
    private final AttributeSet complexOperators = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, new Color(0,0,255));
    private final AttributeSet comment = context.addAttribute(context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, new Color(67,104,60)),StyleConstants.Italic,true);
    private final AttributeSet string = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, new Color(226, 149, 40));
    
    /**
     * The pattern for strings.
     */
    private Pattern stringPattern;
    /**
     * The pattern for comments.
     */
    private Pattern commentPattern;
    /**
     * The pattern for complex operators (if, for, etc.).
     */
    private Pattern complexOperatorsPattern;
    /**
     * The pattern for attributes that are from the game (mod version, mod name, item stacks, etc.).
     */
    private Pattern ingameAttributePattern;
    
    /**
     * The template that contains extra properties to search for when higlighting.
     */
    private CodeTemplate template;
    
    /**
     * Creates an instance of {@link DungeonSoulsBaseCodeHighlighter}.
     */
    public DungeonSoulsBaseCodeHighlighter()
    {
        initPatterns();
    }
    
    /**
     * Creates an instance of {@link DungeonSoulsBaseCodeHighlighter}.
     * @param template (CodeTemplate) The template that contains extra properties to search for when higlighting.
     */
    public DungeonSoulsBaseCodeHighlighter(CodeTemplate template)
    {
        this.template=template;
        initPatterns();
    }

    @Override
    public void onTextChanged(StyledDocument document, String text)
    {
        Matcher matcher;
        
        matcher = complexOperatorsPattern.matcher(text);
        while (matcher.find()) {
            document.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), complexOperators, false);
        }
        
        matcher = ingameAttributePattern.matcher(text);
        while (matcher.find()) {
            // Change the color of recognized tokens
            document.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), ingameAttribute, false);
        }
        
        matcher = stringPattern.matcher(text);
        while (matcher.find()) {
            // Change the color of recognized tokens
            document.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), string, false);
        }
        
        matcher = commentPattern.matcher(text);
        while (matcher.find()) {
            // Change the color of recognized tokens
            document.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), comment, false);
        }
    }

    /**
     * Initializes the patterns to identify.
     */
    private void initPatterns()
    {
        stringPattern = Pattern.compile("\"[^\"]*\"");
        commentPattern = Pattern.compile("#.*(\n|\n\r|$)");
        complexOperatorsPattern = buildWordBasedPattern(new String[]{"if","else","define","function","module","item","sprite","functionInput","functionOutput"});
        List<String> attributes = new LinkedList();
        attributes.addAll(getPropertiesFrom(getClass()));
        if (template!=null)
        {
            attributes.addAll(getPropertiesFrom(template.getClass()));
        }
        ingameAttributePattern = buildStringBasedPattern(attributes.toArray(new String[attributes.size()]));
    }
    
    /**
     * Obtains the @Property values of the specified class.
     * @param c (Class) The target class.
     * @return (List&lt;String&gt;) The names of the properties.
     */
    private List<String> getPropertiesFrom(Class c)
    {
        List<String> attributes = new LinkedList();
        for (Field f:c.getDeclaredFields())
        {
            Property[] properties = f.getAnnotationsByType(Property.class);
            if (properties.length>0)
            {
                for (Property p:properties)
                {
                    String value = p.value();
                    if (value.equals("")) //Special auto-complete case.
                    {
                        value = f.getName().toUpperCase();
                    }
                    attributes.add("\\["+value+"\\]");
                }
            }
        }
        return attributes;
    }
    
    /**
     * Builds a regex pattern that checks for certain strings.
     * This method differs from the words counter part, since strings can be followed by characters, like: abcSTRINGasd
     * @param words (String[]) An array containing the strings or expressions to evaluate.
     * @return (Pattern) The compiled pattern.
     */
    private Pattern buildStringBasedPattern(String[] words)
    {
        StringBuilder sb = new StringBuilder();
        for (String token : words) {
            sb.append(token);
            sb.append("|"); // End of word boundary and an or for the next word
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing "|"
        }

        Pattern p = Pattern.compile(sb.toString());

        return p;
    }
    
    /**
     * Builds a regex pattern that checks for certain words.
     * @param words (String[]) An array containing the words or expressions to evaluate.
     * @return (Pattern) The compiled pattern.
     */
    private Pattern buildWordBasedPattern(String[] words)
    {
        StringBuilder sb = new StringBuilder();
        for (String token : words) {
            sb.append("\\b"); // Start of word boundary
            sb.append(token);
            sb.append("\\b|"); // End of word boundary and an or for the next word
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing "|"
        }

        Pattern p = Pattern.compile(sb.toString());

        return p;
    }
}
