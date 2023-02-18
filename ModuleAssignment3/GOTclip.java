import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GOTclip implements playable{

    private String filename;
    private String character;

    public GOTclip(String filename, String character){
        this.filename = filename;
        this.character = character;
    }


    public String getFilename() {
        return filename;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }


    public String getCharacter() {
        return character;
    }


    public void setCharacter(String character) {
        this.character = character;
    }


    public void play(String filename){

        System.out.println("Playing " + filename);
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(filename);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.pack(); 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(filename.length()* 10, filename.length() * 10);
        frame.setVisible(true);

    }

    }