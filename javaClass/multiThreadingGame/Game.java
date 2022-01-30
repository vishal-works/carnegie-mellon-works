import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.util.Random;

/**
 * Whack-a-mole Game with Swing GUI.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Game extends JFrame implements ActionListener, Runnable {
    /**
     * Specifying the version ID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Start button.
     */
    private JButton start;
    /**
     * List of buttons which are the moles.
     */
    private List<JButton> moles;
    /**
     * Text Area for Time.
     */
    private JTextArea time;
    /**
     * Text area for score.
     */
    private JTextArea score;
    /**
     * Up config text of mole.
     */
    private static final String UP = ":-)";
    /**
     * down config text of mole.
     */
    private static final String DOWN = " ";
    /**
     * hit config of mole text.
     */
    private static final String HIT = ":-(";
    /**
     * up config color of mole.
     */
    private static final Color UPCOLOR = Color.GREEN;
    /**
     * down config color of mole.
     */
    private static final Color DOWNCOLOR = Color.lightGray;
    /**
     * hit config color of mole.
     */
    private static final Color HITCOLOR = Color.RED;
    /**
     * time counter for remaining time of the game.
     */
    private long timeRemaining;
    /**
     * Score Keeper.
     */
    private int scoreText;
    /**
     * Random number generator.
     */
    private Random random = new Random();
    /**
     * constructor for the Game class that makes the GUI.
     */
    public Game() {
        //Setting Dimensions as a Variable for parametric use.
        Dimension screen = new Dimension();
        screen.width = 700;
        screen.height = 400;
        //Setting Window Settings for the Application.
        setTitle("Whack-a-Mole Game by Vishal");
        setSize(screen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Header (Body) Panel.
        Font font = new Font(Font.DIALOG, Font.BOLD, 15);
        JPanel header = new JPanel();
        header.setPreferredSize(screen);
        JLabel heading = new JLabel("Whack-a-Mole!");
        heading.setFont(font);
        setContentPane(header);
        header.add(heading);
        pack();
        //Inital UI Part
        JPanel top = new JPanel();
        start = new JButton("Start");
        JLabel timeLeft = new JLabel("  Time Left : ");
        time = new JTextArea(1, 10);
        JLabel scoreLabel = new JLabel("  Score : ");
        score = new JTextArea(1, 10);
        score.setText(Integer.toString(scoreText));
        score.setEditable(false);
        top.setPreferredSize(new Dimension(screen.width, 50));
        top.add(start);
        top.add(timeLeft);
        top.add(time);
        top.add(scoreLabel);
        top.add(score);
        header.add(top);
        //64 Buttons for Moles
        moles = new ArrayList<JButton>(64);
        JPanel buttons = new JPanel(new GridLayout(8, 8));
        buttons.setPreferredSize(new Dimension(screen.width - 50, 250));
        //Creating buttons and adding them.
        for (int i = 0; i < 64; i++) {
            moles.add(new JButton());
            buttons.add(moles.get(i));
            JButton current = moles.get(i);
            current.setText(DOWN);
            current.setOpaque(true);
            current.setBackground(DOWNCOLOR);
            current.addActionListener(new AbstractAction() {
                /**
                 *Anonymous action class for every mole to be accessed individually.
                 */
                private static final long serialVersionUID = 1L;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (current.getText().equals(UP)) {
                        if (timeRemaining != 0) {
                            scoreText++;
                        }
                        score.setText(Integer.toString(scoreText));
                        current.setText(HIT);
                        current.setBackground(HITCOLOR);
                    }
                }
            });
        }
        header.add(buttons);
        // Actions for start button
        start.addActionListener(this);
        //setting window properties.
        setVisible(true);
        setResizable(false);
    }
    /**
     * Action Performed Method for starting the game.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        timeRemaining = 20;
        scoreText = 0;
        start.setEnabled(false);
        time.setEditable(false);
        Thread timer = new Thread(this);
        timer.start();
        for (int i = 0; i < moles.size(); i++) {
            Thread play = new Thread(new GamePlay(moles.get(i)));
            play.start();
        }
    }
    /**
     * Run method of the runnable to execute the game actions.
     */
    @Override
    public void run() {
        try {
            time.setText(Long.toString(timeRemaining));
            score.setText(Integer.toString(scoreText));
            while (timeRemaining > 0) {
                Thread.sleep(1000);
                timeRemaining--;
                time.setText(Long.toString(timeRemaining));
            }
            Thread.sleep(5000);
            start.setEnabled(true);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }
    /**
     * Method to simulate the random up and down config of moles.
     * @param mole takes in the current active button.
     */
    private void gamePlay(JButton mole) {
        try {
            while (timeRemaining > 0) {
                //minimum uptime 0 so that not all start at once. (can be made as 0.5s by having nextInt(3500) + 500;)
                Long uptime = new Long(random.nextInt(4000));
                Long downtime = new Long(random.nextInt(3000) + 2000); //setting range from 2 seconds to 5 seconds.
                mole.setText(UP);
                mole.setBackground(UPCOLOR);
                Thread.sleep(uptime);
                mole.setText(DOWN);
                mole.setBackground(DOWNCOLOR);
                Thread.sleep(downtime);
            }
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }
    /**
     * Runnable for Mole Action using Recipe 1.
     */
    private class GamePlay implements Runnable {
        /**
         * class variable button to execute the functions.
         */
        private JButton b;
        GamePlay(JButton m) {
            b = m;
        }
        @Override
        public void run() {
            gamePlay(b);
        }
    }
    /**
     * Main Method of the game.
     * @param args takes in arguments from user.
     */
    public static void main(String[] args) {
        new Game();
        new Game();
    }
}
