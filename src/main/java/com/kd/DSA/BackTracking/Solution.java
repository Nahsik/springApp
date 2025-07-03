package com.kd.DSA.BackTracking;

import java.util.*;

public class Solution implements Problem {
    @Override
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsets(result, temp, nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        subsets(result, temp, nums, index + 1);
        temp.add(nums[index]);
        subsets(result, temp, nums, index + 1);
        temp.remove(temp.size() - 1);
    }

    private String[] digitToChar = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    @Override
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(result, 0, digits, new StringBuilder());
        return result;
    }


    private void letterCombinations(List<String> result, int index, String digits, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int n = digits.charAt(index) - '0';
        for (char ch : digitToChar[n].toCharArray()) {
            sb.append(ch);
            letterCombinations(result, index + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Override
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<List<Integer>> pali = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) {
                    list.add(j);
                }
            }
            pali.add(list);
        }
        partition(result, pali, s.length(), 0, s, new ArrayList<>());
        return result;
    }

    private void partition(List<List<String>> result,
                           List<List<Integer>> pali,
                           int n, int index, String s, List<String> curr) {
        if (n <= index) {
            result.add(curr);
            return;
        }
        for (int i : pali.get(index)) {
            curr.add(s.substring(index, i));
            partition(result, pali, n, i + 1, s, curr);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (end > start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    @Override
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();

        backtrack(0, n, board, cols, diag, antiDiag, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board,
                           Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag,
                           List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag.contains(row - col) || antiDiag.contains(row + col)) continue;

            board[row][col] = 'Q';
            cols.add(col);
            diag.add(row - col);
            antiDiag.add(row + col);

            backtrack(row + 1, n, board, cols, diag, antiDiag, result);

            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row - col);
            antiDiag.remove(row + col);
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }


}
