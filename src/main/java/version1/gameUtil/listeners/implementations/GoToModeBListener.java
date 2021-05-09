package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.MenuScreen;
import version1.gameUtil.screens.ModeScreen;

import java.awt.event.ActionEvent;

public class GoToModeBListener implements MazeActionListenerIF {
    private GameFrame gameFrame;

    public GoToModeBListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void handleEvent() {
        gameFrame.goTo(new ModeScreen(gameFrame));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
