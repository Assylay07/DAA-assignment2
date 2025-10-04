package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void testEmpty() {
        int[] a = new int[0];
        PerformanceTracker p = new PerformanceTracker();
        SelectionSort.selectionSort(a, p);
        assertArrayEquals(new int[0], a);
    }

    @Test
    void testSingle() {
        int[] a = new int[]{5};
        PerformanceTracker p = new PerformanceTracker();
        SelectionSort.selectionSort(a, p);
        assertArrayEquals(new int[]{5}, a);
    }

    @Test
    void testSorted() {
        int[] a = new int[]{1,2,3,4,5};
        int[] expect = Arrays.copyOf(a, a.length);
        SelectionSort.selectionSort(a, new PerformanceTracker());
        assertArrayEquals(expect, a);
    }

    @Test
    void testReverse() {
        int[] a = new int[]{5,4,3,2,1};
        int[] expect = Arrays.copyOf(a, a.length);
        Arrays.sort(expect);
        SelectionSort.selectionSort(a, new PerformanceTracker());
        assertArrayEquals(expect, a);
    }

    @Test
    void testDuplicates() {
        int[] a = new int[]{3,1,2,3,1,2,3};
        int[] expect = Arrays.copyOf(a, a.length);
        Arrays.sort(expect);
        SelectionSort.selectionSort(a, new PerformanceTracker());
        assertArrayEquals(expect, a);
    }

    @Test
    void testRandom() {
        Random rnd = new Random(0);
        int[] a = rnd.ints(1000, 0, 10000).toArray();
        int[] expect = Arrays.copyOf(a, a.length);
        Arrays.sort(expect);
        PerformanceTracker p = new PerformanceTracker();
        SelectionSort.selectionSortOptimized(a, p);
        assertArrayEquals(expect, a);
    }
}
