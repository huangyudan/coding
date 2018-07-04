package leetcode.dataStructure.HashTable;

import java.util.HashMap;
import java.util.Map;

public class l_128_最长连续子串的长度 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num,countForNum.getOrDefault(num,0)+1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()){
            longest = Math.max(longest,beginWith(countForNum,num));
        }
        return longest;
    }

    private int beginWith(Map<Integer, Integer> countForNum, int num) {
        int count = countForNum.get(num);
        while (countForNum.containsKey(num+1)){
            count+=countForNum.get(num+1);
        }
        return count;
    }
}
