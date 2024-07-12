import javax.swing.*;
import java.awt.*;

/**
 * CountingGameUI
 *
 * @author user
 * @version 1.0
 */
public class CountingGameUI
{
    private static final String APP_NAME;
    private static final String MENU_TITLE;
    private static final String OPTION1;
    private static final String EXIT;
    private static final String SUBMIT_BUTTON;
    private static final String INVALID_INPUT;
    private static final int    WIDTH;
    private static final int    HEIGHT;
    private static final int    MIN_NUMBER;
    private static final int    MAX_NUMBER;
    private static final int    ROWS_MAIN_PANEL;
    private static final int    COLS_MAIN_PANEL;
    private static final int    GAP_MAIN_PANEL;
    private static final int    MEDIUM_WIDTH;
    private static final int    SMALL_WIDTH;
    private static final int    SMALL_HEIGHT;
    private static final int    LARGE_HEIGHT;
    private static final String GAME_DESCRIPTION;

    static
    {
        APP_NAME             = "Counting Vowels and Consonants";
        MENU_TITLE           = "OPTIONS";
        OPTION1              = "How To Play";
        EXIT                 = "Exit";
        SUBMIT_BUTTON        = "Count";
        WIDTH                = 800;
        HEIGHT               = 600;
        MIN_NUMBER           = 1;
        MAX_NUMBER           = 100;
        MEDIUM_WIDTH         = 160;
        SMALL_WIDTH          = 100;
        SMALL_HEIGHT         = 20;
        LARGE_HEIGHT         = 50;
        ROWS_MAIN_PANEL      = 4;
        COLS_MAIN_PANEL      = 1;
        GAP_MAIN_PANEL       = 10;

        INVALID_INPUT    = String.format("Please enter a number between %d and %d.", MIN_NUMBER, MAX_NUMBER);
        GAME_DESCRIPTION = "Enter a input in the text field";
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(CountingGameUI::createAndShowGUI);
    }

    /**
     * Creates and displays the GUI for the Guess the Number Game.
     * This method initializes all components and sets up event listeners.
     */
    private static void createAndShowGUI()
    {
        final CountingGame game;
        final JFrame   frame;
        final JMenuBar menuBar;
        final JMenu    menu;
        final JPanel   panel;
        final JPanel   userPanel;

        final JMenuItem gameInstructions;
        final JMenuItem exit;

        final JLabel headerLabel;
        final JLabel resultLabel;

        final JTextArea userInput;

        final JButton submit;

        game        = new CountingGame();
        frame       = new JFrame(APP_NAME);
        panel       = new JPanel();
        userPanel   = new JPanel();
        menuBar     = new JMenuBar();
        menu        = new JMenu(MENU_TITLE);

        gameInstructions = new JMenuItem(OPTION1);
        exit            = new JMenuItem(EXIT);

        headerLabel = new JLabel(GAME_DESCRIPTION, JLabel.CENTER);
        resultLabel = new JLabel("", JLabel.CENTER);

        submit = new JButton(SUBMIT_BUTTON);
        userInput   = new JTextArea();

        userInput.setLineWrap(true);
        userInput.setWrapStyleWord(true);
        userInput.setPreferredSize(new Dimension(MEDIUM_WIDTH, LARGE_HEIGHT));
        submit.setPreferredSize(new Dimension(SMALL_WIDTH, SMALL_HEIGHT));
        userPanel.add(userInput);
        userPanel.add(submit);

        panel.setLayout(new GridLayout(ROWS_MAIN_PANEL, COLS_MAIN_PANEL, GAP_MAIN_PANEL, GAP_MAIN_PANEL));
        panel.add(headerLabel, BorderLayout.NORTH);
        panel.add(userPanel, BorderLayout.CENTER);
        panel.add(resultLabel, BorderLayout.SOUTH);

        submit.addActionListener(e ->{
            final String input;
            String response;

            try
            {
                input    = userInput.getText();
                response = game.play(input);
            }
            catch(final NumberFormatException ex)
            {
                response = INVALID_INPUT;
            }

            resultLabel.setText(response);
            userInput.setText("");
        });

        gameInstructions.addActionListener(
                e -> JOptionPane.showMessageDialog(frame, getGameInstructions()));

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
}
