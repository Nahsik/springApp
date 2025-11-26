import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.*;

import static java.util.Objects.checkFromIndexSize;
import static java.util.Objects.hash;


// Definition for singly-linked list.


class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


        public long maxPower(int[] stations, int r, int k) {
            int n = stations.length;
            long[] dp = new long[n];
            long currSum = 0;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                currSum += stations[i];
            }

            for (int i = 0; i < n; i++) {
                dp[i] = currSum;
                min = Math.min(currSum, min);
                max = Math.max(currSum, max);
                if (i + k < n) {
                    currSum += stations[i + k];
                }
                if (i - k >= 0) {
                    currSum -= stations[i - k];
                }
            }

            long result = 0;
            long start = min;
            long end = max + k;
            while (start <= end) {
                long mid = (start + end) / 2;
                if (isSolve(dp, mid, k, r)) {
                    result = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return result;
        }

        private static boolean isSolve(long[] dp, long mid, int k, int r) {
            List<long[]> add = new ArrayList<>();
            int start = 0;

            for (int i = 0; i < dp.length; i++) {
                if (dp[i] < mid) {
                    long required = mid - dp[i];
                    for (int j = start; j < add.size(); j++) {
                        if (add.get(j)[0] >= i) {
                            required -= add.get(j)[1];
                        } else {
                            start++;
                        }
                        if (required <= 0) {
                            break;
                        }
                    }
                    if (required > 0) {
                        if (required > k) {
                            return false;
                        }
                        add.add(new long[] { i + 2 * k, required });
                        k -= required;
                    }
                }
            }

            return true;
        }






}

class Solution {
    public long maxPower(int[] stations, int r, int k) {

//        Map<Object,Object> map = new TreeMap<>((int a , int b) ->{return a -b});
//        map.put("test","12"); // O(1) => O(n)
//        map.put("test2","123"); // O(1)
//        map.get("test3");
//        List<Integer> list = new ArrayList<>(); // fix => [75%]  -> 20 ->
//        List<Integer> list1 = new LinkedList<>(); =>
        // [node] -> [node] -> [node] -> O(n) -> O(log(n))
//         => hashCode() => & => %
//                -> 128 -> 8
//                -> 138 -> 8
//                -> 10
            //  1 3, 4,5,6,78,3,9
            //  1, 2, 4, 6,78,3,9
          // elem  -> elm3
        /**
         *   -> "test" -> "test2" -> "test3"
         *   [,,,->[linkedList],,,,] => 16
         */      //   [LinkedList]




        int n = stations.length;
        long[] dp = new long[n];
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stations[i];

        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            dp[i] = prefix[right + 1] - prefix[left];
        }

        long low = 0;
        long high = Arrays.stream(dp).max().getAsLong() + k;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (isSolve(dp, mid, k, r)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isSolve(long[] dp, long mid, long k, int r) {
        int n = dp.length;
        long[] diff = new long[n + 1];
        long added = 0;

        for (int i = 0; i < n; i++) {
            added += diff[i];
            if (dp[i] + added < mid) {
                long need = mid - (dp[i] + added);
                if (need > k) return false;
                k -= need;
                added += need;
                if (i + 2 * r + 1 < diff.length)
                    diff[i + 2 * r + 1] -= need;
            }
        }
        return true;
    }

    class Solution {
        public int findFinalValue(int[] nums, int original) {
            boolean[] array = new boolean[1001];
            for(int i:nums){
                if(i%original == 0){
                    array[getPower(i/original)] = true;
                }
            }
            for(int i=1;i<1001;i++){
                if(!array[i]){
                    return (int) (original*Math.pow(2,i-1));
                }
            }
            return original;
        }

    }
    private int getPower(int num){
        int curr = 1;
        int count = 0;
        while(curr < num){
            curr*=2;
            count++;
        }
        return curr==num ? count : 0;
    }


}

class Solution {

    public int minimumOneBitOperations(int n) {
        int result = 0;
        if(n==0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        while (n > 0){
            list.add(n%2);
            n /=2;
        }

        for(int i=list.size()-1 ; i > 0 ;i--){
            result += makeZero(i,list);
        }

        return result;
    }


    private int makeZero(int index , List<Integer> list ){
        if(index<0){
            return 0;
        }
        if (list.get(index)==0){
            return 0;
        }
        if(index==0){
            list.set(index,0);
            return 1;
        }
        list.set(index,0);
        int result = 1;
        result+= makeOne(index-1,list);
        int newIndex = index-2;
        while(newIndex > 0){
            result+= makeZero(newIndex--,list);
        }
        return  result;
    }

    private int makeOne(int index , List<Integer> list ){
        if(index<0){
            return 0;
        }
        if (list.get(index)==1){
            return 0;
        }
        if(index==0){
            list.set(index,1);
            return 1;
        }
        list.set(index,1);
        int result = 1;
        result+= makeOne(index-1,list);
        int newIndex = index-2;
        while(newIndex > 0){
            result+= makeZero(newIndex--,list);
        }
        return  result;
    }

    public int minimumOneBitOperations1(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) return 0;
        int k = 31 - Integer.numberOfLeadingZeros(n);
        return (1 << (k + 1)) - 1 - helper(n ^ (1 << k));
    }

    public int findMaxForm(String[] strs, int m, int n) {
       int zero = 0;
       int one = 0;
       int start = 0;
       int end = 0;
       int max = 0;
       List<int[]> list = new ArrayList<>();
       while (start < strs.length){
           int[] count = findOneAndZero(strs[start]);
           start++;
           zero+= count[0];
           one+= count[1];
           while (zero > m || one > n ){
               int[] endCount = list.get(end);
               zero-= endCount[0];
               one-= endCount[1];
               end++;
           }
           max = Math.max(max,start-end);
       }
       return max;
    }

    private int[] findOneAndZero(String s){
        int one = 0;
        int zero = 0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'==0){
                zero++;
            }else {
                one++;
            }
        }
        return new int[]{zero,one};
    }
    class Solution {
        class Solution {
            public int findMaxForm(String[] strs, int m, int n) {
                int size = strs.length;
                int[][] frq = new int[size][2];
                for (int i = 0; i < size; i++) {
                    int one = 0;
                    String s = strs[i];
                    for (int j = 0; j < s.length(); j++) {
                        one += s.charAt(j) - '0';
                    }
                    frq[i][0] = s.length() - one;
                    frq[i][1] = one;
                }
                int[][] dp = new int[m][n];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < m; j++) {
                        for (int k = 0; n < size; k++) {
                            int zero = frq[k][0];
                            int one = frq[k][1];
                            if (zero <= i && one <= j) {
                                if (i - zero >= 0 && j - one >= 0) {
                                    dp[i][j] = Math.max(1 + dp[i - zero][j - one],dp[i][j]);
                                } else {
                                    dp[i][j] = Math.max(1,dp[i][j]);
                                }
                                //System.out.println(i+":"+j+":"+k + ":" dp[k][i][j]);
                            }
                        }
                    }
                }
                return dp[m][n];
            }
        }

    }


    class Solution {
        public int numSub(String s) {
            int result = 0;
        }
    }

}


class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] charFirst = new int[26];
        int[] posBit = new int[n];
        Arrays.fill(charFirst, -1);

        int bits = 0;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            posBit[i] = bits |= 1 << idx;
            if (charFirst[idx] == -1) {
                charFirst[idx] = i;
                bits = 0;
            }
        }

        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            int idx = s.charAt(i) - 'a';
            if (charFirst[idx] <= -1 || charFirst[idx] == i) {
                continue;
            }
            res += Integer.bitCount(arrOr(charFirst[idx] + 1, i - 1, posBit));
            charFirst[idx] = -2;
        }
        return res;
    }

    private int arrOr(int start, int end, int[] arr) {
        int res = 0;
        for (int i=start; i<=end; i++) {
            res |= arr[i];
        }
        return res;
    }

    // public int countPalindromicSubsequence(String s) {
    //     int n = s.length();
    //     int[] charFirst = new int[26];
    //     Arrays.fill(charFirst, -1);

    //     for (int i = 0; i < n; i++) {
    //         int idx = s.charAt(i) - 'a';
    //         if (charFirst[idx] == -1) {
    //             charFirst[idx] = i;
    //         }
    //     }

    //     int res = 0;
    //     for (int i = n - 1; i >= 2; i--) {
    //         int idx = s.charAt(i) - 'a';
    //         if (charFirst[idx] <= -1 || charFirst[idx] == i) {
    //             continue;
    //         }
    //         res += s.substring(charFirst[idx] + 1, i).chars().distinct().count();
    //         charFirst[idx] = -2;
    //     }
    //     return res;
    // }

    class Solution {
        public int numberOfPaths(int[][] grid, int k1) {
            int n = grid.length;
            int m = grid[0].length;
          int[][][] dp = new int[n][m][k1];
          int mod = 1_000_000_007;
          for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int num = grid[i][j];
                   for(int k=0;k<k1;k++){
                       int req = k1 - k - 1 ;
                       int a = i-1 >= 0 ? dp[i-1][j][req] : 0 ;
                       int b = j-1 >= 0 ? dp[i][j-1][req] : 0;
                   }
                }
          }

          return dp[n-1][m-1][0];
        }
    }

}
