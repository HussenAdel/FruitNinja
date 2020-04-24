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
public class Invoker {
    private ICommand music;

    public void setMusic(ICommand music) {
        this.music = music;
    }
    public void play()
    {
        music.excute();
    }
    public void stop()
    {
        music.unexcute();
    }
}
