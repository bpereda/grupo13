package uy.edu.um.prog2.adt.tads.MyArrayList;

public class ArraylistNode<T> {
    T value;

    public ArraylistNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
