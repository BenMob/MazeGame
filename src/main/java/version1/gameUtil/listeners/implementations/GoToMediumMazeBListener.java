package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.MazeScreen;
import version1.gameUtil.settings.GameMode;

import java.awt.event.ActionEvent;

public class GoToMediumMazeBListener implements MazeActionListenerIF {
    private final GameFrame gameFrame;

    public GoToMediumMazeBListener(GameFrame gameFrame) {
        this.gameFrame= gameFrame;
    }

    @Override
    public void handleEvent() {
        gameFrame.goTo(new MazeScreen(gameFrame, GameMode.MEDIUM));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
