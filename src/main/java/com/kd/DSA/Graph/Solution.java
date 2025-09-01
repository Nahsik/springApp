package com.kd.DSA.Graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution implements Problem {

    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = IntStream.range(0, numCourses)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        for (int[] p : prerequisites) {
            graph.get(p[0]).add(p[1]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] curr = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visit[i] && isCycle(i, visit, curr, graph)) {
                return true;
            }
        }
        return true;
    }

    private boolean isCycle(int index, boolean[] curr,
                            boolean[] visit, List<List<Integer>> graph) {
        if (curr[index]) {
            return true;
        }
        if (visit[index]) {
            return false;
        }
        visit[index] = true;
        curr[index] = true;
        for (int i : graph.get(index)) {
            if (isCycle(i, curr, visit, graph)) {
                return true;
            }
        }
        curr[index] = true;
        return false;
    }

    @Override
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];

        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(s1, k1 -> new ArrayList<>());
            graph.computeIfAbsent(s2, k1 -> new ArrayList<>());
            graph.get(s1).add(new Pair(s2, value));
            graph.get(s2).add(new Pair(s2, 1 / value));
        }

        for (int i = 0; i < n; i++) {
            result[i] = findDist(queries.get(i).get(0), queries.get(i).get(1), graph);
        }

        return result;
    }

    private double findDist(String s1, String s2, Map<String, List<Pair>> graph) {
        if (Objects.equals(s1, s2)) {
            return 1;
        }
        if (!graph.containsKey(s1) || !graph.containsKey(s2)) {
            return -1.0;
        }
        Queue<Pair<String, Long>> queue = new LinkedList<>();
        queue.add(new Pair(s1, 1l));
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair<String, Long> pair = queue.poll();
            for (Pair<String, Long> pair1 : graph.get(pair.key)) {
                if (Objects.equals(pair1.key, s2)) {
                    return pair.val * pair1.val;
                }
                if (!visited.contains(pair1.key)) {
                    queue.add(new Pair(pair1.key, pair.val * pair1.val));
                }
            }
            visited.add(pair.key);
        }

        return -1.0;
    }

    static class Pair<K, V> {
        K key;
        V val;

        Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    @Override
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<Pair<Integer,Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pair(nums1[i], nums2[i]));
        }

        list.sort((a, b) -> b.val - a.val);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            int num1 = list.get(i).key;
            int num2 = list.get(i).val;

            minHeap.add(num1);
            sum += num1;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                result = Math.max(result, sum * (long) num2);
            }
        }

        return result;


//        Set<Integer> set = new HashSet<>();
//        long sum = 0;
//        for (int i = 0; i < k; i++) {
//            set.add(list.get(i).key);
//            sum += list.get(i).val;
//        }
//
//        List<Pair<Integer, Integer>> list2 = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list2.add(new Pair<>(i, nums2[i]));
//        }
//        list2.sort((a, b) -> a.val - b.val);
//
//        long result = 0;
//        for (int i = 0; i < n - k; i++) {
//            if (set.contains(i)) {
//                result = Math.max(result, sum * nums2[i]);
//            } else {
//                result = Math.max(result, (sum + nums1[i] - nums1[list.get(k).key] - 1) * nums2[i]);
//            }
//        }
//        return result;
    }

    @Override
    public boolean canMakeEqual(String s, List<List<Character>> rules) {
        Map<Character,List<Character>> graph = new HashMap<>();
        for (List<Character> rule : rules) {
            char start = rule.get(0);
            char end =  rule.get(1);
            graph.computeIfAbsent(start, key -> new ArrayList<>());
            graph.get(start).add(end);

        }


        return false;
    }

}
