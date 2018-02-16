/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.generic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
* A data house class that houses the config file's data.
* @author Diogo
*/
@XmlRootElement
public class EditorData
{
   /**
    * The documentation version stored in the file.
    */
   @XmlElement
   public int documentationVersion=0;

   /**
    * The last editor version known.
    */
   @XmlElement
   public String lastEditorVersion="0.0.0";
   
   //Default constructor for JABX
   public EditorData()
   {
       
   }
}