package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.mazegenerator.Grid;
import version1.gameUtil.settings.GameMode;
import version1.gameUtil.settings.UIConfigurations;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Leader Board Screen
 */
public class LeaderBoardScreen extends AbstractScreen{

    private FakeUser leaderOnEasyMode;
    private FakeUser leaderOnMediumMode;
    private FakeUser leaderOnHardMode;
    private JButton goToMenuButton;


    public LeaderBoardScreen(GameFrame gameFrame) {

        /*
         * Creating Fake Data for testing Purposes
         */
        this.leaderOnEasyMode = new FakeUser("Sarai");
        this.leaderOnMediumMode = new FakeUser("Nicole");
        this.leaderOnHardMode = new FakeUser("Cameron");
        this.leaderOnEasyMode.setScore(GameMode.EASY, 90);
        this.leaderOnMediumMode.setScore(GameMode.MEDIUM, 121);
        this.leaderOnHardMode.setScore(GameMode.HARD, 189);
        this.gameFrame = gameFrame;
        UIConfigurations.configure(this);
    }

    /**
     * Is implemented by the child class in order to build the header of the screen
     */
    @Override
    public void buildHeader() {
        /*
         * First things first: sets the layout manager of the GameFrame
         */
        this.gameFrame.setLayout(new BorderLayout());

        /*
         * Initalize the header container
         */
        final JPanel headerContainer = new JPanel();

        /*
         * Style and Add header container
         */
        headerContainer.setBackground(gameFrame.getContentPane().getBackground());
        headerContainer.setSize(new Dimension(gameFrame.getContentPane().getWidth(), gameFrame.getContentPane().getHeight() / 4));
        headerContainer.add(this.headerLabel);

        /*
         * Lastly Add final result
         */
        this.add(headerContainer, BorderLayout.NORTH);
    }

    /**
     * Is implemented by the child class in order to build the body of the screen
     */
    @Override
    public void buildBody() {
        /*
         * First Things First: Initialize the background
         */
        final ImageIcon backgroundImage = new ImageIcon("background.png");
        final JLabel bodyContainer = new JLabel(backgroundImage);
        final Font titleFont = new Font("Bold", Font.BOLD, 20);
        final Font userNameFont = new Font("Italic", Font.ITALIC, 20);
        final Font scoreFont = new Font("Italic", Font.ITALIC, 30);
        final Color textColor = Color.WHITE;

        /*
         * Creates UI Panel Containers
         */
        JPanel leftPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel rightPanel =  new JPanel();

        /*
         * Set Font of the GoTo Menu Button
         */
        this.goToMenuButton.setFont(titleFont);

        /*
         * Create the Layout Managers
         */
        bodyContainer.setLayout(new GridLayout(1,3));
        leftPanel.setLayout(new GridLayout(9,1));
        centerPanel.setLayout(new GridLayout(9, 1));
        rightPanel.setLayout(new GridLayout(9, 1));

        /*
         * Makes Panels transparent
         */
        leftPanel.setOpaque(false);
        centerPanel.setOpaque(false);
        rightPanel.setOpaque(false);

        /*
         * Easy Mode Data
         */
        JLabel easyColumnTitle = new JLabel("EASY");
        JLabel easyModeLeaderUsername = new JLabel(this.leaderOnEasyMode.getUsername());
        JLabel easyModeLeaderScore = new JLabel(this.leaderOnEasyMode.getScore(GameMode.EASY).toString());

        // Set Text Colors
        easyColumnTitle.setForeground(textColor);
        easyModeLeaderUsername.setForeground(textColor);
        easyModeLeaderScore.setForeground(textColor);

        // Center the Text in the JLabels
        easyColumnTitle.setHorizontalAlignment(SwingConstants.CENTER);
        easyModeLeaderUsername.setHorizontalAlignment(SwingConstants.CENTER);
        easyModeLeaderScore.setHorizontalAlignment(SwingConstants.CENTER);

        // Layouts
        easyColumnTitle.setLayout(new GridBagLayout());
        easyModeLeaderUsername.setLayout(new GridBagLayout());
        easyModeLeaderScore.setLayout(new GridBagLayout());

        // Text Content
        easyColumnTitle.setFont(titleFont);
        easyModeLeaderUsername.setFont(userNameFont);
        easyModeLeaderScore.setFont(scoreFont);

        /*
         * Medium Mode Data
         */
        JLabel mediumColumnTitle = new JLabel("MEDIUM");
        JLabel mediumModeLeaderUsername = new JLabel(this.leaderOnMediumMode.getUsername());
        JLabel mediumModeLeaderScore = new JLabel(this.leaderOnMediumMode.getScore(GameMode.MEDIUM).toString());

        // Set Text Colors
        mediumColumnTitle.setForeground(textColor);
        mediumModeLeaderUsername.setForeground(textColor);
        mediumModeLeaderScore.setForeground(textColor);

        // Center the Text in the JLabels
        mediumColumnTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mediumModeLeaderUsername.setHorizontalAlignment(SwingConstants.CENTER);
        mediumModeLeaderScore.setHorizontalAlignment(SwingConstants.CENTER);

        // Layouts
        mediumColumnTitle.setLayout(new GridBagLayout());
        mediumModeLeaderUsername.setLayout(new GridBagLayout());
        mediumModeLeaderScore.setLayout(new GridBagLayout());

        // Text Content
        mediumColumnTitle.setFont(titleFont);
        mediumModeLeaderUsername.setFont(userNameFont);
        mediumModeLeaderScore.setFont(scoreFont);

        /*
         * Hard Mode Data
         */
        JLabel hardColumnTitle = new JLabel("HARD");
        JLabel hardModeLeaderUsername = new JLabel(this.leaderOnHardMode.getUsername());
        JLabel hardModeLeaderScore = new JLabel(this.leaderOnHardMode.getScore(GameMode.HARD).toString());

        // Center the Text in the JLabels
        hardColumnTitle.setHorizontalAlignment(SwingConstants.CENTER);
        hardModeLeaderUsername.setHorizontalAlignment(SwingConstants.CENTER);
        hardModeLeaderScore.setHorizontalAlignment(SwingConstants.CENTER);

        // Set Text Colors
        hardColumnTitle.setForeground(textColor);
        hardModeLeaderUsername.setForeground(textColor);
        hardModeLeaderScore.setForeground(textColor);

        // Layouts
        hardColumnTitle.setLayout(new GridBagLayout());
        hardModeLeaderUsername.setLayout(new GridBagLayout());
        hardModeLeaderScore.setLayout(new GridBagLayout());

        // Text Content
        hardColumnTitle.setFont(titleFont);
        hardModeLeaderUsername.setFont(userNameFont);
        hardModeLeaderScore.setFont(scoreFont);

        /*
         * Populating the Easy mode Panel
         */
        leftPanel.add(easyColumnTitle);
        leftPanel.add(easyModeLeaderUsername);
        leftPanel.add(easyModeLeaderScore);

        /*
         * Populating the Medium  mode Panel
         */
        centerPanel.add(mediumColumnTitle);
        centerPanel.add(mediumModeLeaderUsername);
        centerPanel.add(mediumModeLeaderScore);

        /*
         * Populating the Hard Mode Panel
         */
        rightPanel.add(hardColumnTitle);
        rightPanel.add(hardModeLeaderUsername);
        rightPanel.add(hardModeLeaderScore);

        /*
         * Populating the Body Container
         */
        bodyContainer.add(leftPanel);
        bodyContainer.add(centerPanel);
        bodyContainer.add(rightPanel);

        /*
         * Adding everything
         */
        this.add(bodyContainer);
        this.add(goToMenuButton, BorderLayout.SOUTH);
    }

    /**
     * Checks if all the attributes have been initalized correctly
     * if not it throws an error
     */
    @Override
    public void ready() {

    }

    /**
     * Creates the go to menu game mode button
     * @return this
     */
    public LeaderBoardScreen createGoToMenuButton(String label){
        /*
         * TODO: Add a gotToModeScreen logic : see List of buttons at the top  | Nicole
         */
        this.goToMenuButton = new JButton(label);
        return this;
    }
}

class FakeUser{
    private String username;
    private Map<GameMode, Integer> highestScores;

    FakeUser(String username){
        this.username = username;
        this.highestScores = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public Integer getScore(GameMode mode){
        return highestScores.get(mode);
    }

    public void setScore(GameMode mode, int score){
        this.highestScores.put(mode, score);
    }
}
