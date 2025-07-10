package com.kd.DSA.Comany.Amazon;

import com.kd.DSA.Tree.TreeNode;
import com.kd.DSA.Trie;

import java.util.*;

public class Solution implements Problem {
    @Override
    public List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseBoundary(result, root);
        return result;
    }

    private void traverseBoundary(List<Integer> result, TreeNode root) {
        if (null == root) {
            return;
        }
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        travelLeft(result, root.left);
        addLeaf(result, root);
        travelRight(result, root.right);
    }

    private void travelLeft(List<Integer> result, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        while (null != treeNode) {
            if (!isLeaf(treeNode)) {
                result.add(treeNode.data);
            }
            treeNode = null != treeNode.left ? treeNode.left : treeNode.right;
        }
    }

    private void addLeaf(List<Integer> result, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        if (isLeaf(treeNode)) {
            result.add(treeNode.data);
            return;
        }
        addLeaf(result, treeNode.left);
        addLeaf(result, treeNode.right);
    }

    private void travelRight(List<Integer> result, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        while (null != treeNode) {
            if (!isLeaf(treeNode)) {
                list.add(treeNode.data);
            }
            treeNode = null != treeNode.right ? treeNode.right : treeNode.left;
        }
        Collections.reverse(list);
        result.addAll(list);
    }

    private boolean isLeaf(TreeNode treeNode) {
        return null == treeNode.left && null == treeNode.right;
    }

    public List<Integer> traverseBoundaryTest(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> bottom = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty() && queue.peek() != null) {
            TreeNode first = queue.peek();
            TreeNode last = queue.peek();
            result.add(first.data);
            while (queue.peek() != null) {
                last = queue.peek();
                TreeNode treeNode1 = queue.poll();
                if (null == treeNode1.left && null == treeNode1.right
                        && treeNode1 != first) {
                    bottom.add(treeNode1.data);
                }
                if (null != treeNode1.left) {
                    queue.add(treeNode1.left);
                }
                if (null != treeNode1.right) {
                    queue.add(treeNode1.right);
                }
            }
            if (!queue.isEmpty() && queue.peek() == null) {
                queue.poll();
                queue.add(null);
            }
            if (last != first && !(last.right == null && last.left == null)) {
                right.add(last.data);
            }

        }
        result.addAll(bottom);
        for (int i = right.size() - 1; i >= 0; i--) {
            result.add(right.get(i));
        }
        return result;
    }


    @Override
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        int[] hash = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            max = Math.max(hash[s.charAt(i) - 'a'], max);
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0) {
                pq.add(new Pair(hash[i], (char) ('a' + i)));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 1) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            sb.append(p1.ch);
            sb.append(p2.ch);

            if (--p1.val > 0) {
                pq.add(p1);
            }
            if (--p2.val > 0) {
                pq.add(p2);
            }
        }
        if (!pq.isEmpty()) {
            sb.append(pq.poll().ch);
        }
        return sb.toString();
    }

    class Pair {
        char ch;
        int val;

        Pair(int val, char ch) {
            this.val = val;
            this.ch = ch;
        }
    }


    @Override
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        bfs(graph, root);
        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> visit = new HashSet<>();
        travelKElement(result, graph, k, visit, target);
        return result;
    }

    private void bfs(Map<TreeNode, List<TreeNode>> graph, TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }

        List<TreeNode> curr = graph.getOrDefault(treeNode, new ArrayList<>());
        if (null != treeNode.left) {
            List<TreeNode> left = graph.getOrDefault(treeNode.left, new ArrayList<>());
            left.add(treeNode);
            graph.put(treeNode.left, left);
            curr.add(treeNode.left);
        }
        if (null != treeNode.right) {
            List<TreeNode> right = graph.getOrDefault(treeNode.right, new ArrayList<>());
            right.add(treeNode);
            graph.put(treeNode.right, right);
            curr.add(treeNode.right);
        }
        graph.put(treeNode, curr);
        bfs(graph, treeNode.left);
        bfs(graph, treeNode.right);
    }

    private void travelKElement(List<Integer> result,
                                Map<TreeNode, List<TreeNode>> graph,
                                int distance, HashSet<TreeNode> visit,
                                TreeNode treeNode) {

        if (!visit.contains(treeNode) && distance == 0) {
            result.add(treeNode.val);
            visit.add(treeNode);
            return;
        }
        visit.add(treeNode);
        for (TreeNode child : graph.getOrDefault(treeNode, new ArrayList<>())) {
            travelKElement(result, graph, distance - 1, visit, child);
        }
    }


    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = (a, b) -> {
            String[] A = a.split(" ");
            String[] B = b.split(" ");
            boolean isAD = ((A[1].charAt(0) - '0') >= 0) && ((A[1].charAt(0) - '0') <= 9);
            boolean isBD = ((B[1].charAt(0) - '0') >= 0) && ((B[1].charAt(0) - '0') <= 9);
            if (isBD == isAD) {
                return 1;
            }
            return 1;
        };

        Arrays.sort(logs, comparator);
        return logs;
    }

    @Override
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        for (String s : products) {
            trie.insertWord(s);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            result.add(trie.typeHeadSearch(searchWord.substring(0, i + 1)));
        }
        return result;
    }


}
