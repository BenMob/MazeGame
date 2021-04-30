package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.LoginBListenerIF;
import version1.gameUtil.listeners.interfaces.MazeTextFieldIF;
import version1.gameUtil.listeners.interfaces.RegisterBListenerIF;
import version1.gameUtil.widgets.buttons.MazeLoginButton;
import version1.gameUtil.widgets.buttons.MazeRegisterButton;
import version1.gameUtil.widgets.inputfields.MazeTextField;

import java.awt.event.ActionEvent;

public class AuthenticationManager implements LoginBListenerIF, RegisterBListenerIF, MazeTextFieldIF {
    private MazeLoginButton loginButton;
    private MazeRegisterButton registerButton;
    private MazeTextField textField;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public AuthenticationManager(GameFrame f){

    }

    public void handleLogin(){

    }

    public void handleRegister(){

    }
    public String readInput(){

        return null; // placeholder - update to return String
    }
}
