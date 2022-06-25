package uy.edu.um.prog2.adt.tads.MyHeap;

import java.util.Arrays;

public class MyHeapImpl<K extends Comparable<K>,T> implements MyHeap<K,T> {

    private static final int CAPACITY = 10;
    private HeapNode<K, T>[] heap;
    private int size = 0;
    private boolean isHeapMax;

    public MyHeapImpl(boolean isHeapMax) {
        this.isHeapMax = isHeapMax;
        heap = new HeapNode[CAPACITY];

    }

    @Override
    public void insert(K key, T value) {
        if (size >= heap.length - 1 ) {
            heap = resize();
        }
        size++;
        HeapNode<K,T> temp = new HeapNode<>(key,value);
        heap[size] = temp;
        bubbleUp();

    }

    private void bubbleUp(){
        int index = size;
        if(isHeapMax){
            while(hasParent(index) && (getParent(index).getKey().compareTo(heap[index].getKey())) < 0){
                swap(index,getParentIndex(index));
                index = getParentIndex(index);
            }
        }else {
            while(hasParent(index) && (getParent(index).getKey().compareTo(heap[index].getKey())) > 0){
                swap(index,getParentIndex(index));
                index = getParentIndex(index);
            }
        }
    }

    private void bubbleDown(){
        int index = 1;
        if (isHeapMax){
            while(hasLeftChild(index)){
                int larger = getLeftIndex(index);
                if (hasRightChild(index) && (heap[getLeftIndex(index)].getKey().compareTo(heap[getRightIndex(index)].getKey())) < 0){
                    larger = getRightIndex(index);
                }
                if (heap[index].getKey().compareTo(heap[larger].getKey()) < 0){
                    swap(index,larger);
                }else break;
                index = larger;
            }
        }else {
            while(hasLeftChild(index)){
                int smaller = getLeftIndex(index);
                if (hasRightChild(index) && (heap[getLeftIndex(index)].getKey().compareTo(heap[getRightIndex(index)].getKey())) > 0){
                    smaller = getRightIndex(index);
                }
                if (heap[index].getKey().compareTo(heap[smaller].getKey()) > 0){
                    swap(index,smaller);
                }else break;
                index = smaller;
            }
        }
    }

    private HeapNode<K, T>[] resize(){
        return Arrays.copyOf(heap,size+CAPACITY);
    }


    @Override
    public HeapNode<K, T> delete() {
        HeapNode<K,T> result = peek();

        swap(1,size);
        heap[size] = null;
        size--;
        bubbleDown();
        return result;
    }

    private HeapNode<K,T> peek(){
        if (isEmpty()) throw new IllegalStateException();
        return heap[1];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size() {
        return 0;
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

    private HeapNode<K, T> getParent(int i) {
        return heap[getParentIndex(i)];
    }

    private void swap(int index1, int index2) {
        HeapNode<K,T> temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    @Override
    public HeapNode<K, T> getRoot() {
        return heap[1];
    }
}