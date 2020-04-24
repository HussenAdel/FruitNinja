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
public class SpecialCantaloupe extends GameObject{

    public SpecialCantaloupe(double positionX,double positionY,int maxHeight, double velocity) {
        super (positionX,positionY,maxHeight, velocity);
        super.setImages("special.txt");
    }

    public SpecialCantaloupe() {
        super();
        super.setImages("special.txt");
    }
    
    
     @Override
    public void slice(){
        super.slice();
        super.setScore(10);
    }
    @Override
     public void move()  {
         super.move();
         if(!super.isSliced()&&super.hasMovedOffScreen())
         { 
            super.slice();
         }
         
    
     
     }
}
