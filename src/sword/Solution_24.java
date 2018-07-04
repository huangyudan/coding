package sword;

public class Solution_24 {
    public static ListNode ReverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode former = null,now=head;
        ListNode latter;
        while (now!=null){
            latter = now.next;
            now.next = former;
            former = now;
            now = latter;
        }
        return former;


    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        l1.addNode(4);
        l1.addNode(7);
        l1.addNode(1);
        l1.printListNode();
        ListNode r = ReverseList(l1);
        r.printListNode();
    }
}
