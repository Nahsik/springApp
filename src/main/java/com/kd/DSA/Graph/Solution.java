package com.kd.DSA.Graph;

import java.util.ArrayList;
import java.util.List;
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
            if (!visit[i] && isCycle(i, visit, graph)) {
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
}
