package metrics;

public class PerformanceTracker {

    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long timeNs = 0;

    public void incComparisons() { comparisons++; }
    public void addComparisons(long n) { comparisons += n; }

    public void incSwaps() { swaps++; }
    public void addSwaps(long n) { swaps += n; }

    public void addAccesses(long n) { arrayAccesses += n; }

    public void setTimeNs(long ns) { timeNs = ns; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getTimeNs() { return timeNs; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        timeNs = 0;
    }

    public static String csvHeader() {
        return "comparisons,swaps,arrayAccesses,timeNs";
    }
    public String toCsvLine() {
        return comparisons + "," + swaps + "," + arrayAccesses + "," + timeNs;
    }

    @Override
    public String toString() {
        return String.format("comparisons=%d, swaps=%d, arrayAccesses=%d, timeNs=%d",
                comparisons, swaps, arrayAccesses, timeNs);
    }
}
