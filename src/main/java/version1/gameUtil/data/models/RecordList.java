package version1.gameUtil.data.models;

import version1.gameUtil.data.collections.AbstractRecord;
import version1.gameUtil.data.collections.PlayerRecord;

import java.util.ArrayList;

public class RecordList extends AbstractRecordList {

    ArrayList<PlayerRecord> playerRecordList;

    public RecordIterator_IF createIterator()
    {
        return null;
    }
    public int getLength()
    {
        return playerRecordList.size();
    }
    public AbstractRecord getItem(int index)
    {
        return null;
    }

}
