package com.isatimur;

import com.isatimur.model.UFModel;
import com.isatimur.quick_find.QuickFind;
import com.isatimur.quick_union.QuickUnion;
import com.isatimur.weighted_quick_union.WeightedQuickUnion;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-) By using TDD the right way is to write a test first
     */
    public void testQuickFind() {
        int N = 10;
        UFModel ufModel = new QuickFind(N);

        assertFalse(ufModel.connected(1, 0));
        ufModel.union(1, 0);
        assertTrue(ufModel.connected(0, 1));
        assertTrue(ufModel.connected(1, 0));
        ufModel.union(4, 3);
        ufModel.union(3, 8);
        ufModel.union(9, 8);

        assertTrue(ufModel.connected(3, 9));

    }

    /**
     * Rigourous Test :-) By using TDD the right way is to write a test first
     */
    public void testQuickUnion() {
        int N = 10;
        UFModel ufModel = new QuickUnion(N);

        assertFalse(ufModel.connected(1, 0));
        ufModel.union(1, 0);
        assertTrue(ufModel.connected(0, 1));
        assertTrue(ufModel.connected(1, 0));
        ufModel.union(4, 3);
        ufModel.union(3, 8);
        ufModel.union(9, 8);

        assertTrue(ufModel.connected(3, 9));

    }

    public void testWeightedQuickUnion() {
        int N = 10;
        UFModel ufModel = new WeightedQuickUnion(N);

        assertFalse(ufModel.connected(1, 0));
        ufModel.union(1, 0);
        assertTrue(ufModel.connected(0, 1));
        assertTrue(ufModel.connected(1, 0));
        ufModel.union(4, 3);
        ufModel.union(3, 8);
        ufModel.union(9, 8);

        assertTrue(ufModel.connected(3, 9));
    }
}
