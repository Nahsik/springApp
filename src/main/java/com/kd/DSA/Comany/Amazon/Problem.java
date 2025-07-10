package com.kd.DSA.Comany.Amazon;

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

    List<List<String>> suggestedProducts(String[] products, String searchWord);

}
