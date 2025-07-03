package com.kd.DSA.BackTracking;

import java.util.List;

public interface Problem {

    /**
     * <a href="https://leetcode.com/problems/subsets/">subsets</a>
     *
     * @param nums
     * @return
     */
    List<List<Integer>> subsets(int[] nums);

    /**
     * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">letter-combinations-of-a-phone-number</a>
     *
     * @param digits
     * @return
     */
    List<String> letterCombinations(String digits);

    /**
     * <a href="https://leetcode.com/problems/palindrome-partitioning/">palindrome-partitioning</a>
     * @param s
     * @return
     */
    List<List<String>> partition(String s);

    /**
     * <a href="https://leetcode.com/problems/n-queens/">n-queens</a>
     *
     * @param n
     * @return
     */
    List<List<String>> solveNQueens(int n);
}
