package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.MazeScreen;
import version1.gameUtil.settings.GameMode;

import java.awt.event.ActionEvent;

public class GoToEasyMazeBListener implements MazeActionListenerIF {
    private final GameFrame gameFrame;

    public GoToEasyMazeBListener(GameFrame gameFrame) {
        this.gameFrame= gameFrame;
    }
    @Override
    public void handleEvent() {
        gameFrame.goTo(new MazeScreen(gameFrame, GameMode.EASY));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
