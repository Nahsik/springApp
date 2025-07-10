package com.kd.DSA.String;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Problem {

    @Override
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> sb = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sb.add(new StringBuilder());
        }
        int inc = 1;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.get(curr).append(s.charAt(i));
            curr += inc;
            if (curr == -1) {
                inc = 1;
                curr += inc;
                curr += inc;
            }
            if (curr == numRows) {
                inc = -1;
                curr += inc;
                curr += inc;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder s1 : sb) {
            result.append(s1);
        }
        return result.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int k = (i == 0 || i == (numRows - 1)) ? (numRows - 1) : numRows - i;
            int index = i;
            while (index < s.length()) {
                result.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    k = numRows - k;
                }
                index += 2 * (k - 1);
            }
        }
        return result.toString();
    }
}
