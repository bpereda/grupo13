package tads.MyStack;

import java.util.EmptyStackException;

public class LinkedStack implements MyStack{
    private Node top;

    public LinkedStack() {

    }

    @Override
    public void push(Object element) {
        Node temp = new Node(element);

        if (top == null){
            top = temp;
        }else if (top != null ) {
            temp.setNext(top);
            top = temp;
        }

    }

    @Override
    public void pop() throws EmptyStackException {
        if (top != null) {
            top = top.getNext();
        }else if (top == null){
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }else if (top != null){
            return false;
        }
        return false;
    }

    @Override
    public void makeEmpty() {
        if (top != null){
            while (top.getNext() != null){
                top = top.getNext();

            }
        }

    }
}
