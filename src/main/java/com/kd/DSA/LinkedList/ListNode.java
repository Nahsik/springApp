package com.kd.DSA.LinkedList;


public class ListNode {
    public int val;
    public ListNode next, random;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

