package leetcode.dataStructure.Array;

import java.lang.reflect.Array;
import java.util.*;

public class l_1_TwoSum {
//    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.

//    这道题有两种思路：
//            1. 一种思路是先排序，从首尾搜索两个数的和，并逐步逼近。 nlog(n)
//            2. 另外一种思路是固定一个数A，看SUM-A是否在这个数组之中。 n + n


    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]), i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }
}
