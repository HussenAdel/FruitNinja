/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.Modes;

/**
 *
 * @author Adel
 */
public class Classicmode implements fruit.ninja.InterFace.Modes{
boolean over=false;
int time=0;
int numOfSlices=0;
    @Override
    public boolean isover() {
       if(numOfSlices==3)
        { 
            over=true;
        }
       else
           over=false;
        return over;
    }

@Override
    public int getTime() {
        return time;
    }

    @Override
    public void missed() {
         numOfSlices++;
    }

    @Override
    public void bombaction() {
        missed();
    }

    @Override
    public void updatetime(int time) {
     this.time=time;
    }

    public int getNumOfSlices() {
        return numOfSlices;
    }
    
    
   
}
