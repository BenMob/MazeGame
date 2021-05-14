package version1.gameUtil.data.models;

import version1.gameUtil.settings.GameMode;

import java.util.HashMap;
import java.util.Map;

public class PlayerRecord extends AbstractRecord{
    private String username;
    private Map<GameMode, Integer> highestScores;

    public PlayerRecord(String username) {
        this.username = username;
        this.highestScores = new HashMap<>();
        this.setHighestScore(0, GameMode.EASY);
        this.setHighestScore(0, GameMode.MEDIUM);
        this.setHighestScore(0, GameMode.HARD);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<GameMode,Integer> getHighestScores() {
        return highestScores;
    }

    /**
     *
     * @param score
     * @param mode
     * Updates highest score with the given game mode and new score
     */
    public void setHighestScore(int score, GameMode mode) {
        this.highestScores.put(mode,score);
    }

}
