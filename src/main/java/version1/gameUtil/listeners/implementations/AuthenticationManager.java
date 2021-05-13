package version1.gameUtil.listeners.implementations;


import version1.gameUtil.GameFrame;
import version1.gameUtil.screens.LoginScreen;
import version1.gameUtil.screens.MenuScreen;
import version1.gameUtil.widgets.buttons.MazeLoginButton;
import version1.gameUtil.widgets.buttons.MazeRegisterButton;
import version1.gameUtil.widgets.inputfields.LoginTextField;
import version1.gameUtil.widgets.inputfields.RegisterTextField;

import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;

public class AuthenticationManager extends AuthenticationMediator{

    public AuthenticationManager(GameFrame gameFrame) {
        super(gameFrame);
    }

    @Override
    public void handleLogin() {
        final String USERNAME = readLoginInput();
        final boolean SUCCESS = ((MazeLoginButton) loginButton).handleLogin(USERNAME);
        if(SUCCESS){
            System.out.println("Successfully logged In. Hi " + USERNAME);
            gameFrame.goTo(new MenuScreen(gameFrame));
        }else{
            System.out.println("Failed To Log in with username \"" + USERNAME + "\", please create an account first.");
        }
    }

    @Override
    public void handleRegister() {
        final String USERNAME = readRegisterInput();
        final boolean SUCCESS = ((MazeRegisterButton) registerButton).handleRegister(USERNAME);
        if(SUCCESS){
            System.out.println("Account successfully created. Welcome " + USERNAME);
        }else{
            System.out.println("Failed To Register \"" + USERNAME + "\" since the username already exists");
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /*
         *  Gets the source of the event | LoginButton, RegisterButton, LoginTextField or RegisterTextField
         */
        final Object ACTION_TRIGGERER = e.getSource().getClass();
        if(ACTION_TRIGGERER.equals(MazeLoginButton.class)){
            handleLogin();
        }else if(ACTION_TRIGGERER.equals(MazeRegisterButton.class)){
            handleRegister();
        }else if(ACTION_TRIGGERER.equals(LoginTextField.class)){

            /*
             * If the user pressed the enter key and the text box is not empty,
             * try to log them in
             */
            if(loginTextField.getText().length() > 0) {
                handleLogin();
            }
        }else if(ACTION_TRIGGERER.equals(RegisterTextField.class)){

            /*
             * If the user pressed the enter key and the text box is not empty,
             * try to register them
             */
            if(registerTextField.getText().length() > 0) {
                handleRegister();
            }
        }
    }

    /**
     * Reads the text inside of the login text field
     *
     * @return username
     */
    @Override
    public String readLoginInput() {
        return loginTextField.readInput();
    }

    /**
     * Reads the user name from the registration input field
     *
     * @return username
     */
    @Override
    public String readRegisterInput() {
        return registerTextField.readInput();
    }

    /**
     * Gives notification that there was an insert into the document.  The
     * range given by the DocumentEvent bounds the freshly inserted region.
     *
     * @param e the document event
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        final boolean BUTTON_SHOULD_BE_ENABLED = e.getOffset() == 0;
        if(BUTTON_SHOULD_BE_ENABLED){
            if(!(loginButton == null)){
                loginButton.enableButton();
            }

            if(!(registerButton == null)){
                registerButton.enableButton();
            }
        }
    }

    /**
     * Gives notification that a portion of the document has been
     * removed.  The range is given in terms of what the view last
     * saw (that is, before updating sticky positions).
     *
     * @param e the document event
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        final boolean BUTTON_SHOULD_BE_DISABLED = e.getOffset() == 0;
        if(BUTTON_SHOULD_BE_DISABLED){
            if(!(loginButton == null)){
                loginButton.disableButton();
            }

            if(!(registerButton == null)){
                registerButton.disableButton();
            }
        }
    }

    /**
     * Gives notification that an attribute or set of attributes changed.
     *
     * @param e the document event
     */
    @Override
    public void changedUpdate(DocumentEvent e) {
        // Not Implemented
    }
}
