package sword;

import java.util.Scanner;

public class Solution_58_2 {
    public static String leftRotateString(String str,int i){
        if(str==null||str.length()==0||i<=0||i>=str.length())
            return str;
        char[] c = str.toCharArray();
        reverseSubString(c,0,c.length-1);
        reverseSubString(c,c.length-i,c.length-1);
        reverseSubString(c,0,c.length-i-1);
        return new String(c);
    }
    //翻转stringBuilder[start,end]
    public static void reverseSubString(char[] c,int start,int end){
        while(start<end){
            char t = c[start];
            c[start] = c[end];
            c[end] = t;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
//        String str = "abcdefg";
        System.out.println(leftRotateString(str,n));
    }

}
