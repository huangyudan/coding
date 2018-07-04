package leetcode.greedy;

public class l_665_modifyOneElementToIncreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0; //当出现比前面小的时候有两种选择，优先考虑nums[i - 1] = nums[i]，因为nums[i] = nums[i - 1]会使得
        //nums[i] 变大扰乱后面的，只有当nums[i - 2] > nums[i]的时候，才做后面一种选择
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1])
                continue;
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i])
                nums[i] = nums[i - 1];
            else
                nums[i - 1] = nums[i];
        }
        return cnt <= 1;
    }

}
