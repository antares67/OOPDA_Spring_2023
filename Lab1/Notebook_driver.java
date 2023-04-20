
/**
 * 
 * @param searchTerm
 * @return
 */

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

public class Notebook_driver {
    public static void main(String args[]) {
        Notebook notebook1 = new Notebook();
        Scanner inStream = new Scanner(System.in);
        // ArrayList<String> testList = new ArrayList<String>();

        System.out.println("Welcome... to your Notebook!");
        System.out.println(" ");
        mainMenu();
        String userInputQuit = "null";
        String userInput = "";

        do {
            System.out.print("C:\\User\\yourname> ");
            userInput = inStream.nextLine();
            if (userInput == "") {
                userInput = inStream.nextLine();
            }

            switch (userInput) {

                case "menu": // command options
                    mainMenu();
                    break;
                case "gl": // get list
                    System.out.println(notebook1.getNotes());
                    break;
                case "gs": // get size
                    System.out.println(notebook1.numberOfNotes());
                    break;
                case "an": // add note

                    System.out.print("Enter note text: ");
                    String note = inStream.nextLine();
                    System.out.print("Enter index: ");
                    int index = inStream.nextInt();
                    notebook1.addNote(index, note);
                    break;

                case "dn": // delete note

                    System.out.print("Enter index: ");
                    index = inStream.nextInt();
                    notebook1.deleteNote(index);
                    break;

                case "gn": // get note

                    System.out.print("Enter index: ");
                    index = inStream.nextInt();
                    System.out.println(notebook1.getNote(index));
                    break;

                case "gnn": // get note number

                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    System.out.println(notebook1.getNoteNumber(note));
                    break;

                case "sn": // set note

                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    System.out.print("Enter index: ");
                    index = inStream.nextInt();
                    notebook1.setNote(index, note);
                    break;

                case "mu": // move up

                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    notebook1.moveNoteUp(note);
                    break;

                case "mul": // move up looped
                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    System.out.print("Enter how many times to move element up: ");
                    index = inStream.nextInt();
                    notebook1.moveNoteUpLoop(note, index);
                    break;

                case "md": // move down

                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    notebook1.moveNoteDown(note);
                    break;

                case "mdl": // move down looped

                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    System.out.print("Enter how many times to move element down: ");
                    index = inStream.nextInt();
                    notebook1.moveNoteDownLoop(note, index);
                    break;

                case "mtt": // move to top

                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    notebook1.moveNoteToTop(note);
                    break;

                case "mtb": // move to bottom
                    System.out.print("Enter note text: ");
                    note = inStream.nextLine();
                    notebook1.moveNoteToBottom(note);
                    break;
                case "q": // quit
                    userInputQuit = "q";
                    break;

                default:
                    System.out.println("Not a valid command");
                    break;
                // Java code;
            }

        } while (userInputQuit != "q");

        System.out.println("Until next time...");

        // System.out.println("Note list: " + notebook1.getNotes());
        // System.out.println("Note list size: " + notebook1.numberOfNotes());

        // notebook1.moveNoteToTop("pos3");
        // //notebook1.moveNoteUpLoop("pos3", 3);

        // System.out.println("Note list: " + notebook1.getNotes());
        // System.out.println("Note list size: " + notebook1.numberOfNotes());

    }

    public static void mainMenu() {

        System.out.println("-----------Main Menu-----------");
        System.out.println("--------Command Options--------");
        System.out.println("Menu-----------------------menu");
        System.out.println("quit--------------------------q");
        System.out.println("Get List---------------------gl");
        System.out.println("Get List Size----------------gs");
        System.out.println("Add Note---------------------an");
        System.out.println("Delete Note------------------dn");
        System.out.println("Get Note---------------------gn");
        System.out.println("Get Note Number-------------gnn");
        System.out.println("Set Note---------------------sn");
        System.out.println("Move Up----------------------mu");
        System.out.println("Move Up Looped--------------mul");
        System.out.println("Move Down--------------------md");
        System.out.println("Move Down Looped------------mdl");
        System.out.println("Move To Top-----------------mtt");
        System.out.println("Move To Bottom--------------mtb");
        System.out.println(" ");

    }

}