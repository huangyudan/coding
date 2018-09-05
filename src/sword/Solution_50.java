package sword;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution_50 {
    public static int FirstNotRepeatingChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i),time+1);
            }
            else{
                map.put(str.charAt(i),1);
            }
        }
        int pos = -1;
        int i=0;
        for (;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c)==1){
                return i;
            }
        }
        return pos;
    }

    public static int FirstNotRepeatingChar2(String str){
        //使用这个数组记录字符出现次数
        int[] times = new int[256];
        for(int i=0;i<str.length();i++)
            times[str.charAt(i)]++; //g的ascii码是103 就找到103的位置存
        for(int i=0;i<str.length();i++){
            if(times[str.charAt(i)]==1)
                return i;
        }
        return -1;
    }



    public static void main(String[] args){
        System.out.println(FirstNotRepeatingChar("google"));
        System.out.println(FirstNotRepeatingChar("abaccdeff"));

    }


}
