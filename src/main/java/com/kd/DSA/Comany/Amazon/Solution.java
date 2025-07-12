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

    class Pair<T> {
        T ch;
        int val;

        Pair(int val, T ch) {
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


    @Override
    public List<Integer> sequentialDigits(int low, int high) {
        int n = 0;
        int m = 0;
        int k = low;
        while (k > 0) {
            n++;
            k = k / 10;
        }
        k = high;
        while (k > 0) {
            m++;
            k = k / 10;
        }
        List<Integer> list = new ArrayList();
        k = n;
        while (k <= m) {
            for (int start = 1; start <= (9 - k + 1); start++) {
                int num = 0;
                for (int j = 0; j < k; j++) {
                    num *= 10;
                    num += (j + start);
                }
                if (num >= low && num <= high) {
                    list.add(num);
                } else if (num >= high) {
                    break;
                }
            }
            k++;
        }
        return list;
    }

    @Override
    public int getMaxLen(int[] nums) {
        boolean isPos = true;
        int fN = -1;
        int start = 0;
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                start = i + 1;
                fN = -1;
                isPos = true;
            } else {
                if (fN == -1) {
                    fN = i;
                }
                isPos = !isPos;
            }
            max = Math.max(max, isPos ? i - start : -1);
            max = Math.max(max, fN != -1 ? i - fN : -1);
        }
        return max;
    }

    @Override
    public int minSwaps(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        int oneDiff = 0;
        int zeroDiff = 0;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            if (curr == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
            if (num == curr) {
                oneDiff++;
            } else {
                zeroDiff++;
            }
            num = (num + 1) % 2;
        }

        if (Math.abs(zeroCount - oneCount) > 1) {
            return -1;
        }
        oneDiff = oneDiff / 2;
        zeroDiff = zeroDiff / 2;
        return oneCount == zeroCount ? Math.min(oneDiff, zeroDiff)
                : oneCount > zeroCount
                ? oneDiff
                : zeroDiff;
    }

    @Override
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int[][] dp = new int[s.length()][2];
        int cad = 0;
        int plat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                plat++;
            } else {
                cad++;
            }
            dp[i][0] = cad;
            dp[i][1] = plat;
        }

        if (cad < 2) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if ((start == 0 ? dp[end][0] : dp[end][0] - dp[start - 1][0]) <= 1) {
                result[i] = 0;
                continue;
            }
            start = binarySearch(start == 0 ? 1 : dp[start - 1][0] + 1, start, end, dp);
            end = binarySearch(dp[end][0], start, end, dp);

            result[i] = dp[end][1] - dp[start][1];
        }
        return result;
    }

    private int binarySearch(int target, int start, int end, int[][] dp) {
        int result = start;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dp[mid][0] == target) {
                result = mid;
                end = mid - 1;
            } else if (dp[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int n = s.length();

        int[] nearestRightCandle = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] candleCount = new int[n];
        int[] ans = new int[queries.length];

        int left = -1, right = -1, count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                left = i;
                count++;
            }
            nearestLeftCandle[i] = left;
            candleCount[i] = count;

            int j = n - 1 - i;
            if (s.charAt(j) == '|') {
                right = j;
            }
            nearestRightCandle[j] = right;
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int leftCandle = nearestRightCandle[l];
            int rightCandle = nearestLeftCandle[r];

            if (leftCandle != -1 && rightCandle != -1 && leftCandle < rightCandle) {
                int totalCandles = candleCount[rightCandle] - candleCount[leftCandle];
                ans[i] = rightCandle - leftCandle - totalCandles;
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }

    @Override
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            left[i] = security[i] <= security[i - 1] ? left[i - 1] + 1 : 0;
            right[n - i - 1] = security[n - i] >= security[n - i - 1] ? right[n - i] + 1 : 0;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (right[i] >= time && left[i] >= time) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.add(i);
        }

        long result = 0;
        int module = 1000_000_007;

        for (int i = 0; i < n; i++) {
            long leftCount = i - left[i];
            long rightCount = right[i] - i;
            long contribution = ((long) arr[i] * leftCount * rightCount) % module;

            result = (result + contribution) % module;
        }

        return (int) result;
    }

    @Override
    public long subArrayRanges(int[] nums) {
        long sum = 0;


        return sum;
    }

    @Override
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
//        return nums[0];
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            dp[i] = dp[i - 1] * i;
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i] * (dp[n - 1] / (dp[n - i - 1] * dp[i]));
//        }
        return nums[0];
    }

    @Override
    public long numberOfWays(String s) {
        long one = 0, zero = 0, oneZero = 0, zeroOne = 0, ways = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zero;
                oneZero += one;
                ways += zeroOne;
            } else {
                ++one;
                zeroOne += zero;
                ways += oneZero;
            }
        }
        return ways;
    }

    public int minimumKeypresses(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        Arrays.sort(hash);
        int result = 0;
        for (int i = 25; i >= 0; i--) {
            if (i <= 8) {
                result += 3 * hash[i];
            } else if (i <= 17) {
                result += 2 * hash[i];
            } else {
                result += hash[i];
            }
        }
        return result;
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, PriorityQueue<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String user = username[i];
            PriorityQueue<Pair> pairs = map.getOrDefault(user,
                    new PriorityQueue<>((Pair a, Pair b) -> a.val - b.val));
            Pair<String> pair = new Pair<>(timestamp[i], website[i]);
            pairs.add(pair);
            map.put(user, pairs);
        }

        Map<String, Integer> map1 = new HashMap<>();
        for (Map.Entry<String, PriorityQueue<Pair>> entry : map.entrySet()) {
            PriorityQueue<Pair> value = entry.getValue();
            List<String> list = value.stream().map(p -> (String) p.ch).toList();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < list.size() - 2; i++) {
                set.add(list.get(i) + "," + list.get(i + 1) + "," + list.get(i + 2));
            }
            for (String s : set) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
        }

        List<String> result = map1.entrySet().stream()
                .sorted((a,b)->b.getValue()-a.getValue()).limit(1)
                .map(a-> a.getKey()).toList();

        return Arrays.asList(result.get(0).split(","));
    }


}
