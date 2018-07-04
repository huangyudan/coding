package sword;

import java.util.Stack;

public class Solution_30 {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    int temp;
    public void push(int node) {
        data.push(node);
        if (temp==0) temp=node;
        if (node<temp){
            temp = node;
            min.push(node);
        }
        else{
            min.push(temp);
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args){
        Solution_30 s = new Solution_30();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(1);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());

    }

}