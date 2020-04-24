/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.FileReader;

import fruit.ninja.logic.User;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author david
 */
public class FileWriter {
    
    
    
    public static void saveScores(List<User> users) 
    {
           try {  
            DocumentBuilderFactory fFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder fBuilder;
     
            fBuilder = fFactory.newDocumentBuilder();
       
            Document doc=(Document) fBuilder.newDocument();
            Element root=doc.createElement("Users");
            doc.appendChild(root);
    
               
                
            for(int i=0;i<users.size();i++){
            
            Element user=doc.createElement("User");
            root.appendChild(user);
                       
            String name=users.get(i).getName();
            String Score1=String.valueOf(users.get(i).getScoreLevelOne());
            String Score2=String.valueOf(users.get(i).getScoreLevelTwo());
            String Score3=String.valueOf(users.get(i).getScoreLevelThree());
            String Score4=String.valueOf(users.get(i).getScoreArcade());

            
            Element Name=doc.createElement("Name");
            Name.appendChild(doc.createTextNode(name));
            user.appendChild(Name);
            
           
            Element score1=doc.createElement("ScoreLevelOne");
            score1.appendChild(doc.createTextNode(Score1));
            user.appendChild(score1);
            
             Element score2=doc.createElement("ScoreLevelTwo");
            score2.appendChild(doc.createTextNode(Score2));
            user.appendChild(score2);
            
             Element score3=doc.createElement("ScoreLevelThree");
            score3.appendChild(doc.createTextNode(Score3));
            user.appendChild(score3);
            
             Element score4=doc.createElement("ScoreArcade");
            score4.appendChild(doc.createTextNode(Score4));
            user.appendChild(score4);

            }
            
            
                    
         TransformerFactory fTransform=TransformerFactory.newInstance();
         Transformer trans;
         trans = fTransform.newTransformer();
              
         DOMSource dom=new DOMSource(doc);
         StreamResult streamResult = new StreamResult(new File("Users.txt"));
          trans.transform(dom, streamResult);
            
            
            
        } catch (ParserConfigurationException ex) {
               System.out.println(ex);
        
       
    }   catch (TransformerException ex) {
            System.out.println(ex);

        }
           
      
    }
    
}
