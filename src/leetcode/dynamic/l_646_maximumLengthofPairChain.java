package leetcode.dynamic;

import java.util.Arrays;

public class l_646_maximumLengthofPairChain {
    //    Input: [[1,2], [2,3], [3,4]]
//    Output: 2
//    Explanation: The longest chain is [1,2] -> [3,4]
//    题目描述：对于 (a, b) 和 (c, d) ，如果 b < c，则它们可以构成一条链。


    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 ) return 0;
        Arrays.sort(pairs,(a,b) -> (a[0]) - b[0]);
        int[] len = new int[pairs.length];
        Arrays.fill(len,1);
        for (int i = 0; i < pairs.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]){
                    len[i] = Math.max(len[i],len[j]+1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < len.length ; i++) {
            if (len[i]>max){
                max = len[i];
            }
        }
        return max;

    }
}
