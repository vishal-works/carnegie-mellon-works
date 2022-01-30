import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Swing Application for Student Directory App.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class DirectoryDriver {
    /**
     * Constructor for Directory Driver.
     */
    public DirectoryDriver() { }
    /**
     * Class for the GUI.
     */
    public static class StudentGui extends JFrame {
        /**
         *Class for the GUI - setting serialVersionUID.
         */
        private static final long serialVersionUID = 1L;
        /**
         * Constructor for GUI.
         * @param name contains the name of csv file. null if nothing.
         * @param d contains the directory under consideration.
         */
        public StudentGui(String name, Directory d) {
            //Setting Dimensions as a Variable.
            Dimension screen = new Dimension();
            screen.width = 700;
            screen.height = 450;
            //Setting Window Settings for the Application.
            setTitle("Student Directory Application");
            setSize(screen);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Header (Body) Panel.
            Font font = new Font(Font.DIALOG, Font.BOLD, 15);
            JPanel header = new JPanel();
            header.setPreferredSize(screen);
            JLabel heading = new JLabel("Student Directory");
            heading.setFont(font);
            setContentPane(header);
            pack();
            header.add(heading);
            //Add Student Panel.
            Font fontHeading = new Font(Font.DIALOG, Font.BOLD, 10);
            JPanel addHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
            addHeader.setPreferredSize(new Dimension(screen.width, 20));
            JLabel addHeading = new JLabel("Add a new student");
            addHeading.setFont(fontHeading);
            addHeader.add(addHeading);
            JPanel addData = new JPanel(new FlowLayout(FlowLayout.CENTER));
            addData.setPreferredSize(new Dimension(screen.width, 35));
            JLabel addFirstName = new JLabel("First Name :");
            JLabel addLastName = new JLabel(" Last Name :");
            JLabel addAndrew = new JLabel(" Andrew ID :");
            JLabel addPhoneNo = new JLabel(" Phone Number :");
            JTextArea firstNameAdd = new JTextArea(1, 5);
            JTextArea lastNameAdd = new JTextArea(1, 5);
            JTextArea andrewAdd = new JTextArea(1, 5);
            JTextArea phoneNoAdd = new JTextArea(1, 5);
            JButton addStudent = new JButton("Add");
            Font fontLabel = new Font(Font.DIALOG, Font.PLAIN, 10);
            addFirstName.setFont(fontLabel);
            addLastName.setFont(fontLabel);
            addAndrew.setFont(fontLabel);
            addPhoneNo.setFont(fontLabel);
            addData.add(addFirstName);
            addData.add(firstNameAdd);
            addData.add(addLastName);
            addData.add(lastNameAdd);
            addData.add(addAndrew);
            addData.add(andrewAdd);
            addData.add(addPhoneNo);
            addData.add(phoneNoAdd);
            addData.add(addStudent);
            //Delete Student
            JPanel deleteHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
            deleteHeader.setPreferredSize(new Dimension(screen.width, 20));
            JLabel deleteHeading = new JLabel("Delete a Student");
            deleteHeading.setFont(fontHeading);
            deleteHeader.add(deleteHeading);
            JPanel deleteDataContainer = new JPanel(new FlowLayout(FlowLayout.CENTER)); //To get correct indentation.
            JPanel deleteData = new JPanel(new FlowLayout(FlowLayout.LEFT));
            deleteDataContainer.setPreferredSize(new Dimension(screen.width, 35));
            deleteData.setPreferredSize(new Dimension(screen.width - 30, 35));
            JLabel deleteAndrew = new JLabel("Andrew ID :");
            deleteAndrew.setFont(fontLabel);
            JTextArea andrewDelete = new JTextArea(1, 11);
            JButton deleteStudent = new JButton("Delete");
            deleteData.add(deleteAndrew);
            deleteData.add(andrewDelete);
            deleteData.add(deleteStudent);
            deleteData.setAlignmentY(LEFT_ALIGNMENT);
            deleteDataContainer.add(deleteData);
            //Search Students
            JPanel searchHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
            searchHeader.setPreferredSize(new Dimension(screen.width, 20));
            JLabel searchHeading = new JLabel("Search Student(s)");
            searchHeading.setFont(fontHeading);
            searchHeader.add(searchHeading);
            JPanel searchData = new JPanel(new FlowLayout(FlowLayout.CENTER));
            searchData.setPreferredSize(new Dimension(screen.width, 35));
            JLabel searchKey = new JLabel("Search Key :");
            searchKey.setFont(fontLabel);
            JTextArea keySearch = new JTextArea(1, 11);
            JButton searchAndrew = new JButton("by Andrew ID");
            JButton searchFirstName = new JButton("by First Name");
            JButton searchLastName = new JButton("by Last Name");
            searchData.add(searchKey);
            searchData.add(keySearch);
            searchData.add(searchAndrew);
            searchData.add(searchFirstName);
            searchData.add(searchLastName);
            searchData.setAlignmentY(LEFT_ALIGNMENT);
            //Results Area
            JPanel resultHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
            resultHeader.setPreferredSize(new Dimension(screen.width, 20));
            JLabel resultHeading = new JLabel("Results");
            resultHeading.setFont(fontHeading);
            resultHeader.add(resultHeading);
            JPanel resultData = new JPanel(new FlowLayout(FlowLayout.CENTER));
            resultData.setPreferredSize(new Dimension(screen.width, 150));
            JTextArea resultText = new JTextArea(8, 50);
            JScrollPane scroller = new JScrollPane(resultText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            resultData.add(scroller);
            //Builidng the Content Pane
            header.add(addHeader);
            header.add(addData);
            header.add(deleteHeader);
            header.add(deleteDataContainer);
            header.add(searchHeader);
            header.add(searchData);
            header.add(resultHeader);
            header.add(resultData);
            setVisible(true);
            keySearch.requestFocusInWindow();
            setResizable(false);
            //Action Events.
            keySearch.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String s = keySearch.getText();
                        if (!s.isEmpty()) {
                            Student result = d.searchByAndrewId(s);
                            if (result != null) {
                                if (!resultText.getText().isEmpty()) {
                                    if (resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                        resultText.append("Results for Andrew ID :\n");
                                        resultText.append(result.toString());
                                    } else {
                                        resultText.append("\nResults for Andrew ID :\n");
                                        resultText.append(result.toString());
                                    }
                                } else {
                                    resultText.append("Results for Andrew ID :\n");
                                    resultText.append(result.toString());
                                }
                                keySearch.setText("");
                            } else {
                                if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                    resultText.append("No Matches for " + s);
                                } else {
                                    resultText.append("\nNo Matches for " + s);
                                }
                            }
                        } else {
                            resultText.setText("No Andrew ID Entered");
                        }
                    }
                }
            });
            searchAndrew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = keySearch.getText();
                    if (!s.isEmpty()) {
                        Student result = d.searchByAndrewId(s);
                        if (result != null) {
                            if (!resultText.getText().isEmpty()) {
                                if (resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                    resultText.append("Results for Andrew ID :\n");
                                    resultText.append(result.toString());
                                } else {
                                    resultText.append("\nResults for Andrew ID :\n");
                                    resultText.append(result.toString());
                                }
                            } else {
                                resultText.append("Results for Andrew ID :\n");
                                resultText.append(result.toString());
                            }
                            keySearch.setText("");
                        } else {
                            if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                resultText.append("No Matches for " + s);
                            } else {
                                resultText.append("\nNo Matches for " + s);
                            }
                        }
                    } else {
                        resultText.setText("No Andrew ID Entered");
                    }
                }
            });
            searchFirstName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = keySearch.getText();
                    if (!s.isEmpty()) {
                        List<Student> result = d.searchByFirstName(s);
                        if (result.size() == 0) {
                            if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                resultText.append("No Matches for the First Name " + s);
                            } else {
                                resultText.append("\nNo Matches for the First Name " + s);
                            }
                        } else {
                            keySearch.setText("");
                            if (resultText.getText().isEmpty()) {
                                resultText.append("Results for first name :\n");
                                for (int i = 0; i < result.size(); i++) {
                                    resultText.append(result.get(i).toString() + "\n");
                                }
                            } else {
                                if (resultText.getText().charAt(resultText.getText().length() - 1) != '\n') {
                                    resultText.append("\n");
                                }
                                resultText.append("Results for first name :\n");
                                for (int i = 0; i < result.size(); i++) {
                                    resultText.append(result.get(i).toString() + "\n");
                                }
                            }
                        }
                    } else {
                        resultText.setText("No First Name Entered");
                    }
                }
            });
            searchLastName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = keySearch.getText();
                    if (!s.isEmpty()) {
                        List<Student> result = d.searchByLastName(s);
                        if (result.size() == 0) {
                            if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                resultText.append("No Matches for the Last Name " + s);
                            } else {
                                resultText.append("\nNo Matches for the Last Name " + s);
                            }
                        } else {
                            keySearch.setText("");
                            if (resultText.getText().isEmpty()) {
                                resultText.append("Results for last name :\n");
                                for (int i = 0; i < result.size(); i++) {
                                    resultText.append(result.get(i).toString() + "\n");
                                }
                            } else {
                                if (resultText.getText().charAt(resultText.getText().length() - 1) != '\n') {
                                    resultText.append("\n");
                                }
                                resultText.append("Results for last name :\n");
                                for (int i = 0; i < result.size(); i++) {
                                    resultText.append(result.get(i).toString() + "\n");
                                }
                            }
                        }
                    } else {
                        resultText.setText("No Last Name Entered");
                    }
                }
            });
            addStudent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] s = new String[4];
                    s[0] = firstNameAdd.getText();
                    s[1] = lastNameAdd.getText();
                    s[2] = andrewAdd.getText();
                    s[3] = phoneNoAdd.getText();
                    int flag = 0;
                    if (s[0].isEmpty()) {
                        resultText.setText("First Name is required and is missing!!\n");
                        flag = 1;
                    }
                    if (s[1].isEmpty()) {
                        resultText.setText("Last Name is required and is missing!!\n");
                        flag = 1;
                    }
                    if (s[2].isEmpty()) {
                        resultText.setText("Andrew ID is required and is missing!!");
                        flag = 1;
                    }
                    if (flag == 0) {
                        Student addStudent = new Student(s[2]);
                        addStudent.setFirstName(s[0]);
                        addStudent.setLastName(s[1]);
                        if (!s[3].isEmpty()) {
                            addStudent.setPhoneNumber(s[3]);
                        }
                        try {
                            d.addStudent(addStudent);
                        } catch (IllegalArgumentException z) {
                            resultText.setText("Andrew ID " + s[2] + " already exists!");
                            flag = 1;
                        }
                        if (flag == 0) {
                            if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                resultText.append("New Student Sucessfully Added! :\n" + addStudent.toString());
                            } else {
                                resultText.append("\nNew Student Sucessfully Added! :\n" + addStudent.toString());
                            }
                            firstNameAdd.setText("");
                            lastNameAdd.setText("");
                            andrewAdd.setText("");
                            phoneNoAdd.setText("");
                            //add to csv file.
                            if (name != null) {
                                try {
                                    List<String> line = Arrays.asList("\"" + s[0] + "\"", "\"" + s[1] + "\"", "\"" + s[2] + "\"", "\"" + s[3] + "\"");
                                    FileWriter write = new FileWriter(name, true);
                                    write.append("\n" + String.join(",", line));
                                    write.flush();
                                    write.close();
                                } catch (IOException f) {
                                    System.out.println();
                                    System.out.println(f);
                                }
                            }
                        }
                    }
                }
            });
            deleteStudent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = andrewDelete.getText();
                    if (!s.isEmpty()) {
                        Student result = d.searchByAndrewId(s);
                        if (result != null) {
                            d.deleteStudent(s);
                            if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                resultText.append("Deleted Student :\n" + result.toString());
                            } else {
                                resultText.append("\nDeleted Student :\n" + result.toString());
                            }
                            andrewDelete.setText("");
                            //delete from csv file.
                            try {
                                BufferedReader br = new BufferedReader(new FileReader(name));
                                boolean eof = false;
                                ArrayList<String> file = new ArrayList<String>();
                                while (!eof) {
                                    String line = br.readLine();
                                    if (line == null) {
                                        eof = true;
                                        continue;
                                    }
                                    String tester = line.replaceAll("\"", "");
                                    String[] data = tester.split(",");
                                    if (!data[2].equals(s)) {
                                        file.add(line);
                                    }
                                }
                                FileWriter newFile = new FileWriter(name);
                                for (int i = 0; i < file.size(); i++) {
                                    newFile.append(file.get(i));
                                    newFile.append("\n");
                                }
                                newFile.flush();
                                newFile.close();
                                br.close();
                            } catch (FileNotFoundException g) {
                                System.out.println("File " + name + " was not found");
                            } catch (IOException g) {
                                System.out.println();
                                System.out.println(g);
                            }
                        } else {
                            if (resultText.getText().isEmpty() || resultText.getText().charAt(resultText.getText().length() - 1) == '\n') {
                                resultText.append("Student " + s + " does not exist.");
                            } else {
                                resultText.append("\nStudent " + s + " does not exist.");
                            }
                        }
                    } else {
                        resultText.setText("No Andrew ID Entered");
                    }
                }
            });
        }
    }
    public static void loadFile(String s, Directory d) {
        if (s == null) {
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            boolean eof = false;
            String[] words = new String[4];
            int lineNumber = 0;
            while (!eof) {
                lineNumber++;
                String line = br.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    line = line.replace("\"", "");
                    words = line.split(",");
                    if (lineNumber != 1) {
                        Student student = new Student(words[2]);
                        student.setFirstName(words[0]);
                        student.setLastName(words[1]);
                        if (words[3] != null) {
                            student.setPhoneNumber(words[3]);
                        }
                        d.addStudent(student);
                        System.out.println(student);
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + s + " was not found");
        } catch (IOException e) {
            System.out.println();
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Directory directory = new Directory();
        String fileName;
        if (args.length == 0) {
            fileName = null;
        } else {
            fileName = args[0];
        }
        loadFile(fileName, directory);
        new DirectoryDriver.StudentGui(fileName, directory);
    }
}
