package version1.gameUtil.data.collections;

import java.util.HashMap;
import java.util.Map;

public class PlayerRecord extends AbstractRecord{
    private int id;
    private String username;
    private String mode; // will be changed to a mode object after mode class is created
    private Map<String, Integer> highestScores;

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

    public Map<String, Integer> getHighestScores() {
        return highestScores;
    }
//**Once Mode class is pulled I will put a mode obj into parameter **
    public Map<String, Integer> setHighestScores() {
        this.highestScores = highestScores;
        return highestScores;
    }

}
