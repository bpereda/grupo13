package tads.MyLinkedList;

public class Node<B> {

    private B value;
    private Node<B> next;

    public Node<B> (B value){
        this.value = value;
        this.next = null;
    }

    public B getValue() {
        return value;
    }

    public void setValue(B value) {
        this.value = value;
    }

    public Node<B> getNext() {
        return next;
    }

    public void setNext(Node<B> next) {
        this.next = next;
    }

}
