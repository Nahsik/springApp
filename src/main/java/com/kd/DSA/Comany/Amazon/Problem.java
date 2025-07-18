package com.kd.DSA.Comany.Amazon;

import com.kd.DSA.Interval;
import com.kd.DSA.Tree.TreeNode;

import java.util.List;

public interface Problem {

    /**
     * <a href="https://www.naukri.com/code360/problems/boundary-traversal-of-binary-tree_790725">boundary-traversal-of-binary-tree</a>
     *
     * @param root
     * @return
     */
    List<Integer> traverseBoundary(TreeNode root);


    /**
     * <a href="https://leetcode.com/problems/reorganize-string">reorganize-string</a>
     *
     * @param s
     * @return
     */
    String reorganizeString(String s);


    /**
     * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">all-nodes-distance-k-in-binary-tree</a>
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    List<Integer> distanceK(TreeNode root, TreeNode target, int k);

    // todo : Need to solve question.

    /**
     * <a href="https://leetcode.com/problems/reorder-data-in-log-files">reorder-data-in-log-files</a>
     *
     * @param logs
     * @return
     */
    String[] reorderLogFiles(String[] logs);

    /**
     * <a href="https://leetcode.com/problems/search-suggestions-system/">search-suggestions-system</a>
     * @param products
     * @param searchWord
     * @return
     */
    List<List<String>> suggestedProducts(String[] products, String searchWord);

    /**
     * <a href="https://leetcode.com/problems/sequential-digits/">sequential-digits</a>
     * @param low
     * @param high
     * @return
     */
    List<Integer> sequentialDigits(int low, int high);


    /**
     *<a href="https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product">maximum-length-of-subarray-with-positive-product</a>
     * @param nums
     * @return
     */
    int getMaxLen(int[] nums);

    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/">minimum-number-of-swaps-to-make-the-binary-string-alternating</a>
     * @param s
     * @return
     */
    int minSwaps(String s);

    /**
     * <a href="https://leetcode.com/problems/plates-between-candles">plates-between-candles</a>
     * @param
     * @param queries
     * @return
     */
    int[] platesBetweenCandles(String s, int[][] queries) ;


    /**
     *<a href="https://leetcode.com/problems/find-good-days-to-rob-the-bank/">find-good-days-to-rob-the-bank</a>
     * @param security
     * @param time
     * @return
     */
    List<Integer> goodDaysToRobBank(int[] security, int time);


    /**
     * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">sum-of-subarray-minimums</a>
     * @param arr
     * @return
     */
    int sumSubarrayMins(int[] arr);

    /**
     * <a href="https://leetcode.com/problems/sum-of-subarray-ranges/">sum-of-subarray-ranges</a>
     * @param nums
     * @return
     */
    long subArrayRanges(int[] nums);

    /**
     *  <a href="https://leetcode.com/problems/find-triangular-sum-of-an-array/">find-triangular-sum-of-an-array</a>
     * @param nums
     * @return
     */
    int triangularSum(int[] nums);


    /**
     * <a href="https://leetcode.com/problems/number-of-ways-to-select-buildings">number-of-ways-to-select-buildings</a>
     * @param s
     * @return
     */
    long numberOfWays(String s);

    /**
     *  <a href="https://leetcode.ca/2022-06-09-2268-Minimum-Number-of-Keypresses/">Minimum-Number-of-Keypresses</a>
     * @param s
     * @return
     */
    int minimumKeypresses(String s);

    /**
     * <a href="https://leetcode.ca/2019-01-25-1152-Analyze-User-Website-Visit-Pattern/">...</a>
     * @param username
     * @param timestamp
     * @param website
     * @return
     */
     List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website);

    /**
     * <a href="https://leetcode.com/problems/word-break/description/">word-break</a>
     * @param s
     * @param wordDict
     * @return
     */
    boolean wordBreak(String s, List<String> wordDict);

    /**
     * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">binary-tree-right-side-view</a>
     * @param root
     * @return
     */
    List<Integer> rightSideView(TreeNode root);

    /**
     * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">binary-tree-zigzag-level-order-traversal</a>
     * @param root
     * @return
     */
    List<List<Integer>> zigzagLevelOrder(TreeNode root);

    /**
     * <a href="https://leetcode.com/problems/top-k-frequent-elements/">top-k-frequent-elements</a>
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k);


    public int minMeetingRooms(List<Interval> intervals);

    /**
     * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">longest-substring-without-repeating-characters</a>
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s);

    /**
     * <a href="https://leetcode.ca/all/269.html">Alien Dictionary</a>
     * @param words
     * @return
     */
    public String findOrder(String[] words);


    /**
     * <a href="https://leetcode.com/problems/sliding-window-maximum/">sliding-window-maximum/</a>
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k);


    public int search(int[] nums, int target);


    /**
     * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">kth-largest-element-in-an-array</a>
     * @param nums
     * @param k
     * @return
     */
    int findKthLargest(int[] nums, int k);


    /**
     * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">subarray-sum-equals-k</a>
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k);

    /**
     *<a href="https://leetcode.com/problems/validate-binary-search-tree/description/">validate-binary-search-tree</a>
     * @param root
     * @return
     */
    boolean isValidBST(TreeNode root) ;

    /**
     * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">lowest-common-ancestor-of-a-binary-tree</a>
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
