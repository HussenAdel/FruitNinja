/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

import fruit.ninja.FileReader.FileReader;
import fruit.ninja.FileReader.FileWriter;
import fruit.ninja.logic.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;

/**
 * FXML Controller class
 *
 * @author david
 */
public class UserManagerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private ListView<String> userField;

    @FXML
    private TextField nameField;
    private static List<User> users;

    public static List<User> getUsers() {
        return users;
    }
      
        @FXML
    private Button current;
      
//      private MenuController control;
      private LeaderBoardController control2;
      private boolean isClicked;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isClicked=false;
          users=new ArrayList<>();
//          control=new MenuController();
          control2=new LeaderBoardController();
          userField.setVisible(false);
          nameField.setVisible(false);
                 
        try {
            users=FileReader.loadUsers();
            
            control2.setUsers(users);
            if(users==null)
            {
                current.setVisible(false);
            }
            
            
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        }
        
    }



public void PrintNames()    
{
    if(!isClicked){
    for(int i=0;i<this.users.size();i++)
    {
  
               String label;
               label= (this.users.get(i).getName());
                   userField.getItems().add(label);
            
    }
    
    this.userField.setVisible(true);
    this.nameField.setVisible(false);}
    isClicked=true;
}

public void okPressed(ActionEvent event)
{
    String name=new String();
    User temp=null;
    if(nameField.isVisible())
    {   name=nameField.getText();
       temp=new User(name, 0, 0, 0, 0);
       users.add(temp);
       
    
    }else if(userField.isVisible())
    {
       int index= userField.getSelectionModel().getSelectedIndex();
       temp=users.get(index);
    
      
    }
    
    
        try {
            MenuController.setUser(temp); 
            SceneChanger(event, "Menu.fxml");
        } catch (IOException ex) {
             System.out.println(ex);

        }
    
    
    
}


public void guestPressed(ActionEvent event)
{
    User temp=new User("Guest", 0, 0, 0, 0);
      try {
            MenuController.setUser(temp);
            SceneChanger(event, "Menu.fxml");
        } catch (IOException ex) {
            Logger.getLogger(UserManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}


public void NewPressed()
{
    this.nameField.setVisible(true);
    this.userField.setVisible(false);
    
}








public void SceneChanger(ActionEvent event,String scenename) throws IOException{
        
        
        FileWriter.saveScores(users);
         
          Parent view = FXMLLoader.load(getClass().getResource(scenename));
         Scene sceneNew=new Scene(view);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(sceneNew);
         window.centerOnScreen();
         window.show();
         
        
    }
    
    public void exit()
    {
        System.exit(0);
    }
}
