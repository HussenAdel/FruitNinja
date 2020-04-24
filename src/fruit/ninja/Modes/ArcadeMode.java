/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.Modes;

import fruit.ninja.InterFace.Modes;

/**
 *
 * @author Adel
 */
public class ArcadeMode implements Modes{

    
boolean over=false;
int time=60;
    @Override
    public boolean isover() {
       return over;
    }

    @Override
    public void missed() {
    }
@Override
    public int getTime() {
        return time;
    }
    @Override
    public void bombaction() {
       time-=10;
    }

    @Override
    public void updatetime(int time) {
       this.time-=time;
      if (this.time==0)
      {
          over=true;
      }
    }

    @Override
    public int getNumOfSlices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
