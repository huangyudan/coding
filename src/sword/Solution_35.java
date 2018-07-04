package sword;

import java.util.HashMap;

public class Solution_35 {
    //解法 1
    public static RandomListNode Clone1(RandomListNode pHead) {
        if (pHead==null) return null;
        //第一步：把值复制好，把next指针搞搞好
        RandomListNode newHead = new RandomListNode(pHead.val);//复制好的链表 的开头
        RandomListNode prev = newHead;
        RandomListNode now = new RandomListNode(0);
        RandomListNode h = pHead.next;
        while (h!=null){
            now.val = h.val;
            prev.next = now;
            prev = now;
            now = new RandomListNode(0);
            h = h.next;
        }

        //第二步：把随机指针复制一遍
        RandomListNode nH = newHead;
        RandomListNode H = pHead;
        while (nH!=null){
            RandomListNode random = H.random;
            if (random!=null){
                RandomListNode HH = pHead;
                RandomListNode nHH = newHead;
                while (HH!=null && HH!=random){
                    HH = HH.next;
                    nHH = nHH.next;
                }
                nH.random = nHH;
            }
            H = H.next;
            nH = nH.next;
        }
        return newHead;

    }

    //解法二
    //time:o(n) space:o(n)
    //使用o(n)的空间，换取了时间复杂度的降低
    public static RandomListNode clone2(RandomListNode head) {
        if(head==null)
            return null;
        HashMap<RandomListNode,RandomListNode> oldToNew = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.val);
        oldToNew.put(head,newHead);
        RandomListNode cur = head.next;
        RandomListNode newCur = null;
        RandomListNode newCurPrev = newHead;
        while (cur!=null){
            newCur = new RandomListNode(cur.val);
            oldToNew.put(cur,newCur);
            newCurPrev.next = newCur;
            newCurPrev = newCurPrev.next;
            cur = cur.next;
        }
        cur = head;
        newCur = newHead;
        while(cur!=null){
            if(cur.random!=null){
                newCur.random = oldToNew.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }


    //解法三
    //time:o(n) space:o(1)
    public static RandomListNode clone3(RandomListNode head) {
        if(head==null)
            return null;
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }
    public static void cloneNodes(RandomListNode head){
        RandomListNode cur = head;
        RandomListNode temp = null;
        while (cur!=null){
            temp = new RandomListNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }
    public static void connectRandomNodes(RandomListNode head){
        RandomListNode cur = head;
        RandomListNode curNext = head.next;
        while (true){
            if(cur.random!=null)
                curNext.random = cur.random.next;
            cur = cur.next.next;
            if(cur == null)
                break;
            curNext = curNext.next.next;
        }
    }
    public static RandomListNode reconnectNodes(RandomListNode head){
        RandomListNode newHead = head.next;
        RandomListNode cur = head;
        RandomListNode newCur = newHead;
        while (true){
            cur.next = cur.next.next;
            cur = cur.next;
            if(cur==null){
                newCur.next = null;
                break;
            }
            newCur.next = newCur.next.next;
            newCur = newCur.next;
        }
        return newHead;
    }






    public static void main(String[] args){
        RandomListNode head = new RandomListNode(1);
        RandomListNode c2 = new RandomListNode(2);
        RandomListNode c3 = new RandomListNode(3);
        RandomListNode c4 = new RandomListNode(4);
        RandomListNode c5 = new RandomListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:"+'\t'+head);
        System.out.println("clone1:  "+'\t'+Clone1(head));
//        System.out.println("clone2:  "+'\t'+Clone2(head));
//        System.out.println("clone3:  "+'\t'+Clone3(head));

    }

}
