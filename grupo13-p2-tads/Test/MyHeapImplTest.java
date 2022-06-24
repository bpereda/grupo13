import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeap;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapImplTest {

    @Test
    void testInsert() {
        MyHeap<Integer,Integer> aHeap = new MyHeapImpl<>(false);
        aHeap.insert(5,5);
        aHeap.insert(2,2);
        aHeap.insert(5,5);
        aHeap.insert(1,1);
        assertEquals(1,aHeap.delete().getKey());
        assertEquals(2, aHeap.delete().getKey());
        assertEquals(5,aHeap.delete().getKey());
    }

}