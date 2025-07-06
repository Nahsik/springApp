package com.kd.DSA.Tree;


import java.util.*;

public class Solution implements Problem {

    public int sumNumbers(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int sum = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode t = p.treeNode;
            if (null == t.left && null == t.right) {
                sum += p.value * 10 + t.val;
            } else {
                if (null != t.left) {
                    queue.offer(new Pair(t.left, p.value * 10 + t.val));
                }
                if (null != t.right) {
                    queue.offer(new Pair(t.right, p.value * 10 + t.val));
                }
            }
        }
        return sum;
    }

    private class Pair {
        TreeNode treeNode;
        int value;

        Pair(TreeNode treeNode, int value) {
            this.treeNode = treeNode;
            this.value = value;
        }
    }

    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    //#################################
    //################################

    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        return result;
    }

    private void preorderTraversal(List<Integer> list, TreeNode root) {
        if (null == root) {
            return;
        }
        preorderTraversal(list, root.left);
        list.add(root.val);
        preorderTraversal(list, root.right);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        result.add(root.val);
        if (null != root.right) {
            stack.push(root.right);
        }
        if (null != root.left) {
            stack.push(root.left);
        }
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            result.add(t.val);
            if (null != t.right) {
                stack.push(t.right);
            }
            if (null != t.left) {
                stack.push(t.left);
            }
        }
        return result;
    }


}

