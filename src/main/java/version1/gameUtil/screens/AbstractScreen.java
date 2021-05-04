package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the abstract class that all the screen classes inherit from
 */
public abstract class AbstractScreen extends JPanel {

    protected JLabel headerLabel;    // The name of the screen
    protected GameFrame gameFrame;   // The frame on which the screen lives
    protected boolean isConfigured;  // is set to true if the screen attributes have all be initialized

    /**
     * Builds the user interface by calling createHeader() and createBody()
     */
    public void buildUI(){
        this.buildHeader();
        this.buildBody();
    }

    /**
     * Is implemented by the child class in order to build the header of the screen
     */
    protected abstract void buildHeader();

    /**
     * Is implemented by the child class in order to build the body of the screen
     */
    protected abstract void buildBody();

    /**
     * Checks if all the attributes have been initalized correctly
     * if not it throws an error
     */
    public abstract void ready();

    /**
     * Creates a Label for the header
     * @param headerLabelText : Label Text
     * @param font : Label text font
     * @param textColor : Label text color
     * @return this
     */
    public AbstractScreen setHeaderLabel(String headerLabelText, Font font, Color textColor) {
        this.headerLabel = new JLabel(headerLabelText);
        this.headerLabel.setFont(font);
        this.headerLabel.setForeground(textColor);
        return this;
    }

    /**
     * Sets the background color of the parent GameFrame
     * @param color : color Object
     */
    public AbstractScreen setGameFrameBackgroundColor(Color color){
        this.gameFrame.setBackgroundColor(color);
        return this;
    }
}
