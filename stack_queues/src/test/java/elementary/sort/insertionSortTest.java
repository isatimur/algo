package elementary.sort;

import junit.framework.TestCase;

/**
 * Created by abyakimenko on 14.11.2016.
 */
public class insertionSortTest extends TestCase {

        private final int[] arrayOfInts = new int[]{11, 21, 3, 41, 8, 11, 14, 14, 18, 20, 22, 26, 29, 35, 43, 48, 57, 65, 1, 2};
//    private final int[] arrayOfInts = new int[]{11, 21, 3, 41, 8, 2};

    public void testExecuteSorting() throws Exception {

        insertionSort.executeSorting(arrayOfInts);

        assertEquals(arrayOfInts[0], 1);
        assertEquals(arrayOfInts[1], 2);
        assertEquals(arrayOfInts[3], 8);
    }

}