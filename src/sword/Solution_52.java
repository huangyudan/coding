package sword;

import java.util.Stack;

public class Solution_52 {

    //思路一：暴力解决，时间复杂度o(mn)，空间复杂度o(1)
    //思路二：借助于两个栈，时间复杂度o(m+n)，空间复杂度o(m+n)
    //思路三：转化为等长链表，时间复杂度o(m+n)，空间复杂度o(1)
    public static ListNode findFirstCommonNode(ListNode head1,ListNode head2){
        for(ListNode node1=head1;node1!=null;node1=node1.next){
            for(ListNode node2=head2;node2!=null;node2=node2.next){
                if(node1==node2)
                    return node1;
            }
        }
        return null;
    }

    public static ListNode findFirstCommonNode2(ListNode head1,ListNode head2){
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        for (ListNode node1 = head1;node1!=null;node1 = node1.next){
            stack1.push(node1);
        }
        for (ListNode node2 = head2;node2!=null;node2 = node2.next){
            stack2.push(node2);
        }
        ListNode commonNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                commonNode = stack1.pop();
                stack2.pop();
            } else break;
        }
        return commonNode;
    }

    public static ListNode findFirstCommonNode3(ListNode head1,ListNode head2){
        ListNode node1 = head1,node2 = head2;
        int size1 = 0,size2 = 0;
        for (;node1!=null;node1 = node1.next)
            size1++;
        for (;node2!=null;node2 = node2.next)
            size2++;
        node1 = head1;
        node2 = head2;
        while (size1>size2){
            node1 = node1.next;
            size1--;
        }
        while (size2>size1){
            node2 = node2.next;
            size2--;
        }
        while (node1!=null){
            if(node1!=node2){
                node1 = node1.next;
                node2 = node2.next;
            }
            else
                break;
        }
        return node1;
    }




}
