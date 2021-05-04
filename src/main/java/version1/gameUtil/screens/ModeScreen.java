package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.settings.UIConfigurations;

import javax.swing.*;
import java.awt.*;

public class ModeScreen extends AbstractScreen{

    private JButton goToEasyMazeButton;
    private JButton goToMediumMazeButton;
    private JButton gotToHardMazeButton;
    private JButton goToMenuButton;

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
        gotToHardMazeButton.setFont(buttonFont);
        goToMenuButton.setFont(buttonFont);

        /*
         * Fill menu option container
         */
        modeOptionsContainer.add(goToEasyMazeButton);
        modeOptionsContainer.add(goToMediumMazeButton);
        modeOptionsContainer.add(gotToHardMazeButton);
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
     * Creates the medium game mode button
     * @return this
     */
    public ModeScreen createMediumButton(String label){
        this.goToMediumMazeButton = new JButton(label);
        return this;
    }

    /**
     * Creates the hard game mode button
     * @return this
     */
    public ModeScreen createHardButton(String label){
        this.gotToHardMazeButton = new JButton(label);
        return this;
    }

    /**
     * Creates the got to menu game mode button
     * @return this
     */
    public ModeScreen createGoToMenuButton(String label){
        this.goToMenuButton = new JButton(label);
        this.goToMenuButton.addActionListener(e -> this.gameFrame.goTo(new MenuScreen(gameFrame)));
        return this;
    }
}
