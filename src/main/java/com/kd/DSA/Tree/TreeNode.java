package com.kd.DSA.Tree;


public class TreeNode {
    public int val;
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.data = val;
        this.left = left;
        this.right = right;
    }
}
