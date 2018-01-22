/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import java.util.LinkedList;
import java.util.List;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

/**
 * Holds a collection of DocumentFilters.
 * @author Diogo
 */
public class DocumentFilterHouse extends DocumentFilter
{
    private List<DocumentFilter> list;
    
    /**
     * Creates a house that hosts document filters.
     */
    public DocumentFilterHouse()
    {
        list = new LinkedList<>();
    }
    
    /**
     * Adds a document filter to this house.
     * @param filter
     * @return 
     */
    public boolean addDocumentFilter(DocumentFilter filter)
    {
        return list.add(filter);
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
        super.insertString(fb, offset, text, attributeSet);
        for (DocumentFilter elem:list)
        {
            elem.insertString(fb, offset, text, attributeSet);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
        for (DocumentFilter elem:list)
        {
            elem.remove(fb, offset, length);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
        super.replace(fb, offset, length, text, attributeSet);
        for (DocumentFilter elem:list)
        {
            elem.replace(fb, offset, length, text, attributeSet);
        }
    }
}
