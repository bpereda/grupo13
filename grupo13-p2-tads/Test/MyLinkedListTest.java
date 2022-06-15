import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.tads.MyLinkedList.MyList;
import uy.edu.um.prog2.adt.tads.MyLinkedList.MyLinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    @Test
    void testInsert(){
        Integer[] list1 = {0,1,2,3,4,5};
        MyList<Integer> list2 = new MyLinkedList<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        assertEquals(list1[0],list2.get(0));
        assertEquals(list1[1],list2.get(1));
        assertEquals(list1[2],list2.get(2));
        assertEquals(list1[3],list2.get(3));
        assertEquals(list1[4],list2.get(4));
        assertEquals(list1[5],list2.get(5));

    }

    @Test
    void testDelete(){
        Integer[] list1 = {0,1,2,3,5};
        MyList<Integer> list2 = new MyLinkedList<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.remove(4);
        assertEquals(list1[0],list2.get(0));
        assertEquals(list1[1],list2.get(1));
        assertEquals(list1[2],list2.get(2));
        assertEquals(list1[3],list2.get(3));
        assertEquals(list1[4],list2.get(4));




    }
}
