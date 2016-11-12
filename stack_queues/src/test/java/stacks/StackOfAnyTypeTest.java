package stacks;

import junit.framework.TestCase;

/**
 * Created by isati on 12.11.2016.
 */
public class StackOfAnyTypeTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testStack() {
        StackOfAnyType<String> stack = new StackOfAnyType<>();
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        assertEquals("to", stack.pop());
        stack.push("be");
        assertEquals("be", stack.pop());
        assertEquals("not", stack.pop());
        stack.push("that");
        assertEquals("that", stack.pop());
        assertEquals("or", stack.pop());
        assertEquals("be", stack.pop());
        assertFalse(stack.isEmpty());

    }
}