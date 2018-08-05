package leetcode.dataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//Note:The solution set must not contain duplicate triplets.
//解决方法就是最外层遍历一遍，等于选出一个数，
//        之后的数组中转化为找和为target-nums[i]的2SUM问题。
//        因为此时排序复杂度在3SUM问题中已经不占据主要复杂度了，所以直接采用双指针的方法就好。

public class l_15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) return res;
        for (int i = 0; i < nums.length-2 ; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int target = 0-nums[i];
            int low = i++;
            int high = nums.length-1;
            while (low<high){
                if ((nums[low] + nums[high])==target){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low]==nums[low+1]) low++;
                    while(low < high && nums[high]==nums[high-1]) high--;
                    low++;
                    high--;
                }else if ((nums[low] + nums[high])<target){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }

}


