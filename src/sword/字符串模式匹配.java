package sword;
//pattern = "abba", str="北京 杭州 杭州 北京" 返回 ture
//        pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
//        pattern = "abc", str="北京 杭州 杭州 南京" 返回 false
//        pattern = "acac", str="北京 杭州 北京 广州" 返回 false

import java.util.HashMap;
import java.util.Scanner;

public class 字符串模式匹配 {

    public static boolean isMatch(String[] words,String pattern){
        HashMap<Character,String> dict = new HashMap<>();
        for (int i = 0;i<words.length;i++){
            char c = pattern.charAt(i);
            if (!dict.containsKey(c)){
                dict.put(c,words[i]);
            }else {
                if (!words[i].equals(dict.get(c))){
                    return false;
                }
            }
        }
        return true;
    }

    public static int firstEqual(String source,String pattern){
        for (int i = 0; i <= source.length()-pattern.length(); i++) {
            char first1 = source.charAt(i);
            char first2 = pattern.charAt(0);
            if (first1!=first2){
                continue;
            }else{
                int move = 1;
                while(move<pattern.length()){
                    if (source.charAt(i+move)==pattern.charAt(move)){
                        move++;
                    }else{
                        break;
                    }
                }
                if (move==pattern.length()) return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        String pattern = in.nextLine();
        String[] word = words.split(" ");
        System.out.println(isMatch(word,pattern));
        String source = in.nextLine();
        String pattern2 = in.nextLine();
        System.out.println(firstEqual("dfagrgdjfagdojf ","gdgdf"));

    }


}
