package com.kd.DSA.Tree;

import java.util.List;

public interface Problem {

    /**
     * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">Sum Root To Leaf Number</a>
     * @param root
     * @return
     */
    int sumNumbers(TreeNode root);

    /**
     * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">binary-tree-preorder-traversal</a>
     * @param root
     * @return
     */
    List<Integer> preorderTraversal(TreeNode root);


}
