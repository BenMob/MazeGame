package version1.gameUtil.data.models;

import version1.gameUtil.data.collections.AbstractRecord;

public class RecordIterator implements RecordIterator_IF{
    private RecordList list;
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public AbstractRecord next() {
        return null;
    }
}
