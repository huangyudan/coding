package leetcode.greedy;

public class l_392_isSubsenquence {
 //   A subsequence of a string is a new string which is formed from the original string by deleting some
 //   (can be none) of the characters without disturbing the relative positions of the remaining characters
 //   s = "abc", t = "ahbgdc" Return true.
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c,index+1);
            if (index == -1) return false;
        }
        return true;
    }
}
