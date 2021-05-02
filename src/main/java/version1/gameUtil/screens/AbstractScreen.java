package version1.gameUtil.screens;

import javax.swing.*;

/**
 * This class is the abstract class that all the screen classes inherit from
 */
public abstract class AbstractScreen extends JPanel {

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
}
