package version1.gameUtil.listeners.interfaces;

import javax.swing.event.DocumentListener;

public interface RegisterTextFieldListenerIF extends DocumentListener {

    /**
     * Reads the user name from the registration input field
     * @return username
     */
    String readRegisterInput();
}
