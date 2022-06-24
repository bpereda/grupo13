package uy.edu.um.prog2.adt.tads.MyHash;

public interface MyHash<Key, Value> {

    void put(Key K, Value V);

    Value get(Key k);

    void remove(Key K);

    int size();

    NodeHashTable<Key,Value>[] getElements();
}
