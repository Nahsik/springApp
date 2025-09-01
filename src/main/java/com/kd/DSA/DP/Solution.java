package com.kd.DSA.DP;

import java.util.*;

public class Solution implements Problem {
    @Override
    public List<String> generateParenthesis(int n) {
        List<Set<String>> list = new ArrayList<>();
        list.add(new HashSet<>());
        list.add(new HashSet<>());
        list.get(0).add("()");
        list.get(1).add("()()");
        list.get(1).add("(())");

        for (int i = 2; i < n; i++) {
            Set<String> prv = list.get(i - 1);
            Set<String> curr = new HashSet<>();
            for (String s : prv) {
                curr.add("()" + s);
                curr.add("(" + s + ")");
                curr.add(s + "()");
            }
            list.add(curr);
        }
        List<String> result = new ArrayList<>(list.get(n - 1));
        Collections.sort(result);
        return result;
    }

    @Override
    public int longestIncreasingPathBackTracking(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int[] result = new int[]{0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = longestIncreasingPathBackTracking(matrix, result, dp, i, j, -1);
            }
        }

        return result[0];
    }

    public int longestIncreasingPathBackTracking(int[][] matrix, int[] result, int[][] dp,
                                                 int x, int y, int num) {
        if (x < 0 || y < 0 || x > matrix.length || y > matrix[0].length) {
            return 0;
        }
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        if(num > matrix[x][y]){

        }

    return dp[x][y];

    }

}
