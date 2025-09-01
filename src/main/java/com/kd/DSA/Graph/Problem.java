package com.kd.DSA.Graph;

import java.util.List;

public interface Problem {
    /**
     *  <a href="https://leetcode.com/problems/course-schedule/">course-schedule</a>
     * @param numCourses
     * @param prerequisites
     * @return
     */
    boolean canFinish(int numCourses, int[][] prerequisites);

    /**
     * <a href="https://leetcode.com/problems/evaluate-division/">evaluate-division</a>
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries);


    /**
     * <a href="https://leetcode.com/problems/maximum-subsequence-score/">maximum-subsequence-score</a>
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    long maxScore(int[] nums1, int[] nums2, int k) ;

    boolean canMakeEqual(String s, List<List<Character>> rules);
}
