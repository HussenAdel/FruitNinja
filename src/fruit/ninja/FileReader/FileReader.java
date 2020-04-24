/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.FileReader;

import fruit.ninja.logic.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author david
 */
public class FileReader {
    
    public static List<String> readImages(String FileName)
    {
      //  String[] names=new String[13]; 
        List<String> names=new ArrayList<>();
        try{
       // File file=new File("C:\\Users\\david\\Desktop\\Programming Project\\Fruit Ninja\\apple.txt");
        File file=new File(FileName);
        Scanner sc=new Scanner(file);
         
        while(sc.hasNextLine())
        names.add(sc.nextLine());
        
        }catch(Exception e){System.out.println(e);}
        
        return names;
    }
    
    
    
    public static List<User> loadUsers() throws ParserConfigurationException
    {
           List<User> users=new ArrayList<User>();
         
    
        try {
            
            //reading from xml file
       File input= new File("Users.txt");  
       DocumentBuilderFactory fFactory=DocumentBuilderFactory.newInstance(); 
       DocumentBuilder fBuilder = fFactory.newDocumentBuilder();
       Document doc;
       
       doc = fBuilder.parse(input);
       
       doc.getDocumentElement().normalize();
       
       //inserting in a node list
       NodeList nodes=doc.getElementsByTagName("User");
       
       if(nodes.getLength()!=0){
       for(int i=0;i<nodes.getLength();i++)
       {
           User temp=null;
           Node p=nodes.item(i);
           if(p.getNodeType()==Node.ELEMENT_NODE)
           {
               Element element=(Element) p;
             
               int score1=Integer.valueOf(element.getElementsByTagName("ScoreLevelOne").item(0).getTextContent());
               int score2=Integer.valueOf(element.getElementsByTagName("ScoreLevelTwo").item(0).getTextContent());
               int score3=Integer.valueOf(element.getElementsByTagName("ScoreLevelThree").item(0).getTextContent());
               int score4=Integer.valueOf(element.getElementsByTagName("ScoreArcade").item(0).getTextContent());
               String name=String.valueOf(element.getElementsByTagName("Name").item(0).getTextContent());
               temp=new User(name,score1,score2,score3,score4);
               users.add(temp);
                   
                       
                  
                }
             }
       }
       else
           users=null;
       
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return users ;
        
    }
        
    }
    
    

