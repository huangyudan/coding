package leetcode.dataStructure.String;

//Input : "abccccdd"
//Output : 7
//        Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
//        使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
//
//        因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。

//发现一个规律，hashtable一般在key有很多种可能的时候使用，像数字，26个字母这种的用一个定长数组存储就好

public class l_409_一组字符集合可以组成的回文字符串的最大长度 {
    public static int longestPalindrome(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()){
            freq[c]++;
        }
        int res = 0;
        for (int i : freq){
            res += i/2*2;
        }
        return res<s.length()?res+1:res;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
