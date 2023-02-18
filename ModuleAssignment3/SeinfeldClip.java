import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SeinfeldClip implements playable{

        private String filename;
        private String speaker;
        private String year;

    public SeinfeldClip(String filename, String speaker, String year){
        this.filename = filename;
        this.speaker = speaker;
        this.year = year;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void play(String filename){
            System.out.println("Playing " + filename);
            AudioInputStream audioStream;
            try {
               Clip clip = AudioSystem.getClip();
               clip.open(AudioSystem.getAudioInputStream(new File(filename)));
               clip.start();
               Thread.sleep(clip.getMicrosecondLength() / 1000);
               clip.close();
            }
            catch (Exception e) {
               e.printStackTrace(); 
            }
        

    }

    
    // @Override
    // public String toString(){
    //     return;
    // }
    


}