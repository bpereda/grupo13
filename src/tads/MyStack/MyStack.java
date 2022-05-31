package tads.MyStack;

import java.util.EmptyStackException;

public interface MyStack {
    void push (Object element);
    void pop() throws EmptyStackException;
    boolean isEmpty();
    void makeEmpty();
}
