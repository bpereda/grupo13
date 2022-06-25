package uy.edu.um.prog2.adt.tads.MyArrayList;

import java.util.Arrays;

public class MyArrayListImpl<T> implements MyArrayList<T> {
    final private static int INICIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INICIAL_CAPACITY];
    private int size = 0;

    @Override
    public void insert(T value) {
        ensureCapacity();
        array[size++] = value;

    }

    private void ensureCapacity(){
        if(size < array.length){ return;}
        resize();
    }

    private void resize(){
        T[] temp = Arrays.copyOf(array,size*2);
        array = temp;
    }

    @Override
    public T get(int i) {
        if (i > size || i < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[i];
    }

    @Override
    public void remove(int i) {
        if (i>size || i < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        --size;
        System.arraycopy(array,i + 1,array,i,size-i);
        array[size]=null;

    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(value)){
                remove(i);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

}
