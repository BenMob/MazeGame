package version1.gameUtil.listeners.implementations;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.interfaces.MazeActionListenerIF;
import version1.gameUtil.screens.LeaderBoardScreen;

import java.awt.event.ActionEvent;

public class GoToLeaderBoardBListener implements MazeActionListenerIF {
    private GameFrame gameFrame;

    public GoToLeaderBoardBListener(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }
    @Override
    public void handleEvent() {
        gameFrame.goTo(new LeaderBoardScreen(gameFrame));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
