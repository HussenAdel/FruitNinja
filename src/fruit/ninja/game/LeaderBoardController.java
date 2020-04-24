/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

import fruit.ninja.FileReader.FileReader;
import fruit.ninja.logic.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javax.xml.parsers.ParserConfigurationException;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author david
 */
public class LeaderBoardController implements Initializable {

   static List<User>  users=new ArrayList<>();

    public void setUsers(List<User> users) {
        this.users = users;
    }
    @FXML
    VBox l1,l2,l3,l4;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
  
       
        List<Integer> levelOne=new ArrayList<>();
        List<Integer> levelTwo=new ArrayList<>();
        List<Integer> levelThree=new ArrayList<>();
        List<Integer> levelArcade=new ArrayList<>();
        
        for(int i=0 ;i<users.size();i++)
        {
             Text t1 = new Text();
              Text t2 =new Text();
              Text t3 = new Text();
              Text t4 =new Text();
              
              
             t1.setText(users.get(i).getName()+"  "+users.get(i).getScoreLevelOne()); 
              t2.setText(users.get(i).getName()+"  "+users.get(i).getScoreLevelTwo()); 
               t3.setText(users.get(i).getName()+"  "+users.get(i).getScoreLevelThree()); 
                t4.setText(users.get(i).getName()+"  "+users.get(i).getScoreArcade()); 
             
             t1.setTextAlignment(TextAlignment.CENTER);
             t2.setTextAlignment(TextAlignment.CENTER);
             t3.setTextAlignment(TextAlignment.CENTER);
             t4.setTextAlignment(TextAlignment.CENTER);
             
             
               t1.setFill(Color.SNOW);
           t1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
           t1.setEffect(new Bloom());
             
           
             
               t2.setFill(Color.SNOW);
           t2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
           t2.setEffect(new Bloom());
             
           
             
               t3.setFill(Color.SNOW);
           t3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
           t3.setEffect(new Bloom());
             
           
             
           t4.setFill(Color.SNOW);
           t4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
           t4.setEffect(new Bloom());
             
             
             l1.getChildren().add(t1);
             l2.getChildren().add(t2);
             l3.getChildren().add(t3);
             l4.getChildren().add(t4);
  
        
               
              
        }
        
        
          
    }
    
    
    
      public void backPressed(ActionEvent event) throws IOException{
        
        
         
          Parent view = FXMLLoader.load(getClass().getResource("Menu.fxml"));
         Scene sceneNew=new Scene(view);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(sceneNew);
         window.centerOnScreen();
         window.show();
         
        
    }
    
    
}
