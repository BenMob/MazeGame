package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.LoginScreen;

import java.awt.event.ActionEvent;

public class GoToLoginBListener implements MazeActionListenerIF {
    private GameFrame gameFrame;

    public GoToLoginBListener(GameFrame gameFrame) {
        this.gameFrame= gameFrame;
    }

    @Override
    public void handleEvent() {
        gameFrame.goTo(new LoginScreen(gameFrame));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
