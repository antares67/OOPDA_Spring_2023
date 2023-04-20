
/**
 * 
 * @param searchTerm
 * @return
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Notebook {
    private ArrayList<String> notes = new ArrayList<String>();

    /**
     * getter for full arraylist
     */
    public ArrayList<String> getNotes() {
        return notes;
    }

    /**
     * Set full notebook equal to a specified arraylist
     */
    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    /**
     * Returns the size of the notebook
     * 
     * @return
     */
    public int numberOfNotes() {
        int size = notes.size();
        return size;
    }

    /**
     * Add an individual element to the notebook. It will offset other elements
     * that come later in the arraylist. If an element is added at index 2 when
     * index 2 is already populated, the element at index 2 originally is shifted
     * to index 3.
     * 
     * @param index
     * @param element
     */
    public void addNote(int index, String element) {
        int check = 0;

        if (index >= 0 && index <= notes.size()) {
            if (notes.size() > 0) {
                for (int i = 0; i < notes.size(); i++) {
                    if (notes.get(i).equals(element)) {
                        check = 1;
                    }
                }

                if (check == 1) {
                    System.out.println("Duplicate notes are not permitted");
                } else {
                    notes.add(index, element);
                }
            } else {
                notes.add(index, element);
            }
        } else {
            System.out.println("Out of current list range!");
        }

    }

    /**
     * Deletes an element at a chosen index. Elements
     * that come later will be shifted backwards to
     * fill the space of the deleted element.
     * 
     * @param index
     */
    public void deleteNote(int index) {

        notes.remove(index);

    }

    /**
     * Returns the index of the first occurence of a string stored in the arraylist
     * 
     * @param searchTerm
     * @return index of located search term
     */
    public int getNoteNumber(String searchTerm) {
        int index = notes.indexOf(searchTerm);
        return index;
    }

    /**
     * Returns the element stored at a specified index.
     * 
     * @param index
     * @return The string saved at the given index
     */

    public String getNote(int index) {
        String note = notes.get(index);
        return note;
    }

    /**
     * Sets an existing element at specified index to new string
     * 
     * @param index
     * @param note
     */
    public void setNote(int index, String note) {
        notes.set(index, note);
    }

    /**
     * Swaps an element with its next higher neighbor
     * 
     * @param note
     */
    public void moveNoteUp(String note) {
        int index = getNoteNumber(note);
        String specifiedNote = getNote(index);
        String noteAbove = getNote(index + 1);

        notes.set(index + 1, specifiedNote);
        notes.set(index, noteAbove);
    }

    /**
     * Swaps an element with its next lower neighbor
     * 
     * @param note
     */
    public void moveNoteDown(String note) { // specify note by its text
        int index = getNoteNumber(note);
        String specifiedNote = getNote(index);
        String noteAbove = getNote(index - 1);

        notes.set(index - 1, specifiedNote);
        notes.set(index, noteAbove);
    }

    /**
     * Moves a specified element up in the list by the specified number of loops
     * 
     * @param note
     * @param loop
     */
    public void moveNoteUpLoop(String note, int loop) {

        if ((getNoteNumber(note) + loop) >= notes.size()) {
            System.out.println("You are trying to move the specified note too many spaces");
            System.out.println("-------------------Operation Cancelled-------------------");
        } else {
            for (int i = 0; i < loop; i++) {
                int index = getNoteNumber(note);
                String specifiedNote = getNote(index);
                String noteAbove = getNote(index + 1);

                notes.set(index + 1, specifiedNote);
                notes.set(index, noteAbove);
            }
        }
    }

    /**
     * Moves a specified element down in the list by the specified number of loops
     * 
     * @param note
     * @param loop
     */
    public void moveNoteDownLoop(String note, int loop) { // specify note by its text

        if ((getNoteNumber(note) - loop) < 0) {
            System.out.println("You are trying to move the specified note too many spaces");
            System.out.println("-------------------Operation Cancelled-------------------");
        } else {
            for (int i = 0; i < loop; i++) {
                int index = getNoteNumber(note);
                String specifiedNote = getNote(index);
                String noteAbove = getNote(index - 1);

                notes.set(index - 1, specifiedNote);
                notes.set(index, noteAbove);

            }
        }
    }

    /**
     * Moves the specified element to the top of the list
     * 
     * @param note
     */

    public void moveNoteToTop(String note) {
        // get element position
        // delete the original location
        // create a copy of the original at the top
        int index = getNoteNumber(note);
        deleteNote(index);
        addNote(notes.size(), note);

    }

    /**
     * Moves the specified element to the bottom of the list
     * 
     * @param note
     */

    public void moveNoteToBottom(String note) {
        int index = getNoteNumber(note);
        deleteNote(index);
        addNote(0, note);

    }

}