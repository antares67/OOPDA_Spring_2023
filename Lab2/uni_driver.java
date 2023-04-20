
/**
 * Author: Thomas Rasa
 * 3/9/23
 */

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class uni_driver {
    static String evaluatorType;
    public static Map<Long, Person> uniRoster = new HashMap<>();

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("How should we evaluate? ");
        evaluatorType = sc.nextLine();

        makePerson();
        makeInstructor();
        makeStudent();

        printDetails();

        sc.close();
    }

    /**
     * Iterates through the Hashmap containing the details of each
     * Person object in the university using forEach()
     */
    public static void printDetails() {
        // System.out.println(uniRoster);

        uniRoster.forEach((key, e) -> {

            System.out.println(e.getId());
            System.out.println(e.toString());
            System.out.println(e.getEmail());
            System.out.println(e.getLast4SSN());

            if (e instanceof Instructor) {
                Instructor f = (Instructor) e;
                System.out.println(f.getDepartment());
            } else if (e instanceof Student) {
                Student f = (Student) e;
                System.out.println(f.getMajor());
            }
            

            Person tempPerson = Person.findperson(evaluatorType, uniRoster);

            if (evaluatorType.equals("oldest")) {

                if (e.equals(tempPerson)) {
                    System.out.println("oldest: true");
                } else {
                    System.out.println("oldest: false");
                }
            }

            if (evaluatorType.equals("youngest")) {
                if (e.equals(tempPerson)) {
                    System.out.println("youngest: true");
                } else {
                    System.out.println("youngest: false");
                }
            }

            System.out.println("");

        });

    }

    /**
     * Creates person object
     */
    private static void makePerson() {
        Scanner sc = new Scanner(System.in);
        String firstName, middleName, lastName, email, ssn;
        int age;

        System.out.print("Enter Person's first name: ");
        firstName = sc.nextLine();

        System.out.print("Enter Person's middle name: ");
        middleName = sc.nextLine();

        System.out.print("Enter Person's Last name: ");
        lastName = sc.nextLine();

        System.out.print("Enter Person's email: ");
        email = sc.nextLine();

        System.out.print("Enter Person's SSN: ");
        ssn = sc.nextLine();

        do {
            System.out.print("Enter Person's age: ");
            age = sc.nextInt();

            if (age <= 16) {
                System.out.println("Age must be greater than 16 years");
            }
        } while (age <= 16);

        Person createdPerson = new Person(firstName, middleName, lastName, email, ssn, age);

        uniRoster.put(createdPerson.getId(), createdPerson);

    }

    /**
     * Creates Instructor object
     * 
     */
    private static void makeInstructor() {
        String firstName, middleName, lastName, email, ssn, department;
        int age;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Instructor's first name: ");
        firstName = sc.nextLine();

        System.out.print("Enter Instructor's middle name: ");
        middleName = sc.nextLine();

        System.out.print("Enter Instructor's Last name: ");
        lastName = sc.nextLine();

        System.out.print("Enter Instructor's email: ");
        email = sc.nextLine();

        System.out.print("Enter Instructor's SSN: ");
        ssn = sc.nextLine();

        System.out.print("Enter Instructor's Department: ");
        department = sc.nextLine();

        do {

            System.out.print("Enter Instructor's age: ");
            age = sc.nextInt();

            if (age <= 16) {
                System.out.println("Age must be greater than 16 years");
            }
        } while (age <= 16);

        Instructor createdInstructor = new Instructor(firstName, middleName, lastName, email, ssn, age, department);

        uniRoster.put(createdInstructor.getId(), createdInstructor);

    }

    /**
     * Creates students object
     */
    private static void makeStudent() {
        String firstName, middleName, lastName, email, ssn, major;
        int age;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student's first name: ");
        firstName = sc.nextLine();

        System.out.print("Enter Student's middle name: ");
        middleName = sc.nextLine();

        System.out.print("Enter Student's Last name: ");
        lastName = sc.nextLine();

        System.out.print("Enter Student's email: ");
        email = sc.nextLine();

        System.out.print("Enter Student's SSN: ");
        ssn = sc.nextLine();

        System.out.print("Enter Student's major: ");
        major = sc.nextLine();

        do {

            System.out.print("Enter Student's age: ");
            age = sc.nextInt();

            if (age <= 16) {
                System.out.println("Age must be greater than 16 years");
            }
        } while (age <= 16);

        System.out.println("");
        Student createdStudent = new Student(firstName, middleName, lastName, email, ssn, age, major);

        uniRoster.put(createdStudent.getId(), createdStudent);
    }

}