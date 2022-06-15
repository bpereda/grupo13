package uy.edu.um.prog2.adt.tads.MyHeap;

public interface MyHeap<T extends Comparable<T>>{
    void insert(T value);
    T delete();
    int size();

}
