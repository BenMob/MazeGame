package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.RegistrationScreen;

import java.awt.event.ActionEvent;

public class GoToRegistrationBListener implements MazeActionListenerIF {
    private GameFrame gameFrame;

    public GoToRegistrationBListener(GameFrame gameFrame){
        this.gameFrame= gameFrame;
    }

    @Override
    public void handleEvent() {
        gameFrame.goTo(new RegistrationScreen(gameFrame));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
