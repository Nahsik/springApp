package com.kd.DSA.DataStureDesign.insDelMaxFindAndDeleteCon;

import java.util.HashSet;
import java.util.Set;

public class maxNumConstantTime {

    private Set<Node> set = new HashSet<>();

    public maxNumConstantTime() {

    }

    public boolean insert(int val) {
        Node node = new Node(val);
        if (set.add(node)) {

            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        return true;
    }

    public int getMaxNum() {
        return 0;
    }

    public void removeMaxNum() {

    }

    private class Node {
        Node next, prev;
        int val;

        Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object obj) {
            return this.val == ((Node) obj).val;
        }
    }


}
