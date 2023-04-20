public class Student extends Person {

    public String major;

    public Student(String firstName, String middleName, String lastName, String email, String ssn, int age,
            String major) {
        super(firstName, middleName, lastName, email, ssn, age);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() { // returns full name

        String firstname = getFirstName();
        String lastName = getLastName();
        String middleName = getMiddleName();

        if (middleName.equals("")) {
            return (firstname + " " + lastName + " " + "(Student)");
        } else {
            return (firstname + " " + middleName + " " + lastName + " " + "(Student)");
        }

    }
}
