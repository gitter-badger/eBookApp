/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author Jimmy
 */
public class muzic {
private static String filename;
private static Player player;
public static void play() {
        try {
            FileInputStream fis     = new FileInputStream("src/sound/1.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            @Override
            public void run() {
                try { player.play();
                      //player.play();

                }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();

    }

    public void close()
       {
           player.close();
       }
    
}
