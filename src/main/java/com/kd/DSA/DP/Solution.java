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
}
