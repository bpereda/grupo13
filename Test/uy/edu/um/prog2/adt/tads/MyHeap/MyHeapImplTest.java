package uy.edu.um.prog2.adt.tads.MyHeap;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapImplTest {

    @org.junit.jupiter.api.Test
    void testInsert() {
        MyHeap<Integer> aHeap = new MyHeapImpl<>();
        aHeap.insert(5);
        aHeap.insert(2);
        aHeap.insert(5);
        aHeap.insert(1);
        assertEquals(1,aHeap.delete());
        assertEquals(2, aHeap.delete());
    }
}