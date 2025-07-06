package com.kd.DSA.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution implements Problem {

    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = s.length();
        int k = words[0].length() * words.length;
        int k1 = words[0].length();
        for (int i = 0; i <= n - k; i++) {
            Map<String, Integer> map1 = new HashMap<>(map);
            for (int j = 0; j < k; j = j + k1) {
                String sub = s.substring(j + i, j + i + k1);
                if (!map1.containsKey(sub)) {
                    break;
                }
                Integer feq = map1.get(sub);
                feq--;
                if (feq <= 0) {
                    map1.remove(sub);
                } else {
                    map1.put(sub, feq);
                }
            }
            if (map1.isEmpty()) {
                result.add(i);
            }
        }
        return result;
    }

}
