/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.command;

import fruit.ninja.InterFace.ICommand;

/**
 *
 * @author Adel
 */
public class slicebombcommand implements ICommand{
        audio audio = new audio();
    public slicebombcommand(audio audio) {
this.audio=audio;
    }

    @Override
    public void excute()  {
        audio.slicebomb();
    }

    @Override
    public void unexcute() {
       audio.stop();
    }
    
    
}
