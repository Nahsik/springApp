package com.kd.DSA.DP;

import java.util.List;

public interface Problem {

    /**
     * <a href="https://leetcode.com/problems/generate-parentheses/">generate-parentheses</a>
     * @param n
     * @return
     */
    List<String> generateParenthesis(int n);


    /**
     *<a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/">longest-increasing-path-in-a-matrix</a>
     * @param matrix
     * @return
     */
     int longestIncreasingPathBackTracking(int[][] matrix) ;
}
