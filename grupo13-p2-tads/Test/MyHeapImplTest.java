import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeap;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapImplTest {

    @Test
    void testInsert() {
        MyHeap<Integer> aHeap = new MyHeapImpl<>();
        aHeap.insert(5);
        aHeap.insert(2);
        aHeap.insert(5);
        aHeap.insert(1);
        assertEquals(1,aHeap.delete());
        assertEquals(2, aHeap.delete());
        assertEquals(5,aHeap.delete());
    }

    @Test
    void testInsert2(){
        Integer[] values = {2,8,2,3,8,10,6,1,2,9,4};
        MyHeap<Integer> aHeap = new MyHeapImpl<>(values);
        assertEquals(1,aHeap.delete());
        assertEquals(2,aHeap.delete());
        assertEquals(2,aHeap.delete());
        assertEquals(2,aHeap.delete());


    }
}