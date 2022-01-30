import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
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
import java.awt.GridLayout;
/**
 * Example practice problem.
 * @author Vishal Vaidhyanathan the mass.
 */
public class practice extends JFrame{
    /**
     * Resulting Text Area.
     */
    private JTextArea textResult = new JTextArea(20,58);
    /**
     * Last name.
     */
    private JTextArea lastName = new JTextArea(1,10);
    /**
     * First Name.
     */
    private JTextArea firstNameText = new JTextArea(1,10);
    /**
     * List of contributors.
     */
    private List<contributor> people = new ArrayList<contributor>();
    /**
     * Amount.
     */
    private JTextArea amountText = new JTextArea(1,10);
    /**
     *Serializing the calss version.
     */
    private static final long serialVersionUID = 1L;
    public practice() {
        //Setting Dimensions as a Variable.
        Dimension screen = new Dimension();
        screen.width = 800;
        screen.height = 550;
        //Setting Window Settings for the Application.
        setTitle("Midterm Campaign Contribution Application");
        setSize(screen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Header (Body) Panel.
        Font font = new Font(Font.DIALOG, Font.BOLD, 15);
        JPanel header = new JPanel();
        header.setPreferredSize(screen);
        JLabel heading = new JLabel("Campaign Contribution");
        heading.setFont(font);
        setContentPane(header);
        pack();
        header.add(heading);
        //top panel
        JPanel topLine = new JPanel();
        topLine.setPreferredSize(new Dimension(screen.width, 40));
        JLabel contributor = new JLabel("Contributor Last Name : ");
        JLabel firstName = new JLabel("  First Name : ");
        JLabel amount = new JLabel("  Amount : ");
        topLine.add(contributor);
        topLine.add(lastName);
        topLine.add(firstName);
        topLine.add(firstNameText);
        topLine.add(amount);
        topLine.add(amountText);
        header.add(topLine);
        //button line
        JPanel buttonLine = new JPanel(new GridLayout(2,2));
        buttonLine.setPreferredSize(new Dimension(screen.width - 90, 80));
        JButton contObama = new JButton("Contribute to Obama");
        contObama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = firstNameText.getText();
                String lname = lastName.getText();
                String amount = amountText.getText();
                if (!lname.isEmpty()) {
                    if (!fname.isEmpty()) {
                        if (!amount.isEmpty()) {
                            people.add(new contributor(lname, fname, amount, "Obama"));
                        } else {
                            textResult.setText("Please Enter Amount to contribute!");
                        }
                    } else {
                        textResult.setText("Please Enter First Name to contribute!");
                    }
                } else {
                    textResult.setText("Please Enter Last Name to contribute!");
                }
            }
        });
        JButton contRomney = new JButton("Contribute to Romney");
        contRomney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = firstNameText.getText();
                String lname = lastName.getText();
                String amount = amountText.getText();
                if (!lname.isEmpty()) {
                    if (!fname.isEmpty()) {
                        if (!amount.isEmpty()) {
                            people.add(new contributor(lname, fname, amount, "Romney"));
                        } else {
                            textResult.setText("Please Enter Amount to contribute!");
                        }
                    } else {
                        textResult.setText("Please Enter First Name to contribute!");
                    }
                } else {
                    textResult.setText("Please Enter Last Name to contribute!");
                }
            }
        });
        JButton listObama = new JButton("List Obama contributors");
        listObama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getCandidate().equals("Obama")) {
                        textResult.append(people.get(i).toString());
                    }
                }
            }
        });
        JButton listRomney = new JButton("List Romney contributors");
        listRomney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getCandidate().equals("Romney")) {
                        textResult.append(people.get(i).toString());
                    }
                }
            }
        });
        buttonLine.add(contObama);
        buttonLine.add(contRomney);
        buttonLine.add(listObama);
        buttonLine.add(listRomney);
        header.add(buttonLine);
        //Text Area
        JPanel text = new JPanel();
        text.setPreferredSize(new Dimension(screen.width - 80, 400));
        textResult.setEditable(false);
        JScrollPane scroll = new JScrollPane(textResult, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        text.add(scroll);
        header.add(text);
        setResizable(false);
        setVisible(true);
    }
    private class contributor {
        private String fname;
        private String lname;
        private String amount;
        private String candidate;
        contributor(String lname, String fname, String amount, String candidate) {
            this.fname = fname;
            this.lname = lname;
            this.amount = amount;
            this.candidate = candidate;
        }
        public String getCandidate() {
            return candidate;
        }
        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("##,###,###");
            return lname + ", " + fname + "        $" + df.format(Integer.parseInt(amount)) + "       " + candidate + "\n";
        }
    }
    public static void main(String[] args) {
        new practice();
        
    }
}