package algorithms;

import metrics.PerformanceTracker;
import java.util.Objects;

public final class SelectionSort {

    private SelectionSort() {}


    public static void selectionSort(int[] arr, PerformanceTracker metrics) {
        Objects.requireNonNull(arr, "arr is null");
        if (metrics == null) metrics = new PerformanceTracker();

        long start = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            metrics.addAccesses(1);

            for (int j = i + 1; j < n; j++) {
                metrics.incComparisons();
                metrics.addAccesses(2);
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swap(arr, i, minIdx, metrics);
            }
        }

        long end = System.nanoTime();
        metrics.setTimeNs(end - start);
    }


    public static void selectionSortOptimized(int[] arr, PerformanceTracker metrics) {
        Objects.requireNonNull(arr, "arr is null");
        if (metrics == null) metrics = new PerformanceTracker();

        long start = System.nanoTime();

        int n = arr.length;
        if (n <= 1) return;


        boolean alreadySorted = true;
        for (int i = 1; i < n; i++) {
            metrics.incComparisons();
            metrics.addAccesses(2); // arr[i-1], arr[i]
            if (arr[i - 1] > arr[i]) {
                alreadySorted = false;
                break;
            }
        }
        if (alreadySorted) {
            metrics.setTimeNs(System.nanoTime() - start);
            return;
        }

        int left = 0, right = n - 1;
        while (left < right) {
            int minIdx = left;
            int maxIdx = left;
            metrics.addAccesses(1);

            for (int j = left + 1; j <= right; j++) {
                metrics.incComparisons();
                metrics.addAccesses(2);
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }

                metrics.incComparisons();
                metrics.addAccesses(2);
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (minIdx != left) {
                swap(arr, left, minIdx, metrics);
                if (maxIdx == left) {
                    maxIdx = minIdx;
                }
            }

            if (maxIdx != right) {
                swap(arr, maxIdx, right, metrics);
            }

            left++;
            right--;
        }

        long end = System.nanoTime();
        metrics.setTimeNs(end - start);
    }


    private static void swap(int[] arr, int i, int j, PerformanceTracker metrics) {
        int tmp = arr[i]; metrics.addAccesses(1);
        int tmp2 = arr[j]; metrics.addAccesses(1);
        arr[i] = tmp2; metrics.addAccesses(1);
        arr[j] = tmp; metrics.addAccesses(1);
        metrics.incSwaps();
    }
}
