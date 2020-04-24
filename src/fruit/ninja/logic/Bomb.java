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
public class Bomb extends GameObject{
    
   

    public Bomb(double positionX,double positionY,int maxHeight, double velocity) {
        super(positionX,positionY,maxHeight, velocity);  
         super.setImages("bomb.txt");
    }

    public Bomb() {
        super();
       super.setImages("bomb.txt");
    }
    
    @Override
   public void slice()
   {
       super.slice();
      super.bombaction();
      
    
   }
   
    @Override
     public void move()  {
         super.move();
     }
    
    
    
    
}
