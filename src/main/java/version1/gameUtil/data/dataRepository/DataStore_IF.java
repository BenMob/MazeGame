package version1.gameUtil.data.dataRepository;

import version1.gameUtil.data.models.PlayerRecord;
import version1.gameUtil.data.collections.RecordList;

import java.util.List;
import java.util.Map;

public interface DataStore_IF {
    /**
     *  Tries to log the user in
     * @param username : a username
     * @return boolean
     */
    boolean login(String username);

    /**
     * Tries to register a user
     * @param username: a username
     * @return boolean
     */
    boolean register(String username);

    /**
     * Queries the currently logged in player
     * @return PlayerRecord
     */
    PlayerRecord queryPlayerRecord();

    /**
     * Queries the  currently logged in player
     * @return RecordList
     */
    List<PlayerRecord> queryRecordsAsList();

    Map<String, PlayerRecord> queryRecordsAsMap();
}
