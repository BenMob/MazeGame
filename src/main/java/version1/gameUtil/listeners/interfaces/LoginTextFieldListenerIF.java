package version1.gameUtil.listeners.interfaces;

import javax.swing.event.DocumentListener;


public interface LoginTextFieldListenerIF extends DocumentListener {

    /**
     * Reads the text inside of the login text field
     * @return username
     */
    String readLoginInput();
}
