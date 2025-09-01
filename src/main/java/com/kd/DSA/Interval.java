package com.kd.DSA;

import java.util.Arrays;

public class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Triple[] t = new Triple[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Triple(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(t, (a, b) -> a.startTime - b.endTime);
        int[] dp = new int[n];
        dp[0] = profit[0];
        for (int i = 1; i < n; i++) {
            int prevIndex = getIndex(t, t[i].startTime, i - 1);
            dp[i] = Math.max(dp[i - 1], t[i].profit + (prevIndex >= 0 ? dp[prevIndex] : 0));
        }
        return dp[n - 1];
    }

    private int getIndex(Triple[] t, int endTime, int index) {
        while (index >= 0) {
            if (t[index].endTime <= endTime) {
                return index;
            }
            index--;
        }
        return -1;
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
