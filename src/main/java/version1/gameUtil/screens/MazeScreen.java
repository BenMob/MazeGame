package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.settings.GameMode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The screen of the maze game
 */
public class MazeScreen extends AbstractScreen implements KeyListener {

    private int offset;
    private int gridSize;
    private boolean gameOver;

    public MazeScreen(GameFrame gameFrame, GameMode mode){
        // Initialize things
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

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
}
