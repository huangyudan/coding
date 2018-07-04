package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class l_763_partitionStringtoMostNonRepeatedParts {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() <= 0) return res;
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i > end){
                res.add(end - start + 1);
                start = i;
            }
            if (S.lastIndexOf(S.charAt(i)) > end){
                end = S.lastIndexOf(S.charAt(i));
            }
        }
        res.add(end - start + 1);
        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> a = partitionLabels(S);
    }
}
