package com.kd.DSA.Tree;

import java.util.*;

class RoadRepairTracker {
    private TreeMap<Integer, Integer> repairedIntervals; // start -> end mapping
    private int maxLength;

    public RoadRepairTracker() {
        this.repairedIntervals = new TreeMap<>();
        this.maxLength = 0;
    }

    /**
     * Add a repaired patch from start to end (inclusive)
     * Time Complexity: O(log n) where n is number of intervals
     */
    public void addRepair(int start, int end) {
        if (start > end) return;

        // Find intervals that might merge with [start, end]
        Integer prevStart = repairedIntervals.floorKey(start);
        Integer nextStart = repairedIntervals.ceilingKey(start);

        int newStart = start;
        int newEnd = end;

        // Check if we can merge with previous interval
        if (prevStart != null && repairedIntervals.get(prevStart) >= start - 1) {
            newStart = prevStart;
            newEnd = Math.max(newEnd, repairedIntervals.get(prevStart));
            repairedIntervals.remove(prevStart);
        }

        // Check and merge with all overlapping intervals to the right
        while (nextStart != null && nextStart <= newEnd + 1) {
            newEnd = Math.max(newEnd, repairedIntervals.get(nextStart));
            repairedIntervals.remove(nextStart);
            nextStart = repairedIntervals.ceilingKey(nextStart);
        }

        // Add the merged interval
        repairedIntervals.put(newStart, newEnd);

        // Update max length
        maxLength = Math.max(maxLength, newEnd - newStart + 1);

        System.out.println("Added repair [" + start + ", " + end + "]");
        System.out.println("Current intervals: " + repairedIntervals);
        System.out.println("Longest continuous patch: " + maxLength + " km");
        System.out.println("---");
    }

    public int getLongestPatch() {
        return maxLength;
    }

    public Map<Integer, Integer> getIntervals() {
        return new HashMap<>(repairedIntervals);
    }

    // Demo method to show the solution in action
    public static void demo() {
        RoadRepairTracker tracker = new RoadRepairTracker();

        System.out.println("=== Road Repair Tracker Demo ===");
        System.out.println("12 km road (0-12), tracking repaired patches\n");

        // Simulate repair updates
        tracker.addRepair(2, 4);    // [2,4] - length 3
        tracker.addRepair(7, 9);    // [2,4], [7,9] - max length 3
        tracker.addRepair(1, 3);    // [1,4], [7,9] - max length 4 (merged)
        tracker.addRepair(5, 6);    // [1,4], [5,6], [7,9] - max length 4
        tracker.addRepair(4, 5);    // [1,6], [7,9] - max length 6 (bridge merge)
        tracker.addRepair(6, 8);    // [1,9] - length 9 (complete merge)
        tracker.addRepair(10, 11);  // [1,9], [10,11] - max length 9
        tracker.addRepair(9, 10);   // [1,11] - length 11 (final merge)

        System.out.println("Final longest continuous repaired patch: " +
                tracker.getLongestPatch() + " km");
    }
}

// Alternative approach using Union-Find for comparison
class RoadRepairUF {
    private int[] parent;
    private int[] size;
    private boolean[] repaired;
    private int maxLength;

    public RoadRepairUF(int roadLength) {
        this.parent = new int[roadLength + 1];
        this.size = new int[roadLength + 1];
        this.repaired = new boolean[roadLength + 1];
        this.maxLength = 0;

        for (int i = 0; i <= roadLength; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                maxLength = Math.max(maxLength, size[rootY]);
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxLength = Math.max(maxLength, size[rootX]);
            }
        }
    }

    /**
     * Union-Find approach - O(α(n)) per operation
     * But requires O(n) space for road length
     */
    public void addRepair(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!repaired[i]) {
                repaired[i] = true;
                maxLength = Math.max(maxLength, 1);

                // Union with adjacent repaired segments
                if (i > 0 && repaired[i - 1]) {
                    union(i, i - 1);
                }
                if (i < repaired.length - 1 && repaired[i + 1]) {
                    union(i, i + 1);
                }
            }
        }
    }

    public int getLongestPatch() {
        return maxLength;
    }
}

// Complexity Analysis and Comparison
class ComplexityAnalysis {
    public static void printAnalysis() {
        System.out.println("\n=== TIME COMPLEXITY ANALYSIS ===");
        System.out.println("TreeMap Approach:");
        System.out.println("- Add repair: O(log k) where k = number of intervals");
        System.out.println("- Space: O(k) - only store interval boundaries");
        System.out.println("- Best for: Sparse repairs, large road lengths");

        System.out.println("\nUnion-Find Approach:");
        System.out.println("- Add repair: O(α(n) * length) where α is inverse Ackermann");
        System.out.println("- Space: O(n) - array for entire road");
        System.out.println("- Best for: Dense repairs, smaller road lengths");

        System.out.println("\nFor 12km road with sparse updates:");
        System.out.println("TreeMap is more efficient in both time and space!");
    }
}

public class RoadRepairTrackerMain {
    public static void main(String[] args) {
        RoadRepairTracker.demo();
        ComplexityAnalysis.printAnalysis();
    }
}
