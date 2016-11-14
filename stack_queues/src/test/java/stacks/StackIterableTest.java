package stacks;

import com.learning.princeton.algo.stacks.StackIterable;
import junit.framework.TestCase;

/**
 * Created by isati on 14.11.2016.
 */
public class StackIterableTest extends TestCase {

    public void testStack() {
        StackIterable<String> stack = new StackIterable<>();
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

        for (String s : stack) {
            assertEquals("to", s);
        }
    }
}