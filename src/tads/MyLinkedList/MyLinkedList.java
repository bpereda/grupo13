package tads.MyLinkedList;

import tads.MyList;

public class MyLinkedList implements MyList {

    private Node first, last;
    private int size = 0;

    @Override
    public void add(Object value) {
        Node temp = new Node(value);

        if (first == null) {
            first = temp;
        } else if (first != null) {
            last.setNext(temp);
        }
        last = temp;
        size++;
    }

    @Override
    public Object get(int position) {
        Node temp = first;
        int i = 0;

        while (i < position) {
            temp = temp.getNext();
            i++;
        }
        return temp.getValue();
    }

    @Override
    public void remove(int position) {
        Node temp1 = first;
        Node temp2 = first;
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
