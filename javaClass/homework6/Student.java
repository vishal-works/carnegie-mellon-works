/**
 * Student Directory App.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Student {
    /**
     * Variable to store the andrewID.
     */
    private String studentAndrewId;
    /**
     * Variable for First Name.
     */
    private String studentFirstName;
    /**
     * Variable for Last name.
     */
    private String studentLastName;
    /**
     * Variable for Phone number.
     */
    private String studentPhoneNumber;
    /**
     * constructor for the student class.
     * @param andrewId to store the andrew.
     */
    public Student(String andrewId) {
        if (andrewId != null) {
            studentAndrewId = andrewId;
        }
    }
    /**
     * Function to return Andrew ID.
     * @return the andrew ID.
     */
    public String getAndrewId() {
        return studentAndrewId;
    }
    /**
     * To return the First Name.
     * @return the first name.
     */
    public String getFirstName() {
        return studentFirstName;
    }
    /**
     * To return the Last Name.
     * @return the last name.
     */
    public String getLastName() {
        return studentLastName;
    }
    /**
     * To return the phone number.
     * @return the phone number.
     */
    public String getPhoneNumber() {
        return studentPhoneNumber;
    }
    /**
     * To set the first name.
     * @param s contains the string to be set.
     */
    public void setFirstName(String s) {
        if (s != null) {
            studentFirstName = s;
        }
    }
    /**
     * To set the last name.
     * @param s contains the string to be set.
     */
    public void setLastName(String s) {
        if (s != null) {
            studentLastName = s;
        }
    }
    /**
     * To set the phone number.
     * @param s contains the string to be set.
     */
    public void setPhoneNumber(String s) {
        if (s != null) {
            studentPhoneNumber = s;
        }
    }
    /**
     * overriden toString method.
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + "(Andrew ID: " + getAndrewId() + ", Phone Number: " + getPhoneNumber() + ")";
    }
}
