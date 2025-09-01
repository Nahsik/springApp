package com.kd.DSA.PriorityQueue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution implements Problem {


    class Pair {
        int num;
        int diff;

        Pair(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
    }

    @Override
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff);
        for (int i : arr) {
            int diff = i - x > 0 ? i - x : x - i;
            if (pq.size() < k) {
                pq.add(new Pair(i, diff));
            } else if (pq.peek().diff > diff) {
                pq.poll();
                pq.add(new Pair(i, diff));
            }
        }
        return pq.stream().map(p -> p.num).sorted().collect(Collectors.toList());
    }

    @Override
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int prv = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (prv < heights[i]) {
                if (pq.size() < ladders) {
                    pq.add(heights[i] - heights[i - 1]);
                } else if (pq.peek() > bricks) {
                    return i;
                } else {
                    pq.add(heights[i] - heights[i - 1]);
                    bricks -= pq.poll();
                }
            }
        }
        return heights.length;
    }

    @Override
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) ->
        {
            if (a[0] == b[0]) {
                return (a[2] > b[2] ? -1 : 1);
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                return -1;
            }
        }
        );
        for (int[] cls : classes) {
            pq.add(new double[]{(double) (cls[0] / cls[1]), (double) cls[0], (double) cls[1]});
        }

        while (extraStudents-- > 0) {
            double[] arry = pq.poll();
            arry[1]++;
            arry[2]++;
            arry[0] = arry[1] / arry[2];
            pq.add(arry);
        }
        double result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll()[0];
        }
        return result / classes.length;
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Triple[] t = new Triple[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Triple(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(t, (a, b) -> a.startTime - b.startTime);
        int[] dp = new int[n];
        dp[0] = t[0].profit;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
        }

        return n;
    }

    class Triple {
        public int startTime;
        public int endTime;
        public int profit;

        public Triple(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
