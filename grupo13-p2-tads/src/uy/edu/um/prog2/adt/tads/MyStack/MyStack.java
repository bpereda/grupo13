package uy.edu.um.prog2.adt.tads.MyStack;

import java.util.EmptyStackException;

public interface MyStack<B> {
    void push (B element);
    void pop() throws EmptyStackException;
    boolean isEmpty();
    void makeEmpty();
}
