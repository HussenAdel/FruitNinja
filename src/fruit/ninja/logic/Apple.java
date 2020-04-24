/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.logic;

import fruit.ninja.InterFace.IGameObject;

/**
 *
 * @author david
 */
public class Apple extends GameObject {

    public Apple(double positionX,double positionY,int maxHeight, double velocity) {
        super(positionX,positionY,maxHeight, velocity);
        
     super.setImages("apple.txt");
       
        
    }

    public Apple() {
        super();
       super.setImages("apple.txt");

    }
    
   
    @Override
     public void move()  {
         super.move();
         if(!super.isSliced()&&super.hasMovedOffScreen())
         { 
             super.missed();
             super.slice();
          // super.resetObject();
         }
         
    
     
     }
     
   
           
    
    

    @Override
     public void slice() {
       super.slice();
       super.setScore(1);
  
    }

}
