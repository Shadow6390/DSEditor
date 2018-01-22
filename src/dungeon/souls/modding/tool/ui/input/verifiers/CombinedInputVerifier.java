/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui.input.verifiers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Allows for the combination of multiple restrictions on text input.
 * In order for a component to be valid, <b>all</b> restrictions must return true.
 * @author Diogo
 */
public class CombinedInputVerifier extends InputVerifier
{
    
    /**
     * The compontent that will notify of the errors.
     */
    private JComponent notifier;
    /**
     * The list of restrictions of this verifier.
     */
    private List<InputRestriction> restrictions;
    
    /**
     * Creates a CombinedInputVerifier.
     */
    public CombinedInputVerifier()
    {
        super();
        restrictions = new LinkedList();
    }
    
    /**
     * Creates a CombinedInputVerifier.
     * @param notifier The compontent that will notify of the errors.
     */
    public CombinedInputVerifier(JComponent notifier)
    {
        super();
        restrictions = new LinkedList();
        this.notifier=notifier;
    }
    
    /**
     * Adds a restriction to the input verifier.
     * @param restriction ({@link InputRestriction}) The input restriction to add.
     * @return (boolean) The input restriction.
     */
    public boolean addRestriction(InputRestriction restriction)
    {
        return restrictions.add(restriction);
    }

    @Override
    public boolean verify(JComponent input)
    {
        boolean result = true;
        notifyError("");
        try
        {
            String data = getTextFrom(input);
            Iterator<InputRestriction> it = restrictions.iterator();
            InputRestriction restriction;
            while (it.hasNext() && result)
            {
                restriction = it.next();
                result = result && restriction.isValid(data);
                if (!result)
                {
                    String message = restriction.getReason();
                    String name = input.getName();
                    if (name!=null)
                    {
                        if (!input.getName().isEmpty())
                        {
                            message=input.getName()+" "+message;
                        }
                    }
                    notifyError(message);
                }
            }
        }
        catch (IllegalArgumentException e) //In case we cannot use the component.
        {
            result = false;
            if (!result)
            {
                notifyError(getClass().getName()+" cannot be used on "+input.getClass().getName());
            }
        }
        return result;
    }
    
    private void notifyError(String message)
    {
        if (notifier instanceof JTextField)
        {
            ((JTextField)notifier).setText(message);
        }
        else if (notifier instanceof JTextArea)
        {
            ((JTextArea)notifier).setText(message);
        }
        else if (notifier instanceof JLabel)
        {
            ((JLabel)notifier).setText(message);
        }
    }
    
    private String getTextFrom(JComponent input) throws IllegalArgumentException
    {
        String result = "";
        if (input instanceof JTextField)
        {
            result = ((JTextField)input).getText();
        }
        else if (input instanceof JComboBox)
        {
            result = ((JComboBox)input).getSelectedItem().toString();
        }
        else if (input instanceof JTextArea)
        {
            result = ((JTextArea)input).getText();
        }
        else
        {
            throw new IllegalArgumentException("Component is not recognized by "+getClass().getSimpleName());
        }
        return result;
    }
    
}
