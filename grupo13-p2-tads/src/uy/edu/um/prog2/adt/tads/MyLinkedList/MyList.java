package uy.edu.um.prog2.adt.tads.MyLinkedList;

public interface MyList<B> {

    void add(B value);
    B get(int position);
    void remove(int position);
    int size();

}
