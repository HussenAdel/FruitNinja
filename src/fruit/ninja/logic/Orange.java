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
public class Orange extends GameObject {

    public Orange(double positionX,double positionY,int maxHeight, double velocity) {
        super(positionX,positionY,maxHeight, velocity);
         super.setImages("orange.txt");
    }

    public Orange() {
        super();
        super.setImages("orange.txt");
    }
    
    
     @Override
     public void move()  {
         super.move();
         if(!super.isSliced()&&super.hasMovedOffScreen())
         { super.missed();
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
