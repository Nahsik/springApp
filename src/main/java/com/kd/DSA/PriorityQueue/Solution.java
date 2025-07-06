package com.kd.DSA.PriorityQueue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution implements Problem {

    @Override
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff);
        for (int i : arr) {
            int diff = i - x > 0 ? i - x : x - i;
            if (pq.size() < k) {
                pq.add(new Pair(i, diff));
            } else if (pq.peek().diff > diff) {
                pq.poll();
                pq.add(new Pair(i, diff));
            }
        }
        return pq.stream().map(p -> p.num).sorted().collect(Collectors.toList());
    }

    class Pair {
        int num;
        int diff;

        Pair(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
    }
}
