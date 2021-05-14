package version1.gameUtil;

import version1.gameUtil.listeners.implementations.AuthenticationManager;
import version1.gameUtil.screens.AbstractScreen;
import version1.gameUtil.settings.UIConfigurations;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    // The screen that is currently displayed on the GameFrame
    private AbstractScreen currentScreen;

    // The authentication manager object
    private final AuthenticationManager AUTHENTICATION_MANAGER;

    /**
     * Configure default settings on the JFrame
     */
    public GameFrame(){

        // Creates an instance of an Authentication manager
        AUTHENTICATION_MANAGER = new AuthenticationManager(this);
        UIConfigurations.configure(this);
    }

    /**
     * Swaps screens on the GameFrame. This process happens in a different thread
     * to prevent the screen from lagging.
     * @param nextScreen is the next Screen that should be displayed on the GameFrame
     */
    public void goTo(AbstractScreen nextScreen){

        // Creates a Runnable that will run the render method
        Runnable screenRenderer = () -> renderNext(nextScreen);

        // Creates a new thread form the screenRenderer
        Thread screenRendererThread = new Thread(screenRenderer);

        // Calls the run method of the thread
        screenRendererThread.start();
    }

    /* Add a currentScreen if there isn't any. this is called to initialize the starting screen.
     * This initializetion can only be done once
     * @param screen: Screen to be rendered
     */
    public void renderFirst(AbstractScreen screen){
        if(this.currentScreen == null){
            this.currentScreen = screen;
            this.getContentPane().add(screen);
        }

    }

    /**
     * This is replaces the currentScreen with a new screen. This method is named renderNext() because it is to be called
     * only after the render() method has been called at least once in the past to insure the currentScreen is not null.
     * @param screen: Screen to be rendered
     */
    private void renderNext(AbstractScreen screen){

        // Gets the Content Panel
        Container content = this.getContentPane();

        // Remove the current screen from the Content Panel
        content.remove(currentScreen);

        // Sets the current screen to the new Screen to be rendered
        currentScreen = screen;

        // builds the UI of the current screen
        currentScreen.buildUI();

        // Add the current screen on the Content Panel
        content.add(currentScreen);

        // Makes the current screen focusable
        currentScreen.setFocusable(true);

        // Gives current screenfocus
        currentScreen.grabFocus();

        // Validate the content
        content.revalidate();

        // Repaint the Content Panel with the new screen
        content.repaint();
    }

    /**
     * Sets the background color
     * @param color: background color
     */
    public void setBackgroundColor(Color color){
        this.getContentPane().setBackground(color);
    }

    /**
     * Returns the Authentication manager so that auth widgets can be registered to it
     * @return AuthenticationManager
     */
    public AuthenticationManager authentication(){
        return AUTHENTICATION_MANAGER;
    }

    /**
     * Sets the frame to be visible to launch the game
     */
    public void launch(){
        this.pack();
        this.setVisible(true);
    }
}


