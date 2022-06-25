import org.junit.Test;
import uy.edu.um.prog2.adt.tads.MyHash.MyHash;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyHashImplTest {

    @Test
    public void put()
    {
        MyHashImpl<Integer, Integer> hash1 = new MyHashImpl();
        hash1.put(2222,0);
        hash1.put(3333,1);
        hash1.put(4444,2);
        assertEquals(3,hash1.getLoad());
    }

    @Test
    public void remove()
    {
        MyHashImpl<Integer, Integer> hash2 = new MyHashImpl();
        hash2.put(2222,0);
        hash2.put(3333,1);
        hash2.put(4444,2);
        hash2.put(3334,6);
        hash2.remove(2222);
        assertEquals(3, hash2.getLoad());
    }

    @Test
    public void get()
    {
        MyHashImpl<Integer, Integer> hash1 = new MyHashImpl();
        hash1.put(2222,0);
        hash1.put(3333,1);
        hash1.put(4444,2);
        hash1.put(3334,6);
        hash1.put(5554,11);
        assertEquals(1, hash1.get(3333));
        assertEquals(2, hash1.get(4444));
    }

}
