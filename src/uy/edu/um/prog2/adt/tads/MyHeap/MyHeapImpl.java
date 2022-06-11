package uy.edu.um.prog2.adt.tads.MyHeap;

import java.util.Arrays;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T>{

    private static final int CAPACITY = 10;
    private T[] heap;
    private int size;

    public MyHeapImpl() {
        this.heap = (T[]) new Comparable[CAPACITY];
        this.size = 0;
    }

    public MyHeapImpl(T[] array) {
        heap = (T[]) new Comparable[CAPACITY];
        size = 0;

        for (T each : array) {
            insert(each);
        }
    }

    public T[] getHeap() {
        return Arrays.copyOfRange(heap, 1, size + 1);
    }

    @Override
    public void insert(T value) {
        if (this.size >= heap.length - 1) {
            heap = this.resize();
        }

        size++;
        heap[size] = value;
        bubbleUp();
    }

    @Override
    public T delete() {
        T result = peek();

        swap(1, size);
        heap[size] = null;
        size--;

        bubbleDown();

        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException();
        return heap[1];
    }

    @Override
    public int size() {
        return size;
    }

    private T[] resize() {
        return Arrays.copyOf(heap, heap.length + CAPACITY);
    }

    private void bubbleUp() {
        int index = size;

        while (hasParent(index) && (getParent(index).compareTo(heap[index]) > 0)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }

    }

    private void bubbleDown() {
        int index = 1;

        while (hasLeftChild(index)) {
            int smaller = getLeftIndex(index);
            if (hasRightChild(index) && heap[getLeftIndex(index)].compareTo(heap[getRightIndex(index)]) > 0) {
                smaller = getRightIndex(index);
            }
            if (heap[index].compareTo(heap[smaller]) > 0) {
                swap(index, smaller);
            }
            else break;

            index = smaller;
        }

    }

    private boolean hasParent(int i) {
        return i > 1;
    }

    private int getLeftIndex(int i) {
        return i * 2;
    }

    private int getRightIndex(int i) {
        return i * 2 + 1;
    }

    private boolean hasLeftChild(int i) {
        return getLeftIndex(i) <= size;
    }

    private boolean hasRightChild(int i) {
        return getRightIndex(i) <= size;
    }

    private int getParentIndex(int i) {
        return i / 2;
    }

    private T getParent(int i) {
        return heap[getParentIndex(i)];
    }

    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

}
