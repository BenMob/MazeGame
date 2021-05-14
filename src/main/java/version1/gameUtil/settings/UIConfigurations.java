package version1.gameUtil.settings;

import version1.gameUtil.GameFrame;
import version1.gameUtil.screens.*;

import javax.swing.*;
import java.awt.*;


/**
 * This is a utility class that helps configure the screen UI components
 * It does all the heavy lifting for the Screens and GameFrame classes which
 * reduces complexity in those classes
 */
public class UIConfigurations {

    public static final String BACKGROUND = "images/background.png";
    public static final String AMONGUS = "images/amongus.png";
    public  static final String MAZE_GAME_LOGO = "images/mazegametitle.png";
    private static final Font headerLabelTextFont = new Font("Bold",Font.BOLD, 30);
    private static final Color headerLabelForeground = Color.WHITE;

    /**
     * UI Configurations for the Grame Frame
     * @param gameFrame The MainFrame
     */
    public static void configure(GameFrame gameFrame){

        // Min Width of the GameFrame
        final int minFrameWidth = 700;

        // Min Height of the GameFrame
        final int minFrameHeight = 500;

        // Min Dimension of the GameFrame
        final  Dimension minDimension = new Dimension(minFrameWidth, minFrameHeight);

        // Title of the GameFrame
        final String title = "Maze Game";

        // Determines whether the frame should be resizable
        final boolean isResizable = false;

        // Starting Screen by default
        final AbstractScreen firstScreen = new LoginScreen(gameFrame);

        // Build starting screen
        firstScreen.buildUI();

        /*
         * Setting value properties
         */
        gameFrame.renderFirst(firstScreen);     // Sets the screen that will be rendered first when the game is launched
        gameFrame.setTitle(title);
        gameFrame.setSize(minDimension);
        gameFrame.setMinimumSize(minDimension);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(isResizable);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * UI Configurations for the Login Screen
     * @param loginScreen loginScreen
     */
    public static void configure(LoginScreen loginScreen){
        final ImageIcon icon = new ImageIcon(UIConfigurations.AMONGUS);
        final String headerLabelText = "MAZE GAME";
        final Color headerLabelForeground = Color.WHITE;
        final String loginButtonLabelText = "Log In";
        final String gotToRegisterButtonLabelText = "New User";
        final String inputBoxLabelText = "ENTER NICKNAME:";
        final int MAX_LENGTH = 20;
        final Color gameFrameBGColor = new Color(30, 49, 120);

        /*
         * Setting value properties
         */
        loginScreen.setLayout(new BorderLayout());
        loginScreen.setIcon(icon)
                .setHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .createLoginButton(loginButtonLabelText)
                .createGoToRegistrationScreenButton(gotToRegisterButtonLabelText)
                .setUserNameInputFieldLabel(inputBoxLabelText)
                .createUserNameInputField(MAX_LENGTH)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }


    /**
     * UI Configurations for the Login Screen
     * @param registrationScreen loginScreen
     */
    public static void configure(RegistrationScreen registrationScreen){
        final ImageIcon icon = new ImageIcon(UIConfigurations.AMONGUS);
        final String headerLabelText = "NEW ACCOUNT";
        final Color headerLabelForeground = Color.WHITE;
        final String registerButtonLabelText = "Register";
        final String gotToLoginButtonLabelText = "Back to Login";
        final String inputBoxLabelText = "CREATE NICKNAME:";
        final int MAX_LENGTH = 20;
        final Color gameFrameBGColor = new Color(80, 0, 100);

        /*
         * Setting value properties
         */
        registrationScreen.setLayout(new BorderLayout());
        registrationScreen.setIcon(icon)
                .createRegisterButton(registerButtonLabelText)
                .createGoToLoginScreenButton(gotToLoginButtonLabelText)
                .createUserNameInputFieldLabel(inputBoxLabelText)
                .createUserNameInputField(MAX_LENGTH)
                .setHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }

    /**
     * UI Configurations for the MenuScreen
     * @param menuScreen loginScreen
     */
    public static void configure(MenuScreen menuScreen){
        final String headerLabelText = "MENU";
        final Color headerLabelForeground = Color.WHITE;
        final String playButtonText = "Play";
        final String leaderBoardButtonText = "LeaderBoard";
        final String quitButtonText = "Quit";
        final Color gameFrameBGColor = new Color(30, 49, 120);

        /*
         * Setting value properties
         */
        menuScreen.setLayout(new BorderLayout());
        menuScreen.createPlayButton(playButtonText)
                .createLeaderBoardButton(leaderBoardButtonText)
                .createQuitButton(quitButtonText)
                .createHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }

    /**
     * UI Configurations for the MezeScreen
     * @param  modeScreen ins instace of a MazeScreen
     */
    public static void configure(ModeScreen modeScreen){
        final String headerLabelText = "PICK MODE";
        final String easyButtonText = "Easy";
        final String mediumButtonText = "Medium";
        final String hardButtonText = "Hard";
        final String goToMenuText = "Cancel";
        final Color gameFrameBGColor = new Color(30, 49, 120);

        /*
         * Setting values property
         */
        modeScreen.setLayout(new BorderLayout());
        modeScreen.createEasyButton(easyButtonText)
                .createMediumButton(mediumButtonText)
                .createHardButton(hardButtonText)
                .createGoToMenuButton(goToMenuText)
                .createHeaderLabel(headerLabelText, headerLabelTextFont ,headerLabelForeground)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }

    /**
     * UI Configurations for the MezeScreen
     * @param  mazeScreen ins instace of a MazeScreen
     */
    public static void configure(MazeScreen mazeScreen){
        final String headerLabelText = "FIND YOUR WAY OUT OF THIS";
        final String goToModeText = "New Game";
        final String goToMenuButtonText = "Back to Menu";
        final Color gameFrameBGColor = new Color(30, 49, 120);

        /*
         * Setting values property
         */
        mazeScreen.setLayout(new BorderLayout());
        mazeScreen.createGoToModeButton(goToModeText)
                .createGoToMenuButton(goToMenuButtonText)
                .createHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }

    /**
     * UI Configurations for the LeaderBoardScreen
     * @param  leaderBoardScreen ins instace of a MazeScreen
     */
    public static void configure(LeaderBoardScreen leaderBoardScreen){
        final String headerLabelText = "CURRENT CHAMPIONS";
        final String goToMenuText = "Back to Menu";
        final Color gameFrameBGColor = new Color(30, 49, 120);

        /*
         * Setting values property
         */
        leaderBoardScreen.setLayout(new BorderLayout());
        leaderBoardScreen.createGoToMenuButton(goToMenuText)
                .createHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }
}
