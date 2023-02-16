import java.util.ArrayList;

public class Notebook_driver{
    public static void main(String args[]){
        Notebook notebook1 = new Notebook();
        ArrayList<String> testList = new ArrayList<String>();
        char cont = ' ';

        do{
            System.out.println();

        } while (cont == 'y');


        System.out.println("Note list: " + notebook1.getNotes());
        System.out.println("Note list size: " + notebook1.numberOfNotes());

        
    }
    
}