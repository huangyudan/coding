package sword;

import java.util.Scanner;

public class Solution_5 {
    //由于java的字符数组没有结束符，所以需要多传入个原始长度
    //先计算好替换后的位置，从后向前替换，时间复杂度o(n)
    public static String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int idxOfOld = oldLen - 1;
        int idxOfNew = str.length() - 1;
        while (idxOfOld >= 0 ) {
            char c = str.charAt(idxOfOld--);
            if (c == ' ') {
                str.setCharAt(idxOfNew--, '0');
                str.setCharAt(idxOfNew--, '2');
                str.setCharAt(idxOfNew--, '%');
            } else {
                str.setCharAt(idxOfNew--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        StringBuffer d = new StringBuffer(data);
        System.out.println(data);
        System.out.println(replaceSpace(d));
    }
}


