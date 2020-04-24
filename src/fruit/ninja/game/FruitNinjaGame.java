/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

import fruit.ninja.FileReader.FileWriter;
import fruit.ninja.logic.User;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Adel
 */
public class FruitNinjaGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
//        
//        List<User> users=new ArrayList<>();
//        User david=new User("David", 100, 4000, 300, 500);
//         User yehia=new User("yehia", 200, 700, 200, 3000);
//         User Magdy=new User("Magdy", 1000, 300, 120, 250);
//         User hussien=new User("hussien", 12, 30, 50, 10);
//         
//         users.add(david);
//          users.add(yehia);
//           users.add(Magdy);
//            users.add(hussien);
//            
//            FileWriter.saveScores(users);
//         
        Parent root = FXMLLoader.load(getClass().getResource("UserManager.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLMagdy.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
