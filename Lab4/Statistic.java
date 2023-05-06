

//a generic superclass which can have many subclasses based on different record types;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.InputMap;

/**
 * A superclass to allow for future expansion in which additional forms
 * of statistics may be introduced.
 * 
 * @author myersjac
 *
 */
public class Statistic implements Serializable{
   
    /**Serializes statistic object */
   public void serializeObject(String filename){
    
    
    try(FileOutputStream fileOut = new FileOutputStream(filename)) {
        
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

   }


   /**Deserializes Statistic object */
   public static Statistic deserializeObject(String filename){

    FileInputStream fileIn = null; //new FileInputStream(filename);
    ObjectInputStream inObject = null; //= new ObjectInputStream(fileIn);
    Statistic stat = null;

    try{
        fileIn = new FileInputStream(filename);
        inObject = new ObjectInputStream(fileIn);
        stat = (Statistic) inObject.readObject();
        inObject.close();
        fileIn.close();
    } catch (FileNotFoundException f){
        f.printStackTrace();
    } catch(ClassNotFoundException b){
        b.printStackTrace();
    } catch (Exception b){
        b.printStackTrace();
    }

    return stat;

   }
   
}
