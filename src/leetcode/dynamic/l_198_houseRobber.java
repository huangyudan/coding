package leetcode.dynamic;

public class l_198_houseRobber {
//    题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
// 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量(第i个可以选择抢或不抢)。
// f（x） = max(nums[x]+f(x-2) , f(x-1))
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int pre1 = Math.max(nums[0],nums[1]);
        int pre2 = nums[0];
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = Math.max(pre2+nums[i],pre1);
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }



}

