package com.kd.DSA;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    Trie[] array;
    boolean isExist;

    public Trie() {
        array = new Trie[26];
    }

    public void insertWord(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            Trie trie1 = null != trie.array[index] ? trie.array[index] : new Trie();
            if (i == s.length() - 1) {
                trie1.isExist = true;
            }
            trie.array[index] = trie1;
            trie = trie.array[index];
        }
    }

    public boolean startWith(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (null == trie.array[index]) {
                return false;
            }
            trie = trie.array[i];
        }
        return true;
    }

    public boolean wordExist(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (null == trie.array[index]) {
                return false;
            }
            trie = trie.array[i];
            if (i == s.length() - 1) {
                return trie.isExist;
            }
        }
        return true;
    }

    public List<String> typeHeadSearch(String s) {
        List<String> result = new ArrayList<>();
        Trie node = this;
        for (char c : s.toCharArray()) {
            if (node.array[c - 'a'] == null)
                return result;
            node = node.array[c - 'a'];
        }
        typeHeadSearch(3, result, new StringBuilder(s), node);
        return result;
    }

    private void typeHeadSearch(int maxSize, List<String> result, StringBuilder curr, Trie trie) {
        if (null == trie || result.size() >= maxSize) {
            return;
        }
        if (trie.isExist) {
            result.add(curr.toString());
        }

        for (int i = 0; i < trie.array.length
                && result.size() < maxSize; i++) {
            if (null != trie.array[i]) {
                char c = (char) (i + 'a');
                curr.append(c);
                typeHeadSearch(maxSize, result, curr, trie.array[i]);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

}