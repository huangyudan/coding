package sword;

public class Solution_23 {
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null) return null;
        if (pHead.next==pHead) return pHead;
        ListNode slow=pHead,fast=pHead;
        while (fast.next!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                slow = pHead;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;

    }



    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l5;
        ListNode e = EntryNodeOfLoop(l1);
        if (e!=null) System.out.println(e.val);
    }

}
