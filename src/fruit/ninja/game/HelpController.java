/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author david
 */
public class HelpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
    }  
    
    
    
    
    public void menu(ActionEvent event) throws IOException
    {
        SceneChanger(event, "Menu.fxml");
    }
    public void lvl1(ActionEvent event) throws IOException
    {
        SceneChanger(event, "lvl1.fxml");
    }
     public void lvl2(ActionEvent event) throws IOException
    {
        SceneChanger(event, "lvl2.fxml");
    }
    
    public void SceneChanger(ActionEvent event,String scenename) throws IOException{
        
        
         
          Parent view = FXMLLoader.load(getClass().getResource(scenename));
         Scene sceneNew=new Scene(view);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(sceneNew);
         window.centerOnScreen();
         window.show();
         
        
    }
    
    

    
     public void help(ActionEvent event) throws IOException
    {
        SceneChanger(event, "help.fxml");
    }
}
