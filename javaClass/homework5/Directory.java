import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Student Directory App, Directory Class.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Directory {
    /**
     * Map of Students to Andrew ID.
     */
    private Map<String, Student> andrewMap = new HashMap<String, Student>();
    /**
     * Map of Students to First Names.
     */
    private Map<String, List<Student>> firstNameMap = new HashMap<String, List<Student>>();
    /**
     * Map of Students to Last Name.
     */
    private Map<String, List<Student>> lastNameMap = new HashMap<String, List<Student>>();
    /**
     * Class Constructor.
     */
    public Directory() { }
    /**
     * Helper Method to return a copy to prevent overwriting and referencing.
     * @param s accepts the student to copy.
     * @return the copied student.
     */
    public Student copy(Student s) {
        Student newStudent = new Student(s.getAndrewId());
        newStudent.setFirstName(s.getFirstName());
        newStudent.setLastName(s.getLastName());
        newStudent.setPhoneNumber(s.getPhoneNumber());
        return newStudent;
    }
    /**
     * Method to add student to directory and to maps.
     * @param s contains the Student object.
     */
    public void addStudent(Student s) {
        if (s != null) {
            if (andrewMap.containsKey(s.getAndrewId())) {
                throw new IllegalArgumentException(s.getAndrewId());
            } else {
                andrewMap.put(s.getAndrewId(), copy(s));
            }
            if (!firstNameMap.containsKey(s.getFirstName())) {
                /**
                 * list of new students to be added to map.
                 */
                List<Student> newStudents = new ArrayList<Student>();
                newStudents.add(copy(s));
                firstNameMap.put(s.getFirstName(), newStudents);
            } else {
                /**
                 * list of new students to be added to map.
                 */
                List<Student> newStudents = firstNameMap.get(s.getFirstName());
                for (int i = 0; i < newStudents.size(); i++) {
                    if (newStudents.get(i).getAndrewId() == s.getAndrewId()) {
                        throw new IllegalArgumentException(s.getFirstName());
                    }
                }
                newStudents.add(copy(s));
                firstNameMap.put(s.getFirstName(), newStudents);
            }
            if (!lastNameMap.containsKey(s.getLastName())) {
                /**
                 * list of new students to be added to map.
                 */
                List<Student> newStudents = new ArrayList<Student>();
                newStudents.add(copy(s));
                lastNameMap.put(s.getLastName(), newStudents);
            } else {
                /**
                 * list of new students to be added to map.
                 */
                List<Student> newStudents = lastNameMap.get(s.getLastName());
                for (int i = 0; i < newStudents.size(); i++) {
                    if (newStudents.get(i).getAndrewId() == s.getAndrewId()) {
                        throw new IllegalArgumentException(s.getLastName());
                    }
                }
                newStudents.add(copy(s));
                lastNameMap.put(s.getLastName(), newStudents);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * Method to delete Student for given andrewID.
     * @param andrewId contains the andrewID to delete.
     */
    public void deleteStudent(String andrewId) {
        if (andrewId != null) {
            /**
             * variable to test if student exists.
             */
            Student s = andrewMap.get(andrewId);
            if (s == null) {
                throw new IllegalArgumentException(andrewId);
            } else {
                andrewMap.remove(s.getAndrewId());
                for (Student e : firstNameMap.get(s.getFirstName())) {
                    if (e.getAndrewId() == s.getAndrewId()) {
                        s = e;
                    }
                }
                firstNameMap.get(s.getFirstName()).remove(s);
                for (Student e : lastNameMap.get(s.getLastName())) {
                    if (e.getAndrewId() == s.getAndrewId()) {
                        s = e;
                    }
                }
                lastNameMap.get(s.getLastName()).remove(s);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * Method to search by andrewID.
     * @param andrewId contains the andrew ID to search for.
     * @return the object that has the andrewID or null if absent.
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId != null) {
            /**
             * Student variable containing the searched object.
             */
            Student andrew = andrewMap.get(andrewId);
            if (andrew != null) {
                return copy(andrew);
            }
            return null;
        } else {
            throw new IllegalArgumentException(andrewId);
        }
    }
    /**
     * method to search by first name.
     * @param firstName has the name to be searched with.
     * @return a list of Students who's first name matches.
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName != null) {
            /**
             * List to store all looked up students in Directory.
             */
            List<Student> students = new ArrayList<Student>();
            /**
             * Variable to store a looked up student
             */
            if (firstNameMap.get(firstName) == null) {
                return new ArrayList<Student>();
            }
            students = new ArrayList<Student>(firstNameMap.get(firstName));
            for (int i = 0; i < students.size(); i++) {
                students.set(i, copy(students.get(i)));
            }
            return students;
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * Method to search by last name.
     * @param lastName has the name to be searched with.
     * @return a list of students who's last name matches.
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName != null) {
            /**
             * List to store all looked up students in Directory.
             */
            List<Student> students = new ArrayList<Student>();
            /**
             * Variable to store a looked up student
             */
            if (lastNameMap.get(lastName) == null) {
                return new ArrayList<Student>();
            }
            students = new ArrayList<Student>(lastNameMap.get(lastName));
            for (int i = 0; i < students.size(); i++) {
                students.set(i, copy(students.get(i)));
            }
            return students;
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * Mehthod to find number of students in directory.
     * @return the number of students in directory.
     */
    public int size() {
        return andrewMap.size();
    }
    public static void main(String[] args) {
        Student s = new Student("terrylee");
        s.setFirstName("Terry");
        s.setLastName("Lee");
        s.setPhoneNumber("412-212-1212");
        Student t = new Student("jle");
        t.setFirstName("Jeff");
        t.setLastName("Lee");
        t.setPhoneNumber("412-268-1474");
        Student u = new Student("terryhong");
        u.setFirstName("Terry");
        u.setLastName("hong");
        u.setPhoneNumber("312-123-1232");
        Directory d = new Directory();
        d.addStudent(s);
        d.addStudent(t);
        d.addStudent(u);
        d.deleteStudent("terrylee");
        System.out.println(d.searchByLastName("Koothi"));
    }
}
