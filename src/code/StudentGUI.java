import javax.swing.*;
import java.awt.*;

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
    private static final String GAME_DESCRIPTION;
    private static final int    WIDTH;
    private static final int    HEIGHT;
    private static final int    ROWS_MAIN_PANEL;
    private static final int    COLS_MAIN_PANEL;
    private static final int    GAP_MAIN_PANEL;
    private static final int    MEDIUM_WIDTH;
    private static final int    LARGE_HEIGHT;
    private static final int    VOWELS;
    private static final int    CONSONANTS;

    final CountingGame game;
    final JFrame       frame;
    final JMenuBar     menuBar;
    final JMenu        menu;
    final JPanel       panel;
    final JPanel       userPanel;

    final JMenuItem gameInstructions;
    final JMenuItem exit;

    final JLabel headerLabel;
    final JLabel vowelLabel;
    final JLabel consonantLabel;

    final JTextArea userInput;

    static
    {
        APP_NAME         = "Counting Vowels and Consonants";
        MENU_TITLE       = "OPTIONS";
        GAME_DESCRIPTION = "Enter a input in the text field";
        OPTION1          = "How To Play";
        EXIT             = "Exit";
        WIDTH            = 800;
        HEIGHT           = 600;
        MEDIUM_WIDTH     = 160;
        LARGE_HEIGHT     = 50;
        ROWS_MAIN_PANEL  = 4;
        COLS_MAIN_PANEL  = 1;
        GAP_MAIN_PANEL   = 10;
        VOWELS           = 0;
        CONSONANTS       = 1;
    }

    /**
     * Constructs a StudentGUI instance, initializing the user interface components and setting up the GUI.
     * This constructor creates a new instance of the CountingGame, initializes the main JFrame,
     * panels, menu bar, menu items, labels, and text area. It also sets default values for the
     * vowel and consonant labels, and calls the createAndShowGUI() method to set up and display
     * the GUI components. The GUI includes a menu for instructions and exit options, a text area
     * for user input, and labels to display the counts of vowels and consonants.
     */
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

    /**
     * Updates the vowel and consonant labels based on the current text in the JTextArea.
     * This method retrieves the current text from the JTextArea, processes it using the
     * game's play method to count vowels and consonants, and then updates the
     * vowel and consonant labels with the respective counts.
     * The method assumes that the game's play method returns a string array where:
     * - response[VOWELS] contains the count of vowels
     * - response[CONSONANTS] contains the count of consonants
     */
    public static void main(String[] args)
    {
        new StudentGUI();
    }

    /**
     * Creates and displays the GUI for the Guess the Number Game.
     * This method sets up event listeners.
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

        userInput.addCaretListener(e -> updateLabels());

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

    /**
     * Returns the JFrame object used in the GUI.
     *
     * @return the JFrame instance representing the main window of the GUI
     */
    public JFrame getFrame()
    {
        return frame;
    }

    /**
     * Returns the JTextArea used for user input in the GUI.
     *
     * @return the JTextArea instance where users can type their input
     */
    public JTextArea getTextArea()
    {
        return userInput;
    }

    /**
     * Returns the JLabel displaying the count of vowels in the GUI.
     *
     * @return the JLabel instance that shows the number of vowels
     */
    public JLabel getVowelLabel()
    {
        return vowelLabel;
    }

    /**
     * Returns the JLabel displaying the count of consonants in the GUI.
     *
     * @return the JLabel instance that shows the number of consonants
     */
    public JLabel getConsonantLabel()
    {
        return consonantLabel;
    }
}
