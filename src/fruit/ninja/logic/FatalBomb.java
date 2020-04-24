
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
public class FatalBomb extends GameObject{

    public FatalBomb(double positionX,double positionY,int maxHeight, double velocity) {
        super(positionX,positionY,maxHeight, velocity);
       
        super.setImages("FatalBomb.txt");
    }

    public FatalBomb() {
        super();
         super.setImages("FatalBomb.txt");
    }
    
    @Override
   public void slice(){
       super.slice();
       super.setOver();
   }
   
   @Override
     public void move()  {
         super.move();
     }
}
