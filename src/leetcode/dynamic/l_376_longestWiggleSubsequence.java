package leetcode.dynamic;

public class l_376_longestWiggleSubsequence {
//    Input: [1,7,4,9,2,5]
//    Output: 6
//    The entire sequence is a wiggle sequence.
//
//            Input: [1,17,5,10,13,15,10,5,16,8]
//    Output: 7
//    There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
//
//    Input: [1,2,3,4,5,6,7,8,9]
//    Output: 2
// up[i] 代表以第i个为end的前面 最后一个上身的最长的摇摆序列长度,down则相反 如果i大于i-1 up[i] = down[i-1] + 1 ，否则 up[i] = up[i-1]
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 1) return 0;
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n ; i++) {
            if (nums[i]>nums[i-1]){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }
            else if (nums[i] < nums[i - 1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }
}
