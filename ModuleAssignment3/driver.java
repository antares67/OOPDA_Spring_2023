import java.util.ArrayList;

public class driver {

    public static void main(String[] args) {

        ArrayList<playable> playlist = new ArrayList<playable>();

        playlist.add(new GOTclip("GameOfThrones-Joffrey.gif", "Joffrey Baratheon"));
        playlist.add(new GOTclip("GameOfThrones-Jon.gif", "Jon Snow"));
        playlist.add(new SeinfeldClip("Seinfeld-Jerry.wav", "Jerry", "1997"));
        playlist.add(new SeinfeldClip("Seinfeld-Kramer.wav", "Kramer", "1993"));

        for(playable playable : playlist){
            playable.play(playable.getFilename());
        }
    
    }


    
}
