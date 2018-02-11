/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.model.compiling.language.CompilationErrorMessage;
import javax.swing.text.StyledDocument;

/**
 * Represents a class responsible for highlighting syntax of code.
 * @author Diogo
 */
public interface CodeSyntaxHighlighter
{
    /**
     * Triggered when the document's text is changed.
     * @param document (StyledDocument) The styled document changed.
     * @param text (String) The modified text.
     */
    public void onTextChanged(StyledDocument document,String text);
    
    /**
     * Makes this highlighter signal any errors that have occurred.
     * @param document The styled document to change.
     * @param message The compilation error message.
     */
    public void signalError(StyledDocument document,CompilationErrorMessage message);
    
    /**
     * Clears any errors that may have been signaled.
     */
    public void clearErrors();
}
