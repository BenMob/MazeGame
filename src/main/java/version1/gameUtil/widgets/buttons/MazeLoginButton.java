package version1.gameUtil.widgets.buttons;

import version1.gameUtil.listeners.interfaces.LoginBListenerIF;

/**
 * This is the Login button
 */
public class MazeLoginButton extends MazeButton {
    // TODO: Remove this if feature works
    // private LoginBListenerIF mediator;
    public MazeLoginButton(String label, LoginBListenerIF listener) {
        super(label, listener);
        this.addActionListener(listener);
    }

}
