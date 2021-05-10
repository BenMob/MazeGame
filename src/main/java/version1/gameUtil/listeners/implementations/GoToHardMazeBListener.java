package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.MazeScreen;
import version1.gameUtil.settings.GameMode;

import java.awt.event.ActionEvent;

public class GoToHardMazeBListener implements MazeActionListenerIF {
    private final GameFrame gameFrame;

    public GoToHardMazeBListener(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }
    @Override
    public void handleEvent() {
        gameFrame.goTo(new MazeScreen(gameFrame, GameMode.HARD));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
