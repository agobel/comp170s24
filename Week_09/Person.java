public class Person {

    private String firstName;
    private String lastName;
    private int bdayDay;
    private int bdayMonth;
    private String gender;
    private String email;
    private String tiktokHandle;
    private int phoneNumber;

    /**
     * Tell the object how to create itself by writing a method that returns a copy
     * of this object. This "method" is called a constructor, and it comes in many
     * flavors. Here's a basic constructor, to create a person whose name is known
     * to
     * us.
     */
    public Person(String firstName) {
        this.firstName = firstName;
    }

    /** Set the last name */
    public void setLastName(String lastName) {
        if (lastName.matches("^[a-zA-Z]+$")) {
            this.lastName = lastName;
        }
    }

    /** String representation for this object */
    public String toString() {
        return "first name: " + firstName +
                "\nlast name: " + lastName +
                "\nemail: " + email;
    }

    /** Setter for email */
    public void setEmail(String email) {
        String emailRegEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        if (email.matches(emailRegEx)) {
            this.email = email;
        }
    }

    public String getEmail() {
        return this.email;
    }
}
