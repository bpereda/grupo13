package uy.edu.um.prog2.adt.tads.MyQueue;

public interface MyQueue<T> {

    void enqueue(T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();
    boolean contains(T value);

}
