package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.settings.UIConfigurations;

import javax.swing.*;

public class ModeScreen extends AbstractScreen{

    private JButton goToEasyMazeButton;
    private JButton goToMediumMazeButton;
    private JButton gotToHardMazeButton;

    public ModeScreen(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        UIConfigurations.configure(this);
    }

    /**
     * Is implemented by the child class in order to build the header of the screen
     */
    @Override
    public void buildHeader() {

    }

    /**
     * Is implemented by the child class in order to build the body of the screen
     */
    @Override
    public void buildBody() {

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
        this.goToEasyMazeButton;
    }

    public ModeScreen createMediumButton(){

    }
}
