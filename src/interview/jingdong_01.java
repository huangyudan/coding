package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class jingdong_01 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        if(S==null||S.length()==0) {
            return 0;
        }
        int len = T.length();
        int res = 0;
        for(int i = 0;i<=S.length()-len;i++){
            if(isSame(S.substring(i,i+len),T)){
                res++;
            }
        }
        return res;

    }

    static boolean isSame(String s1,String s2){
        HashMap<Character,Character> map2 = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s1.length();i++){
            if(map2.containsKey(s1.charAt(i))){
                if(s2.charAt(i) != map2.get(s1.charAt(i))){
                    return false;
                }
            }else {
                if(set.contains(s2.charAt(i))){
                    return false;
                }
                map2.put(s1.charAt(i),s2.charAt(i));
                set.add(s2.charAt(i));
            }
        }

        return true;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in

);
        int res;
        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}