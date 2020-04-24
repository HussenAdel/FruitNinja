/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.logic;

/**
 *
 * @author david
 */
public class Banana extends GameObject{

    public Banana(double positionX,double positionY,int maxHeight, double velocity) {
        super(positionX,positionY,maxHeight, velocity);
             super.setImages("straw.txt");

    }

    public Banana() {
        super();
             super.setImages("straw.txt");

    }
    
 @Override
     public void move()  {
         super.move();
         if(!super.isSliced()&&super.hasMovedOffScreen())
         { super.missed();
            super.slice();
         }
         
     }
     
      @Override
     public void slice() {
       super.slice();
       super.setScore(1);
  
    }
}
