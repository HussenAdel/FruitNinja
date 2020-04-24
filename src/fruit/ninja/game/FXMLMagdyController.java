/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import fruit.ninja.Factory.GameObjectFactory;
import fruit.ninja.InterFace.IGameObject;
import fruit.ninja.LevelGenerator.LevelGenerator;
import fruit.ninja.Modes.ArcadeMode;
import fruit.ninja.Modes.Classicmode;
import fruit.ninja.logic.Apple;
import fruit.ninja.logic.GameObject;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author david
 */
public class FXMLMagdyController implements Initializable {

    
    private double t1 = 0, t2 = 0;
    private int counter = 0, comboCounter = 0;
    private boolean isCombo = false, in = false;
    //ArcadeMode mode=new ArcadeMode();
    //IGameObject checker=new Apple();
    
    
    @FXML
    Pane root;
     private ArrayList<IGameObject> objects = new ArrayList<IGameObject>();
    private   ArrayList<IGameObject> current = new ArrayList<IGameObject>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
       StackPane spane = new StackPane();
        spane.setPrefSize(26, 26);
        
       Text score = new Text();
        score.setFill(Color.SNOW);
       score.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
       score.setEffect(new Bloom());
       Random random = new Random();
        
        spane.getChildren().add(score);
        
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);

       Image bg = new Image("background.jpg");
        Image combo = new Image("22.PNG");
        Image x = new Image("x.png");
        Image gameover = new Image("GameOver.png");
        
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);

        Canvas canvas = new Canvas(1200, 800);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();

  objects=(ArrayList<IGameObject>) LevelGenerator.makeObjects(new Classicmode(),4,Math.round((float) canvas.getWidth()), (int) Math.round(canvas.getHeight()),250,0.01);
        ArrayList<IGameObject> current = new ArrayList<IGameObject>();

        current.add(objects.get(random.nextInt(objects.size())));
        current.add(objects.get(random.nextInt(objects.size())));


        final long startNanoTime = System.nanoTime();

        canvas.setOnMouseClicked((MouseEvent event) -> {
            for (int i = 0; i < current.size(); ++i) {
                if (current.get(i).getPositionY() - event.getSceneY() <= 75
                        && current.get(i).getPositionY() - event.getSceneY() >= -75
                        && current.get(i).getPositionX() - event.getSceneX() <= 45
                        && current.get(i).getPositionX() - event.getSceneX() >= -45) {
                    if (!current.get(i).isSliced()) {
                        current.get(i).makeGarbage();
                        current.get(i).slice();
                        if (counter % 2 == 0) 
                            t1 = Double.parseDouble(df.format((System.nanoTime() / 1000000000.0) - (int) (System.nanoTime() / 1000000000.0)));
                        else 
                            t2 = Double.parseDouble(df.format((System.nanoTime() / 1000000000.0) - (int) (System.nanoTime() / 1000000000.0)));
                        
                        ++counter;
                        if (t1 - t2 <= 0.001 && t1 - t2 >= -0.001) 
                            isCombo = true;
                    }
                }
            }

        });
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                
                int intT;
                boolean yes = false;
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                try {

                    for (int i = 0; i < current.size(); ++i) 
                        if (current.get(i).hasMovedOffScreen()) {
                            current.get(i).resetObject();
                            objects.add(current.get(i));
                            current.remove(i);
                           yes = true;
                        }      
                    intT = (int) t;
                    if ((intT % 20 == 0 && t - intT < 0.05) || yes) 
                        for (int i = 0; i < 2; ++i) {
                            int x = random.nextInt(objects.size());
                            if (x > 0) {
                                IGameObject obj = objects.get(x);
                                objects.remove(x);
                                current.add(obj);
                                yes = false;
                            }
                        }
                    
                    gc.fillRect(0, 0, 1200, 800);
                    
                    gc.drawImage(bg, 0, 0, 1200, 800);
                    score.setText("Score: " +objects.get(0).getScore());  
                    gc.drawImage(spane.snapshot(parameters, null), 10, 10);
                    
                     for (int i = 0; i < current.size(); ++i){
                        current.get(i).move();
                        render(current.get(i), gc);
                     }
                     
                    if (isCombo) {
                        ++comboCounter;
                        if (in && comboCounter>20){ 
                                isCombo = false;
                                in = false;
                                comboCounter = 0;
                            }
                         else 
                            in = true;
                        gc.drawImage(combo, 370, 350, 400, 100);
                    }
                  
                    if (objects.get(0).getNumOfSlices() >=1) {
                            gc.drawImage(x, 320, 10);
                       if (objects.get(0).getNumOfSlices() >= 2)
                            gc.drawImage(x, 370, 10);
                        if (objects.get(0).getNumOfSlices() >= 3) 
                            gc.drawImage(x, 400, 10);
                     }
                   
                    if (objects.get(0).isOver()) {
                        gc.drawImage(gameover, 300, 350, 600, 80);
                        this.stop();
                    }

                } catch (Exception e) {
                    System.out.println(e);
            }
            }

        }.start();
        
       

}
    
    
    
    
     void render(IGameObject object, GraphicsContext gc) {
        gc.drawImage(object.getImage(), object.getPositionX(), object.getPositionY(), 50, 50);
    }

}
    
    

