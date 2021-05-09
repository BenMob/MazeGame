package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.implementations.GoToModeBListener;
import version1.gameUtil.settings.UIConfigurations;
import version1.gameUtil.widgets.buttons.MazeButton;

import javax.swing.*;
import java.awt.*;

public class MenuScreen extends AbstractScreen{

    private JButton playButton;
    private JButton leaderBoardButton;
    private JButton quitButton;

    public MenuScreen(GameFrame gameFrame){
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
         * First Things First: Initliaze the
         */
        final ImageIcon backgroundImage = new ImageIcon("background.png");
        final ImageIcon mazeGameLogoImage = new ImageIcon("mazegametitle.png");
        final JLabel mazeGameLogo = new JLabel(mazeGameLogoImage);
        final JLabel bodyContainer = new JLabel(backgroundImage);
        final JPanel menuOptionsContainer = new JPanel();
        final Font buttonFont = new Font("Bold", Font.BOLD, 20);
        final int rows = 12;
        final int columns = 1;

        /*
         * Define Layouts
         */
        mazeGameLogo.setLayout(new GridBagLayout());
        bodyContainer.setLayout(new BorderLayout());
        menuOptionsContainer.setLayout(new GridLayout(rows, columns));

        /*
         * Style Buttons
         */
        playButton.setFont(buttonFont);
        leaderBoardButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        /*
         * Fill menu option container
         */
        menuOptionsContainer.add(playButton);
        menuOptionsContainer.add(leaderBoardButton);
        menuOptionsContainer.add(quitButton);
        menuOptionsContainer.setOpaque(false);

        /*
         * Adds menu option container
         */
        mazeGameLogo.add(menuOptionsContainer);
        bodyContainer.add(mazeGameLogo, BorderLayout.CENTER);

        /*
         * Display everything
         */
        this.add(bodyContainer, BorderLayout.CENTER);

    }

    /**
     * Checks if all the attributes have been initalized correctly
     * if not it throws an error
     */
    @Override
    public void ready() {
        // TODO: Implement this similarly to how it is in the LoginScreen  | Ben
    }

    /**
     * Creates the play button and mode listener, transitions menu screen to mode screen
     * @param label the text label of the button
     * @return this
     */
    public MenuScreen createPlayButton(String label) {
        this.playButton=new MazeButton(label, new GoToModeBListener(gameFrame));
        return this;
    }

    /**
     * Creates the leaderboard button with the follwonf label
     * @param label: a String
     * @return this
     */
    public MenuScreen createLeaderBoardButton(String label) {
        /*
         * TODO: Add a goToLeaderBoardScreen Logic here on the leaderBoardButton
         */
        this.leaderBoardButton = new JButton(label);
        return this;
    }

    /**
     * Creates the quit button with the following label
     * @param label A String
     * @return this
     */
    public MenuScreen createQuitButton(String label) {
        /*
         * TODO: Add a goToLoginScreen Logic here on the this.quitButton
         * Basicaly when the user clicka quit, it should take them back to the login screen
         */
        this.quitButton = new JButton(label);
        return this;
    }
}
