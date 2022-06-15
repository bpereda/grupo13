package uy.edu.um.prog2.adt.tads.MyLinkedList;

public class MyLinkedList<B> implements MyList<B> {

    private Node<B> first, last;
    private int size = 0;

    @Override
    public void add(B value) {
        Node<B> temp = new Node<>(value);

        if (first == null) {
            first = temp;
        } else {
            last.setNext(temp);
        }
        last = temp;
        size++;
    }

    @Override
    public B get(int position) {
        Node<B> temp = first;
        int i = 0;

        while (i < position) {
            temp = temp.getNext();
            i++;
        }
        return temp.getValue();
    }

    @Override
    public void remove(int position) {
        Node<B> temp1 = first;
        Node<B> temp2 = first;
        int i = 0;

        while (i < (position - 1)) {
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            i++;
        }
        temp2 = temp2.getNext();

        if (temp2.getNext() == null) {
            temp1.setNext(null);
            size--;
            last = temp2;
        }else if (temp2.getNext() != null) {
            temp1.setNext(temp2.getNext());
            size--;
        }

    }

    @Override
    public int size() {
        return size;
    }

}
