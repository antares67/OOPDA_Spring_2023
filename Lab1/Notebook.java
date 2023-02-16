import java.util.ArrayList;
import java.util.Scanner;

public class Notebook {
    private ArrayList<String> notes = new ArrayList<String>();

    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    public int numberOfNotes(){
        int size = notes.size();
        return size;
    }

    public void addNote(int index, String element){

        notes.set(index, element);

    }

    public void deleteNote(int index){

        notes.remove(index);
        

    }


    public int getNoteNumber(String searchTerm){
        //this can be replaced by .indexOf()

        int posValue = 0; //initialize

        for(int i = 0; i < notes.size(); i++){ //iterate through arraylist
           
            String element = notes.get(i); //set element variable equal to the element string being checked
          
            if(element == searchTerm){ //if the element string is equal to the users desired string, store and return the current element
                posValue = i;
                //return posValue;
            } 

        }

        return posValue;
    }

    public String getNote(int index){
        String note = notes.get(index);
        return note;
    }

}



/*
 * ·        addNote() will add an individual note to the ArrayList 

·        deleteNote() will delete a note using its position in the ArrayList

·        getNoteNumber() will get the position of a note based on its value, e.g., in what position is note "Buy milk"?

·        getNote() will get the note text for a given position

·        setNote() will set (update) the note text for a given position
 * 
 */