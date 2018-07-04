package leetcode.dataStructure.HashTable;

import java.util.HashSet;
import java.util.Set;

public class l_217_判断数组是否含有重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
