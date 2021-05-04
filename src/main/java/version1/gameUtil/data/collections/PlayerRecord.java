package version1.gameUtil.data.collections;

import version1.gameUtil.settings.GameMode;

import java.util.HashMap;
import java.util.Map;

public class PlayerRecord extends AbstractRecord{
    private int id;
    private String username;
    private Map<GameMode, Integer> highestScores;

    public PlayerRecord()
    {
        this.highestScores = new HashMap<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
