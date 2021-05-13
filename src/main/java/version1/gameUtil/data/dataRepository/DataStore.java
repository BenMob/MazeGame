package version1.gameUtil.data.dataRepository;

import version1.gameUtil.data.models.PlayerRecord;
import version1.gameUtil.data.collections.RecordList;

import java.util.Map;


public class DataStore implements DataStore_IF{

    private RecordList recordsAsList;

    private static DataStore dsInstance;

    private Map<String,PlayerRecord> recordsAsHashMap;

    private PlayerRecord currentPlayerRecord;

    private DataStore() { }

    /**
     * Return the Database for
     * @return database instance
     */
    public static DataStore_IF getDSInstance() {
        if(dsInstance == null) dsInstance = new DataStore();
        return dsInstance;
    }

    private void readData() {

    }

    private void updateData() {

    }

    private void saveData() {

    }

    private boolean recordExist(String username) {
        return true;
    }

    /**
     * Tries to log the user in
     *
     * @param username : a username
     * @return boolean
     */
    @Override
    public boolean login(String username) {
        return false;
    }

    /**
     * Tries to register a user
     *
     * @param username : a username
     * @return boolean
     */
    @Override
    public boolean register(String username) {
        return false;
    }

    /**
     * Queries the currently logged in player
     *
     * @return PlayerRecord
     */
    @Override
    public PlayerRecord queryPlayerRecord() {
        return null;
    }

    /**
     * Queries the  currently logged in player
     *
     * @return RecordList
     */
    @Override
    public RecordList queryAllPlayerRecord() {
        return null;
    }
}
