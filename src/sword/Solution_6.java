package sword;

import java.util.ArrayList;
import java.util.Stack;
public class Solution_6 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
     }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 方法一：使用栈的数据结构
//        Stack<Integer> s = new Stack<Integer>();
//        while (listNode!=null){
//            s.push(listNode.val);
//            listNode = listNode.next;
//        }
//		ArrayList<Integer> list=new ArrayList<Integer>();
//        while (!s.isEmpty()){
//            list.add(s.pop());
//        }
//		return list;


        //方法二：使用递归
        ArrayList<Integer> list1 =new ArrayList<Integer>();
        ListNode pNode = listNode;
        if (pNode!=null) {
            if (pNode.next != null) {
                list1 = printListFromTailToHead(pNode.next);
            }
            list1.add(pNode.val);
        }
        return list1;

    }
}