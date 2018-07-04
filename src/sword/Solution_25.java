package sword;

public class Solution_25 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode merge = new ListNode(0);
        if (list1.val <= list2.val){
            merge.val = list1.val;
            merge.next = Merge(list1.next,list2);
        }
        else{
            merge.val = list2.val;
            merge.next = Merge(list1,list2.next);
        }
        return merge;

    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.addNode(3);
        l1.addNode(5);
        l1.addNode(7);
        l1.printListNode();
        ListNode l2 = new ListNode(2);
        l2.addNode(4);
        l2.addNode(6);
        l2.addNode(8);
        l2.printListNode();
        Merge(l1,l2).printListNode();
    }
}
