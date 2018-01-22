/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

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
}
