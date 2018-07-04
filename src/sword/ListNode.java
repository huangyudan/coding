package sword;

public class ListNode {
    int val;
    ListNode next = null;
    ListNode now = this;
    ListNode(int val) {
        this.val = val;
    }

    public void addNode(int v) {
        now.next = new ListNode(v);
        now = now.next;
    }

    public void printListNode(){
        ListNode l = this;
        while (l!=null){
            System.out.print("  "+l.val+"  " );
            l = l.next;
        }
        System.out.println(' ');
    }
}

