package MazeGame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Audio implements LineListener {
    File popUpAudio = new File("monsteraudio.wav"), gameMenuAudio = new File("gamemenuaudio.wav");
    boolean playCompleted;

    public void playGameMenuAudio(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(gameMenuAudio);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();

            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            audioClip.close();

        } catch (UnsupportedAudioFileException ex){
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }

    public void playPopUpAudio() {
          try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(popUpAudio);
                DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
                Clip audioClip = (Clip) AudioSystem.getLine(info);
                audioClip.addLineListener(this);
                audioClip.open(audioStream);
                audioClip.start();

                while (!playCompleted) {
                    // wait for the playback completes
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                audioClip.close();

            } catch (UnsupportedAudioFileException ex){
                System.out.println("The specified audio file is not supported.");
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                System.out.println("Audio line for playing back is unavailable.");
                ex.printStackTrace();
            } catch (IOException ex) {
                System.out.println("Error playing the audio file.");
                ex.printStackTrace();
            }
        }
    /*
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.START) {
            System.out.println("Playing Audio");
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
    }
  }