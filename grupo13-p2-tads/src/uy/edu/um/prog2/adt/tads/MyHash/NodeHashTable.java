package uy.edu.um.prog2.adt.tads.MyHash;

public class NodeHashTable<Key, Value> {

    private Key key;
    private Value value;
    private boolean deleted;

    public NodeHashTable(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}

