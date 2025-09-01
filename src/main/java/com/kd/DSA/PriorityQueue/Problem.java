package com.kd.DSA.PriorityQueue;

import java.util.List;

public interface Problem {
    List<Integer> findClosestElements(int[] arr, int k, int x);

    /**
     * <a href="https://leetcode.com/problems/furthest-building-you-can-reach/description/">furthest-building-you-can-reach</a>
     */
    int furthestBuilding(int[] heights, int bricks, int ladders);

    double maxAverageRatio(int[][] classes, int extraStudents);
}
