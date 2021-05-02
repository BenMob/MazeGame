package version1.gameUtil.data.recordRepository;

import version1.gameUtil.data.collections.PlayerRecord;
import version1.gameUtil.data.models.RecordList;

public interface DataStore_IF {
    public boolean login(String username);
    public boolean createNewPlayerRecord(String username);
    public PlayerRecord getPlayerRecord();
    public RecordList getAllPlayerRecord();
}
