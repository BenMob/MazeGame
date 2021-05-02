package version1.gameUtil.data.recordRepository;

import version1.gameUtil.data.collections.PlayerRecord;
import version1.gameUtil.data.models.RecordList;

import java.util.Map;

//** How to implement JSON simple file and recordAsHashMap obj
public class DataStore implements DataStore_IF{

    private RecordList recordsAsList; //RecordList object

    DataStore dbInstance; //singleton

    private Map<String,PlayerRecord> recordsAsHashMap;

    private PlayerRecord currentPlayerRecord;


    public DataStore() {

    }

    private void readData()
    {

    }

    private void updateData()
    {

    }

    private void saveData()
    {

    }
    public DataStore_IF getDBInstance() //class needs to return statement to be fixed
    {
        return null;
    }

    private boolean recordExist(String username)
    {
        if (username != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String username) {
        if (username != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean createNewPlayerRecord(String username) {
        if (username == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public PlayerRecord getPlayerRecord() {
        return null;
    }

    @Override
    public RecordList getAllPlayerRecord() {
        return null;
    }

}
