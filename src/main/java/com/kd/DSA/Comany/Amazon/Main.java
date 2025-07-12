package com.kd.DSA.Comany.Amazon;

import java.util.List;

public class Main {
    public static void main(String[] arg) {
        Problem problem = new Solution();
        String[] username = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        String[] webSite = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        int[] timeStamp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<String> result = problem.mostVisitedPattern(username, timeStamp, webSite);
        for (String s : result) {
            System.out.print(s + ",");
        }
    }
}
