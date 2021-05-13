package version1.gameUtil.listeners.implementations;

import version1.gameUtil.listeners.interfaces.LoginBListenerIF;
import version1.gameUtil.listeners.interfaces.LoginTextFieldListenerIF;
import version1.gameUtil.listeners.interfaces.RegisterBListenerIF;
import version1.gameUtil.listeners.interfaces.RegisterTextFieldListenerIF;
import version1.gameUtil.widgets.buttons.AbstractMazeButton;
import version1.gameUtil.widgets.inputfields.AbstractMazeTextField;


/**
 * This is the mediator class that takes care of the authentication system in MazeGame
 */
public abstract class AuthenticationMediator implements LoginBListenerIF, RegisterBListenerIF, LoginTextFieldListenerIF, RegisterTextFieldListenerIF {

    protected AbstractMazeButton loginButton;
    protected AbstractMazeButton registerButton;
    protected AbstractMazeTextField loginTextField;
    protected AbstractMazeTextField registerTextField;

    /**
     * Makes the mediator listen to the loginButton
     * @param loginButton : The Login Button
     */
    public void linkLoginButton(AbstractMazeButton loginButton){
        loginButton.addActionListener(this);
        this.loginButton = loginButton;
        this.loginButton.disableButton();
    }

    /**
     * Makes the mediator listen to the registerButton
     * @param registerButton : The Login Button
     */
    public void linkRegisterButton(AbstractMazeButton registerButton){
        registerButton.addActionListener(this);
        this.registerButton = registerButton;
        this.registerButton.disableButton();
    }

    /**
     * Makes the mediator listen to the loginTextField
     * @param loginTextField : The login text field
     */
    public void linkLoginTextField(AbstractMazeTextField loginTextField){
        loginTextField.addActionListener(this);
        loginTextField.getDocument().addDocumentListener(this);
        this.loginTextField = loginTextField;
    }

    /**
     * Makes the mediator listen to the registerTextField
     * @param registerTextField : the registration text field
     */
    public void linkRegisterTextField(AbstractMazeTextField registerTextField){
        registerTextField.addActionListener(this);
        registerTextField.getDocument().addDocumentListener(this);
        this.registerTextField = registerTextField;
    }
}
