package uy.edu.um.prog2.adt.tads.MyHeap;

public interface MyHeap<K extends Comparable<K>,T>{
    void insert(K key,T value);
    HeapNode<K,T> delete();
    int size();

}
