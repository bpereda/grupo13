package tads.MyStack;

public class Node {
    private Object value;
    private Node next;

    public Node(Object value){
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public Object getValue(){
        return value;
    }

    void setNext(Node next){
        this.next = next;
    }

    void setValue(Object value){
        this.value = value;
    }


}
