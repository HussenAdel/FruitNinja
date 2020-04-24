/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

import fruit.ninja.logic.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * FXML Controller class
 *
 * @author david
 */
public class MenuController implements Initializable {
private AudioStream audio;
   private AudioPlayer play;
   private InputStream music;
   private static User user=new User();
   @FXML
   private Button l1;
   @FXML
   private Button l2;
   @FXML
   private Button l3;
    @FXML
   private Button l4;
   private Level2Controller control2;
   private Level3Controller control3;
   private FXMLDocumentController control1;
   private ArcadeController control4;
   private UserManagerController manager;

    public static void setUser(User user) {
        MenuController.user = user;
    }
    /**
     * Initializes the controller class.+
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
  
       
        System.out.println(user.getName());
    try {
        
        music=new FileInputStream(new File("fruit.wav"));
        audio=new AudioStream(music);
            play.player.start(audio);
    } catch (FileNotFoundException ex) {
    } catch (IOException ex) {  
    }   
    
     control2=new Level2Controller();
     control3=new Level3Controller();
     control1= new FXMLDocumentController();
     control4=new ArcadeController();
        
    }  
    
    public void help(ActionEvent event) throws IOException
    {
        play.player.stop(audio);
        SceneChanger(event, "help.fxml");
    }
   
    public void flevel(ActionEvent event) throws IOException
    {
      play.player.stop(audio);
        control4.setUser(user);
        SceneChanger(event, "FXMLMagdy.fxml");
    }
    public void slevel(ActionEvent event) throws IOException
    {
         play.player.stop(audio);
        control2.setUser(user);
        SceneChanger(event, "level2.fxml");
    }
     public void tlevel(ActionEvent event) throws IOException
    {
         play.player.stop(audio);
        control3.setUser(user);
        SceneChanger(event, "level3.fxml");
    }
      public void alevel(ActionEvent event) throws IOException
    {
         play.player.stop(audio);
        control4.setUser(user);
        SceneChanger(event, "FXMLDocument_1.fxml");
    }
     public void classic(ActionEvent event) throws IOException
    {
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
    }
    public void SceneChanger(ActionEvent event,String scenename) throws IOException{
        
        
         
          Parent view = FXMLLoader.load(getClass().getResource(scenename));
         Scene sceneNew=new Scene(view);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(sceneNew);
         window.centerOnScreen();
         window.show();
         
        
    }
     public void mlevel(ActionEvent event) throws IOException
    {
         
        
          play.player.stop(audio);
        control1.setUser(user);
        SceneChanger(event, "FXMLDocument.fxml");
        
    }
    

    public void exit(ActionEvent event) throws IOException
    {
        play.player.stop(audio);
        SceneChanger(event, "UserManager.fxml");
    }
     public void menu(ActionEvent event) throws IOException
    {
        SceneChanger(event, "Menu.fxml");
    }
     
     public void LeaderPressed(ActionEvent event) throws IOException
     {
         play.player.stop(audio);
         SceneChanger(event, "LeaderBoard.fxml");
     }
     
}
