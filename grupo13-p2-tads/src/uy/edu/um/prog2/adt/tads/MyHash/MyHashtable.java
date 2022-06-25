package uy.edu.um.prog2.adt.tads.MyHash;

import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;

public interface MyHashtable<Key, Value> {

    void put(Key K, Value V);

    Value get(Key k);

    void remove(Key K);

    MyArrayList<Value> getValues();

    int size();


}
