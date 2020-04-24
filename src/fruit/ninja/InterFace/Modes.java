/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.InterFace;

/**
 *
 * @author Adel
 */
public interface Modes {
    public boolean isover();
    public void missed();
     public void bombaction();
      public void updatetime(int time);
      public int getTime();
      public int getNumOfSlices();
}
