package com.kd.DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * <a href="https://leetcode.com/problems/reverse-linked-list/">reverse-linked-list</a>
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tamp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tamp;
        }
        return prev;
    }

    /**
     * <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">merge-two-sorted-lists</a>
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode result = null;

        if (list1.val > list2.val) {
            result = list2;
            list2 = list2.next;
        } else {
            result = list1;
            list1 = list1.next;
        }
        ListNode head = result;
        while (null != list1 || null != list2) {
            Integer val1 = null != list1 ? list1.val : null;
            Integer val2 = null != list2 ? list2.val : null;

            if (null != val1 && null != val2) {
                if (val1 > val2) {
                    result.next = list2;
                    result = result.next;
                    list2 = list2.next;
                } else {
                    result.next = list1;
                    result = result.next;
                    list1 = list1.next;
                }
            } else if (null != val1) {
                result.next = list1;
                result = result.next;
                list1 = list1.next;
            } else {
                result.next = list2;
                result = result.next;
                list2 = list2.next;
            }

        }

        return head;

    }

    /**
     * <a href="http://leetcode.com/problems/linked-list-cycle/description/">linked-list-cycle</a>
     *
     * @param head
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/find-the-duplicate-number/">find-the-duplicate-number</a>
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * <a href="https://leetcode.com/problems/reorder-list/">reorder-list</a>
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tamp = head;
        ListNode tamp1 = slow.next;
        slow.next = null;
        while (null != tamp) {
            ListNode tamp3 = tamp.next;
            tamp.next = tamp1;
            tamp1 = tamp1.next;
            tamp = tamp.next;
            tamp.next = tamp3;
            tamp = tamp.next;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">remove-nth-node-from-end-of-list</a>
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">copy-list-with-random-pointer</a>
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Map<Node, Node> map1 = new HashMap<>();

        Node tamp = head;
        Node result = new Node(0);
        Node tamp1 = result;
        while (null != tamp) {
            Node listNode1 = new Node(tamp.val);
            tamp1.next = listNode1;
            tamp1 = tamp1.next;
            map.put(listNode1, tamp);
            map1.put(tamp, listNode1);
            tamp = tamp.next;
        }

        tamp = result.next;
        while (null != tamp) {
            Node node = map.get(tamp);
            tamp.random = (null == node.random) ? null : map1.get(node.random);
            tamp = tamp.next;
        }
        return result.next;
    }
    public Node copyRandomList1(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }

}
