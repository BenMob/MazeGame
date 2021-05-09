package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.MenuScreen;

import java.awt.event.ActionEvent;

public class GoToMenuBListener implements MazeActionListenerIF {
    private GameFrame gameFrame;

    public GoToMenuBListener(GameFrame gameFrame){
        this.gameFrame=gameFrame;
    }

    @Override
    public void handleEvent() {
        gameFrame.goTo(new MenuScreen(gameFrame));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
