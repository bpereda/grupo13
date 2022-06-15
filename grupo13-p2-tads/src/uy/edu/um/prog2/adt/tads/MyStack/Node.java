package uy.edu.um.prog2.adt.tads.MyStack;

public class Node<B> {
    private B value;
    private Node<B> next;

    public Node(B value){
        this.value = value;
    }

    public Node<B> getNext(){
        return next;
    }

    public B getValue(){
        return value;
    }

    void setNext(Node<B> next){
        this.next = next;
    }

    void setValue(B value){
        this.value = value;
    }


}
