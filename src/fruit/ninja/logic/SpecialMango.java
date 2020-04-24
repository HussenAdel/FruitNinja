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
public class SpecialMango extends GameObject {

    public SpecialMango(double positionX,double positionY,int maxHeight, double velocity) {
        super(positionX,positionY,maxHeight, velocity);
        super.setImages("special2.txt");
    }

    public SpecialMango() {
        super();
         super.setImages("special2.txt");
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
