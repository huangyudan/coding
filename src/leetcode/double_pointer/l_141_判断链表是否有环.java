package leetcode.double_pointer;

import sword.ListNode;

public class l_141_判断链表是否有环 {

    class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
     }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
