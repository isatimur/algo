package stacks;

import junit.framework.TestCase;

/**
 * Created by isati on 12.11.2016.
 */
public class ResizingArrayStackOfAnyTypeTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testResizingArrayStack() {
        ResizingArrayStackOfAnyType<String> stack = new ResizingArrayStackOfAnyType<>();
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        assertEquals(5, stack.size());
        assertEquals("to", stack.pop());
        stack.push("be");
        assertEquals("be", stack.pop());
        assertEquals("not", stack.pop());
        stack.push("that");
        assertEquals("that", stack.pop());
        assertEquals("or", stack.pop());
        assertEquals("be", stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());

    }
}