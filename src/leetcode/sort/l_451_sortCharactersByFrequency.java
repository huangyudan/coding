package leetcode.sort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class l_451_sortCharactersByFrequency {

//
//            "tree"
//
//    Output:
//            "eert"
//
//    Explanation:
//            'e' appears twice while 'r' and 't' both appear once.
//            So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()){
            if (frequencyMap.containsKey(c)){
                frequencyMap.put(c,frequencyMap.get(c) + 1);
            }else {
                frequencyMap.put(c , 1);
            }
        }
        List<Character>[] bucket = new List[s.length()+1];
        for (char c : frequencyMap.keySet()){
            int frequency = frequencyMap.get(c);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(c);
        }
        StringBuilder r = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0 ; i--) {
            if (bucket[i] != null){
                for (char c : bucket[i]){
                    for (int j = 0; j < i; j++) {
                        r.append(c);
                    }
                }
            }
        }
        return r.toString();
    }
}

