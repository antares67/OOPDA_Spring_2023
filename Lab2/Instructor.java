public class Instructor extends Person {

    public String department;

    public Instructor(String firstName, String middleName, String lastName, String email, String ssn, int age,
            String department) {
        super(firstName, middleName, lastName, email, ssn, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() { // returns full name

        String firstname = getFirstName();
        String lastName = getLastName();
        String middleName = getMiddleName();

        if (middleName.equals("")) {
            return (firstname + " " + lastName + " " + "(Instructor)");
        } else {
            return (firstname + " " + middleName + " " + lastName + " " + "(Instructor)");
        }

    }

}
