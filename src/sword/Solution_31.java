package sword;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_31 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null && popA==null) return true;
        if (pushA==null || popA ==null) return false;
        if (pushA.length != popA.length) return false;
        Stack<Integer> s = new Stack<>();
        int i=0;
        for (int j = 0; j < popA.length; j++) {
            if (s.isEmpty()){
                s.push(pushA[i]);
                i++;
            }
            while(s.peek()!= popA[j]){
                if (i==pushA.length) return false;
                s.push(pushA[i]);
                i++;
            }
            s.pop();
        }
        return true;

    }


    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        System.out.println(IsPopOrder(push,pop1));
        System.out.println(IsPopOrder(push,pop2));
    }
}