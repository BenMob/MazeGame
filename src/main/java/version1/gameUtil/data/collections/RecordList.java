package version1.gameUtil.data.collections;

import version1.gameUtil.data.models.AbstractRecord;

import java.util.ArrayList;

public class RecordList extends AbstractRecordList {

    ArrayList<AbstractRecord> playerRecordList;

    public RecordList()
    {
        this.playerRecordList = new ArrayList<>();
    }

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

    public void addItem(AbstractRecord record)
    {

    }
}
