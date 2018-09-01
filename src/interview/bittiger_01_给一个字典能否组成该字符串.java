package interview;

import java.util.*;

//Given an input string and a dictionary of words,find out if the string can be segmented into a space
//separated sequence of dictionary words?
//        {i,like,sam,sung,mobile,ice,cream,icecream,man,go,mango}
//        input : ilikesamsung
//        output: True   i like samsung or i like sam sung
public class bittiger_01_给一个字典能否组成该字符串 {
    public static boolean wordBreak(String input,Set<String> dict){
        boolean result = false;
        if (input.length()==0) return true;
        for (int i = 1; i <= input.length(); i++) {
            if (dict.contains(input.substring(0,i))){
                result = wordBreak(input.substring(i),dict);

            }

            if (result==true) break;
        }
        return result;
    }

//    public static boolean wordBreak(String s, List<String> dict) {
//        boolean[] f = new boolean[s.length() + 1];
//
//        f[0] = true;
//
//
//        for(int i=1; i <= s.length(); i++){
//            for(int j=0; j < i; j++){
//                if(f[j] && dict.contains(s.substring(j, i))){
//                    f[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return f[s.length()];
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dict_line = sc.nextLine();
        Set<String> dict = new HashSet<>(Arrays.asList(dict_line.split(",")));
        String input = sc.nextLine();
        System.out.println(wordBreak(input,dict));
    }
}
