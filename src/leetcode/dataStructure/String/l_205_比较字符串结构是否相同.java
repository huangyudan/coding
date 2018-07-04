package leetcode.dataStructure.String;
//Given "egg", "add", return true.
//        Given "foo", "bar", return false.
//        Given "paper", "title", return true.
//        记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 //both s and t have the same length.

// 很重要为什么i+1  因为如果a之前出现了就不可能是0，而如果是i的话，测试用例到第二位的时候b，a都是0 return true
public class l_205_比较字符串结构是否相同 {
    public static boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i <s.length() ; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (preIndexOfS[a] != preIndexOfT[b]) return false;
            preIndexOfS[a] = i+1;
            preIndexOfT[b] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab","aa"));
    }
}
