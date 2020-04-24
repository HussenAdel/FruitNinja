/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.InterFace;

import javafx.scene.image.Image;

/**
 *
 * @author david
 */
public interface IGameObject {
    public double getPositionX();
    public double getPositionY();
    public int getMaxHeight();
    public double getVelocity();
    public Boolean isSliced();
    public Boolean hasMovedOffScreen();
    public void slice();
    public void move();
    public Image getImage();  
    public  boolean isOver();
    public int getScore();
    public void setOver();
    public int getNumOfSlices();
    public void missed();
    public void move2(double time);
    public void resetObject();
    public void setScore(int Score);
    public void freeze();
    public boolean isfreeze();
    public void unfreeze();
    public  void makeGarbage();
    
}
