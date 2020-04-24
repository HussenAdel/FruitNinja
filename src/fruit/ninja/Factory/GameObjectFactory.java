/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.Factory;


import fruit.ninja.InterFace.IGameObject;
import fruit.ninja.logic.Apple;
import fruit.ninja.logic.Banana;
import fruit.ninja.logic.Bomb;
import fruit.ninja.logic.FatalBomb;
import fruit.ninja.logic.Orange;
import fruit.ninja.logic.SpecialCantaloupe;
import fruit.ninja.logic.SpecialMango;

/**
 *
 * @author david
 */
public class GameObjectFactory {
    
    private static final GameObjectFactory instance=new GameObjectFactory();
    
    private GameObjectFactory(){}
    
    public static GameObjectFactory getFactory(){return instance;}
    
        
    
    public IGameObject createObject(int num,double positionX,double positionY,int height,double velocity)
    {
        IGameObject temp=null;
        
        switch (num) {
            case 0:
                temp =new Apple(positionX,positionY,height, velocity);
                break;
            case 1:
                temp =new Banana(positionX,positionY,height, velocity);
                break;
            case 2:
                temp =new Orange(positionX,positionY,height, velocity);
                break;
            case 3:
                temp =new Bomb(positionX,positionY,height, velocity);
                break;
            case 4:
                temp =new FatalBomb(positionX,positionY,height, velocity);
                break;
            case 5:
                temp=new SpecialCantaloupe(positionX,positionY,height, velocity);
                break;
            case 6:
                temp=new SpecialMango(positionX,positionY,height, velocity);
                break;   
            default:
                System.out.println("Invalid object index");
                break;
        }
        
        return temp;
    }
    
}
