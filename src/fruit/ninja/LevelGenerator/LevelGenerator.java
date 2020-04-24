package fruit.ninja.LevelGenerator;

import fruit.ninja.Factory.GameObjectFactory;
import fruit.ninja.InterFace.IGameObject;
import fruit.ninja.InterFace.Modes;
import static fruit.ninja.LevelGenerator.LevelGenerator.createObject;
import fruit.ninja.Modes.ArcadeMode;
import fruit.ninja.logic.GameObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author david
 */
public class LevelGenerator {
    public static List<IGameObject> makeObjects(Modes mode,int level,int maxWidth,int maxHeight,int preferedHigh,double velocityrate)
    {
        List<IGameObject> temp=new ArrayList<IGameObject> ();
        Random random=new Random();
        GameObjectFactory factory=GameObjectFactory.getFactory();
        int fruit=0,bomb=0,fatalBomb=0,specialFruit=0,i=0,index=1;
        GameObject.setMode(mode);
   if (mode instanceof ArcadeMode)
   {
       fruit=30;
         bomb=10;
         specialFruit=5;
         fatalBomb=0;
       
   }else
   {
        
        if(level==1)
        {
           fruit=20;
           bomb=10;
           fatalBomb=7;
           specialFruit=5;
        }
        
        else if(level==2)
        {
            fruit=20;
           bomb=13;
           fatalBomb=10;
           specialFruit=5;
           
        }
        
        else if(level==3)
        {
            
           fruit=25;
           bomb=10;
           fatalBomb=15;
           specialFruit=5;
            
        }
        else{
            
             fruit=4;
           bomb=2;
           fatalBomb=3;
           specialFruit=4;
        }
              
   }   
        
       try{
        
        for (i=0;i<=fruit;i++)
        {
            index=random.nextInt(3);
            temp.add(createObject(mode,index, maxWidth, maxHeight, preferedHigh,velocityrate));
        }
        
        for (i=0;i<=bomb;i++)
        {
            index=3;
              temp.add(createObject(mode,index, maxWidth, maxHeight, preferedHigh,velocityrate));
        }
        
        
           for (i=0;i<=fatalBomb;i++)
        {
            index=4;
            temp.add(createObject(mode,index, maxWidth, maxHeight, preferedHigh,velocityrate));
        }
        
           
           
            for (i=0;i<=specialFruit;i++)
        {
            if(i%2==0)
            index=6;
            else
             index=5;
            
             temp.add(createObject(mode,index, maxWidth, maxHeight, preferedHigh,velocityrate));
        }
        
       }catch(Exception e)
       {
           System.out.println(e);
       }
       
         
       
        
       
        
        return temp;
    }
    
    public static IGameObject createObject(Modes mode,int index,int maxWidth,int maxHeight,int preferedHigh,double velocityrate)
            
    {
         
        IGameObject temp=null;
        GameObjectFactory factory =GameObjectFactory.getFactory(); 
        Random random=new Random();
        int positionX,positionY=maxHeight+3,maxHigh;
        double velocity;
        
            positionX=random.nextInt(maxWidth-70);
            maxHigh=random.nextInt(preferedHigh);
            velocity=random.nextDouble()*velocityrate;
            if(velocity<velocityrate/2)
             velocity+=velocityrate;
                
            if(maxHigh<50)
                maxHigh=50;
            if (positionX<40)
            {
               positionX=40;
            }
           temp=factory.createObject(index, positionX, positionY, maxHigh,velocity ) ;
           return temp;
    }
    
}
