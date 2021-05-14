package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.implementations.*;
import version1.gameUtil.settings.UIConfigurations;
import version1.gameUtil.widgets.buttons.MazeButton;

import javax.swing.*;
import java.awt.*;

public class ModeScreen extends AbstractScreen{

    private MazeButton goToEasyMazeButton;
    private MazeButton goToMediumMazeButton;
    private MazeButton goToHardMazeButton;
    private MazeButton goToModeButton;

    public ModeScreen(GameFrame gameFrame){
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
        final ImageIcon backgroundImage = new ImageIcon(UIConfigurations.BACKGROUND);
        final JLabel bodyContainer = new JLabel(backgroundImage);
        final JPanel modeOptionsContainer = new JPanel();
        final Font buttonFont = new Font("Bold", Font.BOLD, 20);
        final int rows = 1;
        final int columns = 3;

        /*
         * Define Layouts
         */
        bodyContainer.setLayout(new GridBagLayout());
        modeOptionsContainer.setLayout(new GridLayout(rows, columns));

        /*
         * Style Buttons
         */
        goToEasyMazeButton.setFont(buttonFont);
        goToMediumMazeButton.setFont(buttonFont);
        goToHardMazeButton.setFont(buttonFont);
        goToModeButton.setFont(buttonFont);

        /*
         * Fill menu option container
         */
        modeOptionsContainer.add(goToEasyMazeButton);
        modeOptionsContainer.add(goToMediumMazeButton);
        modeOptionsContainer.add(goToHardMazeButton);
        modeOptionsContainer.setOpaque(false);

        /*
         * Display everything
         */
        bodyContainer.add(modeOptionsContainer);
        this.add(goToModeButton, BorderLayout.SOUTH);
        this.add(bodyContainer, BorderLayout.CENTER);

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
     * Creates the easy game mode button
     * @return this
     */
    public ModeScreen createEasyButton(String label){
        this.goToEasyMazeButton = new MazeButton(label, new GoToEasyMazeBListener(gameFrame));
        return this;
    }

    /**
     * Creates the medium game mode button
     * @return this
     */
    public ModeScreen createMediumButton(String label){
        this.goToMediumMazeButton = new MazeButton(label, new GoToMediumMazeBListener(gameFrame));
        return this;
    }

    /**
     * Creates the hard game mode button
     * @return this
     */
    public ModeScreen createHardButton(String label){

        this.goToHardMazeButton = new MazeButton(label, new GoToHardMazeBListener(gameFrame));
        return this;
    }

    /**
     * Creates the go to menu game mode button
     * @return this
     */
    public ModeScreen createGoToMenuButton(String label){
        this.goToModeButton = new MazeButton(label, new GoToMenuBListener(gameFrame));
        return this;
    }
}
