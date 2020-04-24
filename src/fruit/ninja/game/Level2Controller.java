/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

//import fruit.ninja.Factory.GameObjectFactory;

import fruit.ninja.Factory.GameObjectFactory;
import fruit.ninja.FileReader.FileWriter;
import fruit.ninja.InterFace.ICommand;
import javafx.scene.input.MouseEvent;
import fruit.ninja.InterFace.IGameObject;
import fruit.ninja.LevelGenerator.LevelGenerator;
import fruit.ninja.Modes.Classicmode;
import fruit.ninja.command.Invoker;
import fruit.ninja.command.audio;
import fruit.ninja.command.gameovercommand;
import fruit.ninja.command.slicebombcommand;
import fruit.ninja.command.slicecommand;
import fruit.ninja.command.slicespecialcommand;
import fruit.ninja.logic.Apple;
import fruit.ninja.logic.Banana;
import fruit.ninja.logic.GameObject;
import fruit.ninja.logic.Orange;
import fruit.ninja.logic.SpecialCantaloupe;
import fruit.ninja.logic.SpecialMango;
import fruit.ninja.logic.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Adel
 */
public class Level2Controller implements Initializable {
    private ArrayList<IGameObject> list;
    @FXML
    private Canvas canv;
    @FXML
    private Label score;
    @FXML
    private Label time;
    @FXML
    private Label highscore;
    @FXML
    private ImageView x1;
    @FXML
    private ImageView x2;
    @FXML
    private ImageView x3;
    @FXML
    private ImageView gameover;
    private double x;
    private GraphicsContext gc;
   private double y;
   private GameObjectFactory fact;
   private IGameObject fruit;
   private Stopwatch stop=new Stopwatch();
    private AnimationTimer timer;
     private Random random=new Random();
     private ArrayList<Image>imag;
     private ArrayList<IGameObject> slist;
      EventHandler<MouseEvent> c;
    private int freeze;
    private static User user;
    private audio audio = new audio();
   private ICommand slice = new slicecommand(audio);
   private ICommand slicebomb =new slicebombcommand(audio);
   private ICommand gameover2 = new gameovercommand(audio);
   private ICommand slicespecial=new slicespecialcommand(audio);
   private Invoker remote = new Invoker();

    public void setUser(User user) {
        this.user = user;
    }
    public void SceneChanger(ActionEvent event,String scenename) throws IOException{
        
        
         
          Parent view = FXMLLoader.load(getClass().getResource(scenename));
         Scene sceneNew=new Scene(view);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(sceneNew);
         window.centerOnScreen();
         window.show();
         
        
    }
    @Override
   public void initialize(URL url, ResourceBundle rb) { 
       list=(ArrayList<IGameObject>) LevelGenerator.makeObjects(new  Classicmode(),2,Math.round((float) canv.getWidth()), (int) Math.round(canv.getHeight()),250,0.07);
            x=list.get(0).getPositionX();
            y=list.get(0).getPositionY();
            GraphicsContext gc=canv.getGraphicsContext2D();
            slist=new ArrayList<>();
            imag=new ArrayList<>();
            highscore.setText(" : "+user.getScoreLevelTwo() );
            
timer = new AnimationTimer() {
           
    @Override
    public void handle(long now) {
        
         stop.change(time);
            GameObject.updatetime(stop.getSecs());
                  if (slist.size()>0)
            {
       if (slist.get(0).isfreeze())
             {
                 freeze++;
             }
        if (freeze>400)
        {
            for(int i=0;i<slist.size();i++)
                slist.get(i).unfreeze();
            for (int j=0;j<list.size();j++)
                list.get(j).unfreeze();
            freeze=0;
        }
        
            }
        if (slist.size()==0)
        {
            for (int i=0;i<random.nextInt(3)+1&&i<list.size();i++)
            {
                slist.add(list.remove(random.nextInt(list.size())));
                y=slist.get(i).getPositionY();
                x=slist.get(i).getPositionX();
                imag.add(slist.get(i).getImage());
                gc.drawImage(imag.get(i), x, y, 70, 70);
            }
        }
        
        for (int i=0;i<slist.size();i++)
        {
            slist.get(i).move();
        }
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        for (int i=0;i<slist.size();i++)
        {
            y=slist.get(i).getPositionY();
            if (!slist.get(i).hasMovedOffScreen())
            {
                gc.drawImage(imag.get(i), slist.get(i).getPositionX(), y, 70, 70);
            }
            
            else
            {
                slist.get(i).resetObject();
                list.add(slist.remove(i));
                imag.remove(i);
            }
            if (list.get(0).getNumOfSlices()>=3)
             {
            x3.setVisible(true);
            x2.setVisible(true);
            x1.setVisible(true);
             }
             else if (list.get(0).getNumOfSlices()>=2)
         {
            x1.setVisible(true);
            x2.setVisible(true);
         }
             else if (list.get(0).getNumOfSlices()>=1)
            x1.setVisible(true);
            if (list.get(0).isOver())
            {
                timer.stop();
                   user.setMaxScore(2, list.get(0).getScore());
                gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
                gameover.setVisible(true);
               if (audio.getaudios())
               remote.stop();
                remote.setMusic(gameover2);
                remote.play();
            }
        }
        
    }
};
timer.start();


c = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        
        for (int i=0;i<slist.size();i++)
        {
            double x1=slist.get(i).getPositionX();
            double y1=slist.get(i).getPositionY();
            if (event.getX()>=x1&&event.getX()<=x1+70&&event.getY()>=y1&&event.getY()<=y1+70&&!slist.get(i).isSliced())
            {  
            if (slist.get(i)instanceof Apple || slist.get(i)instanceof Banana || slist.get(i)instanceof Orange)
            {
               if (audio.getaudios())
               remote.stop();
                remote.setMusic(slice);
               
            }   
            else if (slist.get(i)instanceof SpecialCantaloupe)
            {
                    for (int i2=0;i2<slist.size();i2++)
                    {
                        if (slist.get(i2)instanceof Apple || slist.get(i2)instanceof Banana ||slist.get(i2)instanceof SpecialMango || slist.get(i2)instanceof Orange&&!slist.get(i2).isSliced())
                        {
                        slist.get(i2).slice();
                        imag.set(i2,slist.get(i2).getImage());
                 if (slist.get(i2)instanceof SpecialMango)
                        {
                            for (int k =0;k<list.size();k++)
                        list.get(k).freeze();
                    for (int j=0;j<slist.size();j++)
                        slist.get(j).freeze();
                        }
                        }
                    }
if (audio.getaudios())
               remote.stop();
                    remote.setMusic(slicespecial);
            }
            else if (slist.get(i) instanceof SpecialMango)
                {
                  if (audio.getaudios())
               remote.stop();
                    remote.setMusic(slicespecial);
                    for (int k =0;k<list.size();k++)
                        list.get(k).freeze();
                    for (int j=0;j<slist.size();j++)
                        slist.get(j).freeze();
                    
                }
            else 
            {
                if (audio.getaudios())
               remote.stop();
                remote.setMusic(slicebomb);
                
            }
             slist.get(i).slice();
                imag.set(i,slist.get(i).getImage());
                remote.play();
        }
        }
         score.setText(" : "+list.get(0).getScore());
            if (list.get(0).getScore()>user.getScoreLevelTwo())
                    highscore.setText(" :" + list.get(0).getScore());
    }
};
canv.setOnMousePressed(c);
   }   
   
    public void menu(ActionEvent event) throws IOException
    {
        timer.stop();
          if (list.get(0).getScore()>user.getScoreLevelTwo())
           {
                 user.setMaxScore(2, list.get(0).getScore());
           } 
          remote.stop();
       
          FileWriter.saveScores(UserManagerController.getUsers());
        SceneChanger(event, "Menu.fxml");

    }

}
    
