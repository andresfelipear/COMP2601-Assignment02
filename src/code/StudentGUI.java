import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * CountingGameUI
 *
 * @author user
 * @version 1.0
 */
public class StudentGUI
{
    private static final String APP_NAME;
    private static final String MENU_TITLE;
    private static final String OPTION1;
    private static final String EXIT;
    private static final String SUBMIT_BUTTON;
    private static final int WIDTH;
    private static final int HEIGHT;
    private static final int ROWS_MAIN_PANEL;
    private static final int COLS_MAIN_PANEL;
    private static final int GAP_MAIN_PANEL;
    private static final int MEDIUM_WIDTH;
    private static final int SMALL_WIDTH;
    private static final int SMALL_HEIGHT;
    private static final int LARGE_HEIGHT;
    private static final int VOWELS;
    private static final int CONSONANTS;
    private static final String GAME_DESCRIPTION;

    final CountingGame game;
    final JFrame frame;
    final JMenuBar menuBar;
    final JMenu menu;
    final JPanel panel;
    final JPanel userPanel;

    final JMenuItem gameInstructions;
    final JMenuItem exit;

    final JLabel headerLabel;
    final JLabel vowelLabel;
    final JLabel consonantLabel;

    final JTextArea userInput;

    static
    {
        APP_NAME = "Counting Vowels and Consonants";
        MENU_TITLE = "OPTIONS";
        GAME_DESCRIPTION = "Enter a input in the text field";
        OPTION1 = "How To Play";
        EXIT = "Exit";
        SUBMIT_BUTTON = "Count";
        WIDTH = 800;
        HEIGHT = 600;
        MEDIUM_WIDTH = 160;
        SMALL_WIDTH = 100;
        SMALL_HEIGHT = 20;
        LARGE_HEIGHT = 50;
        ROWS_MAIN_PANEL = 4;
        COLS_MAIN_PANEL = 1;
        GAP_MAIN_PANEL = 10;
        VOWELS = 0;
        CONSONANTS = 1;
    }

    public StudentGUI()
    {
        game = new CountingGame();
        frame = new JFrame(APP_NAME);
        panel = new JPanel();
        userPanel = new JPanel();
        menuBar = new JMenuBar();
        menu = new JMenu(MENU_TITLE);

        gameInstructions = new JMenuItem(OPTION1);
        exit = new JMenuItem(EXIT);

        headerLabel = new JLabel(GAME_DESCRIPTION, JLabel.CENTER);
        vowelLabel = new JLabel("Vowels: 0", JLabel.CENTER);
        consonantLabel = new JLabel("Consonants: 0", JLabel.CENTER);

        userInput = new JTextArea();
        createAndShowGUI();
    }

    public static void main(String[] args)
    {
        new StudentGUI();
    }

    /**
     * Creates and displays the GUI for the Guess the Number Game.
     * This method initializes all components and sets up event listeners.
     */
    private void createAndShowGUI()
    {
        userInput.setLineWrap(true);
        userInput.setWrapStyleWord(true);
        userInput.setPreferredSize(new Dimension(MEDIUM_WIDTH, LARGE_HEIGHT));
        userPanel.add(userInput);

        panel.setLayout(new GridLayout(ROWS_MAIN_PANEL,
                                       COLS_MAIN_PANEL,
                                       GAP_MAIN_PANEL,
                                       GAP_MAIN_PANEL));

        panel.add(headerLabel, BorderLayout.NORTH);
        panel.add(userPanel, BorderLayout.CENTER);
        panel.add(vowelLabel, BorderLayout.SOUTH);
        panel.add(consonantLabel, BorderLayout.SOUTH);

        userInput.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateLabels();
            }
        });

        gameInstructions.addActionListener(e -> JOptionPane.showMessageDialog(frame, getGameInstructions()));
        exit.addActionListener(e -> frame.dispose());

        menu.add(gameInstructions);
        menu.add(exit);

        menuBar.add(menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void updateLabels()
    {
        final String input;
        final String[] response;

        input    = userInput.getText();
        response = game.play(input);

        vowelLabel.setText(response[VOWELS]);
        consonantLabel.setText(response[CONSONANTS]);
    }

    /**
     * Returns the game instructions.
     *
     * @return A string containing the game instructions.
     */
    private static String getGameInstructions()
    {
        return """
                Instructions:
                1. Enter an input in the text field.
                2. Click "Count" to see the number of vowels and consonants.
                3. You can exit from the "Options" menu.""";
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public JTextArea getTextArea()
    {
        return userInput;
    }

    public JLabel getVowelLabel()
    {
        return vowelLabel;
    }

    public JLabel getConsonantLabel()
    {
        return consonantLabel;
    }
}
