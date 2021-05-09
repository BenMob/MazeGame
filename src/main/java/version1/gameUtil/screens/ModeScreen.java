package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.implementations.*;
import version1.gameUtil.settings.UIConfigurations;
import version1.gameUtil.widgets.buttons.MazeButton;

import javax.swing.*;
import java.awt.*;

public class ModeScreen extends AbstractScreen{

    private JButton goToEasyMazeButton;
    private JButton goToMediumMazeButton;
    private JButton goToHardMazeButton;
    private JButton goToMenuButton;
    private JButton goToCancelButton;

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
        final ImageIcon backgroundImage = new ImageIcon("background.png");
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
        goToMenuButton.setFont(buttonFont);

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
        this.add(goToMenuButton, BorderLayout.SOUTH);
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
        this.goToEasyMazeButton = new JButton(label);
        return this;
    }

    /**
     * Logic for Easy Mode button - Goes to Medium Mode Game Screen
     * @param goToEasyModeText String, label for button
     * return this
     */
    public ModeScreen createGoToEasyMazeButton(String goToEasyModeText) {
        this.goToEasyMazeButton= new MazeButton(goToEasyModeText, new GoToEasyMazeBListener(gameFrame));
        return this;
    }


    /**
     * Creates the medium game mode button
     * @return this
     */
    public ModeScreen createMediumButton(String label){
        this.goToMediumMazeButton = new JButton(label);
        return this;
    }

    /*
     * Logic for Medium Mode button - Goes to Medium Mode Game Screen
     * @param goToMediumModeText String, label for button
     * @return this
     */
    public ModeScreen createGoToMediumMazeButton(String goToMediumModeText) {
        this.goToMediumMazeButton= new MazeButton(goToMediumModeText, new GoToMediumMazeBListener(gameFrame));
        return this;
    }

    /**
     * Creates the hard game mode button
     * @return this
     */
    public ModeScreen createHardButton(String label){
        this.goToHardMazeButton = new JButton(label);
        return this;
    }
    /*
     * Logic for Hard Mode button - Goes to Hard Mode Game Screen
     * @label goToHardModeText String, label for button
     * return this
     */
    public ModeScreen createGoToHardMazeButton(String goToHardModeText) {
        this.goToHardMazeButton= new MazeButton(goToHardModeText, new GoToHardMazeBListener(gameFrame));
        return this;
    }
    /**
     * Creates the go to menu game mode button
     * @return this
     */
    public ModeScreen createCancelButton(String label){
        /*
         * TODO: Add a gotToModeScreen logic : see List of buttons at the top  | Nicole
         */
        this.goToMenuButton = new JButton(label);
        return this;
    }
    /*
     * Logic for cancel button - Goes to Main Menu Screen
     * @label label String, label for button
     * return this
     */
    public ModeScreen createGoToCancelButton(String label) {
        this.goToMenuButton = new MazeButton(label, new GoToMenuBListener(gameFrame));
        return this;
    }
}
