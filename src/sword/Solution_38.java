package sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution_38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str==null) return null;
        PermutationHelper(str.toCharArray(), result,0);
        Collections.sort(result);//牛客网要求排序一下
        return result;
    }

    public void PermutationHelper(char[] str,ArrayList<String> result,int start){
        if (start==str.length - 1){
            result.add(String.valueOf(str));
        }
        for (int i = start;i<str.length;i++){
            if (i==start || str[i]!=str[start]){
                swap(str,i,start);
                PermutationHelper(str,result,start+1);
                swap(str,i,start);
            }

        }

    }

    public ArrayList<String> Combination(String str) {
        ArrayList<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<Character>();
        if (str==null) return null;
        for (int i = 1;i<=str.length();i++){
            CombinationHelper(str.toCharArray(), result,stack,0,i);
        }
        return result;
    }

    public void CombinationHelper(char[] str,ArrayList<String> result,Stack<Character> stack,int start,int count){
        if (count==0){
            result.add(stack.toString());
            return;
        }
        if (start==str.length) return;


        stack.push(str[start]);
        CombinationHelper(str,result,stack,start+1,count-1);
        stack.pop();
        CombinationHelper(str,result,stack,start+1,count);


    }


    public void swap(char[] strs, int x, int y) {
        char temp = strs[x];
        strs[x] = strs[y];
        strs[y] = temp;
    }

    public static void main(String[] args) {
        Solution_38 s = new Solution_38();
//        ArrayList<String> result = s.Permutation("abc");
        ArrayList<String> result = s.Combination("abb");
        for (String string:result){
            System.out.println(string);
        }
    }
}