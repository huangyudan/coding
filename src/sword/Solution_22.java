package sword;

public class Solution_22 {
    public static int FindKthToTail(ListNode head,int k) {
        if (head==null) return 0;
        int count = 0;
        ListNode latter = head,former=head;
        while (latter != null){
            count++;
            latter = latter.next;
            if (count>k){
                former = former.next;
            }
        }
        if (count>=k) return former.val;
        else return 0;

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        l1.addNode(4);
        l1.addNode(7);
        l1.addNode(1);
        l1.printListNode();
        System.out.println(FindKthToTail(l1,2));
    }
}