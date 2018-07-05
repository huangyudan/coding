package leetcode.dataStructure.String;

//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//从字符串的某一位开始，尝试着去扩展子字符串。

public class l_647_有多少个回文子字符串 {
    private int cnt = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i <s.length(); i++) {
            extend(s,i,i);
            extend(s,i,i+1);
        }
        return cnt;
    }

    public int extend(String s, int start, int end){
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            cnt++;
            start--;
            end++;
        }
        return cnt;
    }
}
