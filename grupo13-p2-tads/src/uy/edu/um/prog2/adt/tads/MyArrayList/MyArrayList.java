package uy.edu.um.prog2.adt.tads.MyArrayList;

public interface MyArrayList<T> {
    void insert(T value);
    T get(int i);
    void remove(int i);
    void remove(T value);
    int size();
}
