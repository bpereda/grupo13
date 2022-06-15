

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import uy.edu.um.prog2.adt.tads.MyQueue.MyQueue;
import uy.edu.um.prog2.adt.tads.MyQueue.MyQueueImpl;
import uy.edu.um.prog2.adt.tads.MyQueue.EmptyQueueException;


class MyQueueImplTest<Interger> {

    @Test
    void enqueue() {
        MyQueueImpl cola1 = new MyQueueImpl();
        cola1.enqueue(0);
        cola1.enqueue(1);
        cola1.enqueue(2);
        assertEquals(3, cola1.size);
    }

    @Test
    void dequeue() throws EmptyQueueException {

        MyQueueImpl<Integer> cola2 = new MyQueueImpl<Integer>();
        EmptyQueueException exception = assertThrows(EmptyQueueException.class, () -> {cola2.dequeue();});
        cola2.enqueue(0);
        cola2.enqueue(1);
        assertEquals(0, cola2.dequeue());

    }

    @Test
    void isEmpty() {
        MyQueueImpl cola3 = new MyQueueImpl();
        assertEquals(true, cola3.isEmpty());
    }

    @Test
    void contains() {
        MyQueueImpl cola3 = new MyQueueImpl();
        cola3.enqueue(0);
        cola3.enqueue(1);
        cola3.enqueue(2);
        assertEquals(true, cola3.contains(1));
    }

}