import org.junit.jupiter.api.Test;

import uy.edu.um.prog2.adt.tads.MyStack.LinkedStack;
import uy.edu.um.prog2.adt.tads.MyStack.MyStack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyStackTest {

    @Test
    void push() {
        LinkedStack<Integer> stack1 = new LinkedStack();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        assertEquals(3,stack1.size);
    }

    @Test
    void pop() {
        LinkedStack<Integer> stack2 = new LinkedStack();
        stack2.push(0);
        stack2.push(1);
        stack2.push(2);
        stack2.pop();
        stack2.pop();
        assertEquals(1,stack2.size);
    }

    @Test
    void isEmpty() {
        LinkedStack<Integer> stack3 = new LinkedStack();
        stack3.push(0);
        assertEquals(false, stack3.isEmpty());
    }

}