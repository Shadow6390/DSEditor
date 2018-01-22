/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

/**
 * An undo manager that allows to undo and redo text in a document.
 * @author Diogo
 */
public class DocumentTextUndoManager
{
    /**
     * Assumed as a list of changes to the document's text.
     */
    private ContentNode<DocumentTextChange> changes;
    
    /**
     * The document to manage.
     */
    private Document doc;
    
    /**
     * The previous version of the document. 
     * Used to keep track of removed text.
     */
    private String previousDoc;
    
    /**
     * Whether we should ignore a change, since the manager is the one causing it.
     */
    private boolean ignoreChange;
    
    /**
     * Creates a DocumentTextUndoManager with the specified parameters.
     * @param doc The document to manage.
     */
    public DocumentTextUndoManager(Document doc)
    {
        ignoreChange=false;
        this.doc=doc;
        doc.addDocumentListener(new DocumentListener()
        {

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                handleTextChange(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                handleTextChange(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                //handleTextChange(e);
                //Do not fire this: plain text documents do not listen for this.
                //Only documents such as styled ones.
            }
        });
    }
    
    /**
     * Performs an undo on the text document.
     */
    public void undo()
    {
        if (changes!=null)
        {
            if (changes.getPrevious()!=null)
            {
                ignoreChange=true;
                changes.getElement().undo(doc);
                changes = changes.getPrevious();
            }
        }
    }
    
    /**
     * Performs a redo on the text document.
     */
    public void redo()
    {
        if (changes!=null)
        {
            if (changes.getNext()!=null)
            {
                ignoreChange=true;
                changes = changes.getNext();
                changes.getElement().redo(doc);
                
            }
        }
    }
    
    private void handleTextChange(DocumentEvent e)
    {
        if (!ignoreChange)
        {
            int offset=e.getOffset(),length=e.getLength();
            DocumentTextChange change=null;
            if (e.getType().equals(DocumentEvent.EventType.INSERT))
            {
                try
                {
                    previousDoc = doc.getText(0, doc.getLength());
                    change = new InsertChange(e.getOffset(),e.getLength(),e.getDocument().getText(offset, length),null);
                }
                catch (BadLocationException ex)
                {
                    Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (e.getType().equals(DocumentEvent.EventType.REMOVE))
            {
                String text = previousDoc.substring(offset, offset+length);
                change = new RemoveChange(e.getOffset(),e.getLength(),text,null);
            }

            if (change!=null)
            {
                if (changes==null)
                {
                    changes=new ContentNode<>(change);
                }
                else
                {
                    ContentNode<DocumentTextChange> next = new ContentNode<>(change);
                    changes.setNext(next);
                    next.setPrevious(changes);
                    changes=next;
                }
            }
        }
        else
        {
            ignoreChange=false;
        }
    }
    
    @Deprecated
    private void listQueue(ContentNode start)
    {
        System.out.println("#################################################################");
        if (start!=null)
        {
            //Go back to the beginning of the trail.
            while (start.getPrevious()!=null)
            {
                start=start.getPrevious();
            }
            
            //Print everything
            while (start.getNext()!=null)
            {
                System.out.println(start.getElement());
                start=start.getNext();
            }
            System.out.println(start.getElement());
        }
    }
    
    @Deprecated
    private static class GlobalChange implements DocumentTextChange
    {
        private String text;
        
        private AttributeSet attributes;
        
        public GlobalChange(String text,AttributeSet set)
        {
            this.text = text;
            this.attributes=set;
        }
        
        @Override
        public void undo(Document doc)
        {
            try
            {
                doc.remove(0, doc.getLength());
                doc.insertString(0, text, attributes);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void redo(Document doc)
        {
            try
            {
                doc.remove(0, doc.getLength());
                doc.insertString(0, text, attributes);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Represents an insertion change on the document.
     */
    private static class InsertChange implements DocumentTextChange
    {
        private int offset;

        private int length;
        
        private String text;
        
        private AttributeSet attributes;
        
        public InsertChange(int offset,int length,String text,AttributeSet set)
        {
            this.offset = offset;
            this.length = length;
            this.text = text;
            this.attributes=set;
        }
        
        @Override
        public void undo(Document doc)
        {
            try
            {
                doc.remove(offset, length);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void redo(Document doc)
        {
            try
            {
                doc.insertString(offset, text, attributes);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        public String toString()
        {
            return "INSERT["+text+"]";
        }
    }
    
    /**
     * Represents a removal change on the document
     */
    private static class RemoveChange implements DocumentTextChange
    {
        private int offset;

        private int length;
        
        private String text;
        
        private AttributeSet attributes;
        
        public RemoveChange(int offset,int length,String text,AttributeSet set)
        {
            this.offset = offset;
            this.length = length;
            this.text = text;
            this.attributes=set;
        }
        
        @Override
        public void undo(Document doc)
        {
            try
            {
                doc.insertString(offset, text, attributes);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void redo(Document doc)
        {
            try
            {
                doc.remove(offset, length);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(DocumentTextUndoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @Override
        public String toString()
        {
            return "REMOVE["+text+"]";
        }
    }
}
