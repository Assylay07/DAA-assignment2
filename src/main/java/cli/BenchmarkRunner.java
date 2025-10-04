package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    private static final int[] SIZES = {10, 50, 100, 500, 1000, 5000, 10000};

    public static void main(String[] args) {
        Random rand = new Random();
        StringBuilder csv = new StringBuilder();
        csv.append("size,algorithm,comparisons,swaps,arrayAccesses,timeNs\n");

        for (int size : SIZES) {
            int[] baseArr = rand.ints(size, 0, 10000).toArray();

            System.out.println("=== Benchmark for array size: " + size + " ===");


            int[] arr1 = baseArr.clone();
            PerformanceTracker tracker1 = new PerformanceTracker();
            long start1 = System.nanoTime();
            SelectionSort.selectionSort(arr1, tracker1);
            tracker1.setTimeNs(System.nanoTime() - start1);
            System.out.println("SelectionSort: " + tracker1);
            csv.append(size).append(",SelectionSort,")
                    .append(tracker1.toCsvLine()).append("\n");


            int[] arr2 = baseArr.clone();
            PerformanceTracker tracker2 = new PerformanceTracker();
            long start2 = System.nanoTime();
            SelectionSort.selectionSortOptimized(arr2, tracker2);
            tracker2.setTimeNs(System.nanoTime() - start2);
            System.out.println("SelectionSortOptimized: " + tracker2);
            csv.append(size).append(",SelectionSortOptimized,")
                    .append(tracker2.toCsvLine()).append("\n");

            System.out.println();
        }


        try (FileWriter writer = new FileWriter("results.csv")) {
            writer.write(csv.toString());
            System.out.println("Results saved to results.csv");
        } catch (IOException e) {
            System.err.println("Failed to save results: " + e.getMessage());
        }
    }
}
