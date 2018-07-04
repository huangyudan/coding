package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l_347_topKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new List[nums.length+1] ;
        for (int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i > 0 && res.size()<k; i--) {
            if (bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
}
