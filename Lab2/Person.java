
    /**
     * Author: Thomas Rasa
     * 3/12/23
     */


import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Person {

    private long id;
    public static long lastid = 916421998; // needs to be static so this remains
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String ssn;
    public static int lastAge = -1;
    private int age;
    public static int initial;
    public static HashMap<String, Predicate<Person>> predicatesortMethods = new HashMap<String, Predicate<Person>>();
    public static Map.Entry<Long, Person> entry; // = new Map<Long,Person>(); //= new Map.Entry<Long, Person>();

    public Person(String firstName, String middleName, String lastName, String email, String ssn, int age) {

        lastAge = this.age;
        this.age = age;
        this.id = lastid + 1; // Account for initial id number and update previous each time new person is
                              // created
        this.lastid = this.id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.ssn = ssn;
        // this.age = age;

    }


    /**
     * Method which utilizes a predicate in order to evaluate which Person 
     * stored on the university roster matches the evaluator type
     * @param predicate
     * @param map
     * @return
     */
    public static Person findperson(String predicate, Map<Long, Person> map) {
        entry = map.entrySet().iterator().next(); // Map.Entry<Long, Person>
        initial = entry.getValue().getAge();
        Person person = entry.getValue();

        //oldest
        Predicate<Person> oldest = (e) -> {
            return ((e).getAge() > initial);
        };

        //youngest
        Predicate<Person> youngest = (e) -> {
            return ((e).getAge() < initial);
        };
        
        predicatesortMethods.put("oldest", oldest);
        predicatesortMethods.put("youngest", youngest);

        Predicate<Person> predicateForAge = predicatesortMethods.get(predicate);

        for (Person per : uni_driver.uniRoster.values()) {
            if (predicateForAge.test(uni_driver.uniRoster.get(per.id))) {
                initial = per.getAge();
                person = per;
            }
        }
        return person;
    }

    /**
     * Gets ID
     * 
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets firstname
     * 
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets firstname
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets firstname
     * 
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets middlename
     * 
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets SSN
     * 
     * @return ssn
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets ssn
     * 
     * @param ssn
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * gets age
     * 
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets age
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    // abstract public String getDepartment();
    // abstract public String getMajor();

    @Override
    public String toString() { // returns full name

        String firstname = getFirstName();
        String lastName = getLastName();
        String middleName = getMiddleName();

        if (middleName.equals("")) {
            return (firstname + " " + lastName + " " + "(Person)");
        } else {
            return (firstname + " " + middleName + " " + lastName + " " + "(Person)");
        }

    }

    /**
     * 
     * @return String representing the email domain
     */
    public String getEmailDomain() {
        int dotPos = -1;
        String email = getEmail();
        String domain = "";
        int i = 0;
        while (dotPos == -1) {
            char c = email.charAt(i);
            dotPos = (c == '@') ? i : -1; // check if the current character is an '@'
            i++;
        }

        if (dotPos != -1) {
            for (int z = dotPos + 1; z < email.length(); z++) { // begin iterating from dot pos
                domain = domain + email.charAt(z);
            }
        }

        return domain;

    }

    /**
     * Gets the last four digits of the SSN of the person
     * 
     * @return String representing the last four digits
     */
    public String getLast4SSN() {
        String ssn = getSSN();
        String lastfourSSN = "" + ssn.charAt(5) + ssn.charAt(6) + ssn.charAt(7) + ssn.charAt(8);
        return lastfourSSN;

    }



}
