package leetcode.dynamic;

import java.util.List;

public class l_139_canWordGetByGivenDictionary {
//    s = "leetcode",
//    dict = ["leet", "code"].
//    Return true because "leetcode" can be segmented as "leet code".

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i ; j++) {
                if (res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
