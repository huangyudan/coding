package leetcode.dataStructure.HashTable;


//Input: [1,3,2,2,5,2,3,7]
//        Output: 5
//        Explanation: The longest harmonious subsequence is [3,2,2,2,3].
//        和谐序列中最大数和最小数只差正好为 1，应该注意的是序列的元素不一定是数组的连续元素。


import java.util.HashMap;
import java.util.Map;

public class l_594_最长和谐序列 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> dict = new HashMap<>();
        for (int num :nums){
            dict.put(num,dict.getOrDefault(num,0)+1);
        }
        int longest = 0;
        for (int num : dict.keySet()){
            if (dict.containsKey(num+1)){
                longest = Math.max(longest,dict.get(num) + dict.get(num+1));
            }
        }
        return longest;
    }

}
