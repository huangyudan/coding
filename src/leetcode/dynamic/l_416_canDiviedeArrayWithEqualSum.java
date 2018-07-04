package leetcode.dynamic;

public class l_416_canDiviedeArrayWithEqualSum {
//    Input: [1, 5, 11, 5]
//
//    Output: true
//
//    Explanation: The array can be partitioned as [1, 5, 5] and [11].
//      sum/2 的背包问题,weight 和 value都是一个值nums[i]
//   这n个数重量不超过num/2的最大价值是不是num/2(如果存在和为num/2的，w = v，那么重量最大化就是价值最大化
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target_sum = sum / 2;
        int[][] bag = new int[nums.length+1][target_sum+1];
        for (int i = 1; i <= nums.length ; i++) {
            int w = nums[i-1];
            int v = nums[i-1];
            for (int j = 1; j <= target_sum ; j++) {
                if (w > j) bag[i][j] = bag[i-1][j];
                else bag[i][j] = Math.max(bag[i-1][j],bag[i-1][j-w] + v);
            }
        }
        return bag[nums.length][target_sum] == target_sum;

    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
