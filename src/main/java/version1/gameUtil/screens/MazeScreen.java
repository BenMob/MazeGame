package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.implementations.GoToModeBListener;
import version1.gameUtil.mazegenerator.MazeMap;
import version1.gameUtil.settings.GameMode;
import version1.gameUtil.settings.UIConfigurations;
import version1.gameUtil.widgets.buttons.MazeButton;

import javax.swing.*;
import java.awt.*;


/**
 * The screen of the maze game
 */
public class MazeScreen extends AbstractScreen{

    private final MazeMap map;
    private JButton goToModeButton;

    public MazeScreen(GameFrame gameFrame, GameMode mode){
        this.gameFrame = gameFrame;         // Initialize the gameFrame
        this.map = new MazeMap(mode);       // Create the Maze Map for the specified mode
        this.addKeyListener(map);           // Listen to the map
        UIConfigurations.configure(this);   // Configure UI
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
        final JLabel bodyContainer = new JLabel(backgroundImage);
        final Font buttonFont = new Font("Bold", Font.BOLD, 20);

        /*
         * Define Layout manager
         */
        bodyContainer.setLayout(new GridBagLayout());

        /*
         * Style buttons
         */
        goToModeButton.setFont(buttonFont);

        /*
         * Adding everything on the screen
         */
        bodyContainer.add(this.map);
        this.add(bodyContainer);
        this.add(goToModeButton, BorderLayout.SOUTH);
    }

    /**
     * Checks if all the attributes have been initalized correctly
     * if not it throws an error
     */
    @Override
    public void ready() {
        // TODO: Implement this similarly to how it is in the LoginScreen | Ben
    }

    /**
     * Creates the got to menu game mode button
     * @return this
     */
    public MazeScreen createGoToModeButton(String label){
        this.goToModeButton = new MazeButton(label, new GoToModeBListener(gameFrame));
        return this;
    }
}
