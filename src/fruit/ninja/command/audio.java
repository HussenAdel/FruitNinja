/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Adel
 */
public class audio {
      AudioStream audio;
    AudioPlayer play;
    InputStream music;
    private boolean audios=false;
    public void sliceaudio()
    {
          try {
              music=new FileInputStream(new File("slice.wav"));
              audio=new AudioStream(music);
              play.player.start(audio);
              audios=true;
          } catch (FileNotFoundException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public void gameoveraudio()
    {
         try {
              music=new FileInputStream(new File("Fruit Ninja gameover.wav"));
              audio=new AudioStream(music);
              play.player.start(audio);
              audios=true;
          } catch (FileNotFoundException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      public void slicebomb()
    {
         try {
              music=new FileInputStream(new File("Fruit Ninja bomb.wav"));
              audio=new AudioStream(music);
              play.player.start(audio);
              audios=true;
          } catch (FileNotFoundException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
        public void slicespecialaudio()
    {
         try {
              music=new FileInputStream(new File("Fruit Ninja s.wav"));
              audio=new AudioStream(music);
              play.player.start(audio);
              audios=true;
          } catch (FileNotFoundException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(audio.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
        public void stop()
        {
            play.player.stop(audio);
        }
        public boolean getaudios()
        {
            return audios;
        }
}
