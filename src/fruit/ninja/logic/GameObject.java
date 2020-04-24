
package fruit.ninja.logic;

import fruit.ninja.FileReader.FileReader;
import fruit.ninja.InterFace.IGameObject;
import fruit.ninja.InterFace.Modes;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;
import jdk.nashorn.internal.runtime.arrays.ArrayData;




public abstract class GameObject implements IGameObject {

    private double positionX;
    private double positionY;
    private int maxHeight;
    private double velocity;
    private boolean sliced;
    private double sign;
    private static int score=0;
    private static boolean over=false;
    private Image images[];
    private double initialPosition;
    private double velocityRate;
    private static Modes mode;
    private static int time;
    private double fvelocity;
    private boolean garabge;
    private boolean freeze=false;

    public int getNumOfSlices() {
        return mode.getNumOfSlices();
    }
   
   

    public GameObject(double positionX,double positionY,int maxHeight,double velocity) {
        this.positionX = positionX;
        this.positionY = positionY;   
        this.maxHeight = maxHeight;
        this.velocity=0;
        this.sliced = false;
        this.sign=1.0;
        this.initialPosition=this.positionY;
        this.velocityRate=velocity;
        this.over=false;
        this.score=0;
        this.garabge=false;
        
       
        
        
    }
    public static int getTime() {
        return mode.getTime();
    }

    public static void setMode(Modes mode) {
        GameObject.mode = mode;
    }
    
    public GameObject()
    {
        this.positionX = 0;
        this.positionY = 0;  
        this.maxHeight = 0;
        this.sliced = false;
        this.velocity=0;  
        this.sign=1.0;
        this.garabge=false;
        this.initialPosition=positionY;
    }

    public void setImages(String FileName)  {
        
        List<String> names=new ArrayList<>();
         names= FileReader.readImages(FileName);
            
            this.images=new Image[names.size()];
            
            for(int i=0;i<names.size();i++)
            {
              
             try{this.images[i]=new Image(names.get(i));}
             catch(Exception e){System.out.println(e);}
             
            }
     
    }
    
    
    

  

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

  
    @Override
    public double getPositionX() {
      return positionX;
    }

    @Override
    public double getPositionY() {
        return positionY;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }



    @Override
    public Boolean isSliced() {
      return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return (positionY>initialPosition)? true:false;
    }

    @Override
    public void slice() {
        this.sliced=true;
    }

    @Override
    public void move() {
        
         
             if(garabge){
            
              velocity=6;
              this.positionY+=2*velocity; 
        }
             else {
                 if(!hasMovedOffScreen()){
            double tempY=positionY;
            velocity+=velocityRate;
        if(sign>0)
        { 
            tempY-=velocity;
          if(tempY<=maxHeight) 
          { 
              sign=-1.0;
              velocity=2;
              tempY+=2*velocity;      
          }    
        }
        else
            
             tempY+=velocity;
         this.positionY=tempY;
             }
          
    }
          //  System.out.println("off screen");
        
    }

    int index=0;
    @Override
    public Image getImage() {
        
        Image temp=null;
        
        if(isSliced())
          temp=this.images[this.images.length-1];
        
        else
        {
            
            if(this.images.length>3&&positionY==initialPosition-velocity)
            {  Random random=new Random();
        index=random.nextInt(this.images.length-1);
            }
         temp= this.images[index];
        }
      
      return temp;
    }

    @Override
    public boolean isOver() {
       if (over||mode.isover())
       {
           return true;
       }
       
       
           return false;
    }

    public void setScore(int Score) {
      this.score = this.score+Score;
    }
    
    @Override
    public int getScore(){return score;}
    
    @Override
    public void setOver(){
        over=true;
    }
    
    public void missed()
    {
      mode.missed();
    }
    
    
    public void resetObject(){
    
        this.sliced=false;
        this.positionY=initialPosition;
        this.sign=1.00;
        this.garabge=false;
        this.velocity=0;
   }
    
    public void makeGarbage(){
     this.garabge=true;   
    
    }
    
    
    
    
    @Override
    public void move2(double time)
    {     
      if(!hasMovedOffScreen()){
        double tempY=positionY;
        double gravity=9.8;
        
        if(sign<0)
        { 
            tempY=(sign*(gravity)*Math.pow(time, 2)/2)+positionY;
            
               if(tempY<=maxHeight) 
                 { 
              sign=1.0;
              tempY=(sign*(gravity)*Math.pow(time, 2)/2)+positionY;   
                     System.out.println(tempY);
                 } 
          this.positionY=tempY;
        }
        else    
        { 
            tempY=(sign*(gravity)*Math.pow(time, 2)/2)+positionY;
         this.positionY=tempY;
        }
      
      }
     
    }
    public static void updatetime(int Time)
    {
        mode.updatetime(Time);
    }
    public void bombaction()
    {
        mode.bombaction();
    }
    @Override
    public void freeze()
    {
        if (!freeze)
        {
        fvelocity=velocityRate;
         velocityRate/=10;
         freeze=true;
     }
    }
    @Override
    public void unfreeze()
    {
         freeze=false;
         velocityRate=fvelocity;
    }
    @Override
    public boolean isfreeze()
    {
        return freeze;
    }
}

