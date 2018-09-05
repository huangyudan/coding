package sword;//其实就是有多少个回文子串

/*
如果头尾字符不相等:
则字符串的回文子序列个数
= 去掉头的字符串的回文子序列个数
+去掉尾的字符串的回文子序列个数
-去掉头尾的字符串的回文子序列个数；

如果相等
= 去掉头的字符串的回文子序列个数
 +去掉尾的字符串的回文子序列个数
+ 1；

*/


import java.util.*;
public class 去除字符变回文 {
    public static void solutions(long[][] a,int len,String str)
    {
        for (int i = 2; i <= len; i++)
            for (int j = 0, k = i - 1; k<len; j++, k++)
            {
                a[j][k] = a[j + 1][k] + a[j][k - 1];
                if (str.charAt(j) == str.charAt(k))   a[j][k] += 1;
                else  a[j][k] -= a[j + 1][k - 1];
            }
        System.out.println(a[0][len - 1]);
    }
    public static void main(String[] args) {
        int maxnumber = 65;
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int len = str.length();
        long a[][] = new long[maxnumber][maxnumber];
        for (int i = 0; i<maxnumber; i++) {
            for (int j = 0; j<maxnumber; j++)
            {
                if (i == j)  a[i][j] = 1;
                else  a[i][j] = 0;
            }
        }
        solutions(a,len,str);
    }

}