package version1.gameUtil.settings;

import version1.gameUtil.GameFrame;
import version1.gameUtil.screens.AbstractScreen;
import version1.gameUtil.screens.LoginScreen;
import version1.gameUtil.screens.RegistrationScreen;

import javax.swing.*;
import java.awt.*;


/**
 * This is a utility class that helps configure the screen UI components
 * It does all the heavy lifting for the Screens and GameFrame classes which
 * reduces complexity in those classes
 */
public class UIConfigurations {

    /**
     * UI Configurations for the Grame Frame
     * @param gameFrame The MainFrame
     */
    public static void configure(GameFrame gameFrame){

        // Min Width of the GameFrame
        final int minFrameWidth = 700;

        // Min Height of the GameFrame
        final int minFrameHeight = 450;

        // Min Dimension of the GameFrame
        final  Dimension minDimension = new Dimension(minFrameWidth, minFrameHeight);

        /*
         * TODO: Find a larger background image that would fill the whole screen when the user is on full screen
         *  for now the background just has normal colors.
         *
        // Background image of the frame
        final ImageIcon frameBackgroundImage = new ImageIcon("background.png");

        // Background of the frame
        final JLabel backgroundWallPaper = new JLabel(frameBackgroundImage);

        // Sets the size of the background wallpaper
        backgroundWallPaper.setSize(maxDimension);
        */

        // Title of the GameFrame
        final String title = "Maze Game";

        // Determines whether the frame should be resizable
        final boolean isResizable = true;

        // Jframe layout manager
        final LayoutManager layout = new GridBagLayout();

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
        gameFrame.setLayout(layout);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * UI Configurations for the Login Screen
     * @param loginScreen loginScreen
     */
    public static void configure(LoginScreen loginScreen){
        final ImageIcon icon = new ImageIcon("amongus.png");
        final String headerLabelText = "MAZE GAME";
        final Font headerLabelTextFont = new Font("Bold",20, 20);
        final Color headerLabelForeground = Color.WHITE;
        final String loginButtonLabelText = "Log In";
        final String gotToRegisterButtonLabelText = "New User";
        final String inputBoxLabelText = "ENTER USERNAME:";
        final int MAX_LENGTH = 20;
        final Color gameFrameBGColor = new Color(34,0,85);

        /*
         * Setting value properties
         */
        loginScreen.setLayout(new BorderLayout());
        loginScreen.setIcon(icon)
                .setHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .setLoginButton(loginButtonLabelText)
                .setGoToRegistrationScreenButton(gotToRegisterButtonLabelText)
                .setUserNameInputFieldLabel(inputBoxLabelText)
                .setUserNameInputFieldMaxLength(MAX_LENGTH)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }


    /**
     * UI Configurations for the Login Screen
     * @param registrationScreen loginScreen
     */
    public static void configure(RegistrationScreen registrationScreen){
        final ImageIcon icon = new ImageIcon("amongus.png");
        final String headerLabelText = "NEW ACCOUNT";
        final Font headerLabelTextFont = new Font("Bold",20, 20);
        final Color headerLabelForeground = Color.WHITE;
        final String registerButtonLabelText = "Register";
        final String gotToLoginButtonLabelText = "Back to Login";
        final String inputBoxLabelText = "ENTER USERNAME:";
        final int MAX_LENGTH = 20;
        final Color gameFrameBGColor = new Color(80, 0, 100);

        /*
         * Setting value properties
         */
        registrationScreen.setLayout(new BorderLayout());
        registrationScreen.setIcon(icon)
                .setHeaderLabel(headerLabelText, headerLabelTextFont, headerLabelForeground)
                .setRegisterButton(registerButtonLabelText)
                .setGoToLoginScreenButton(gotToLoginButtonLabelText)
                .setUserNameInputFieldLabel(inputBoxLabelText)
                .setUserNameInputFieldMaxLength(MAX_LENGTH)
                .setGameFrameBackgroundColor(gameFrameBGColor)
                .ready();
    }
}