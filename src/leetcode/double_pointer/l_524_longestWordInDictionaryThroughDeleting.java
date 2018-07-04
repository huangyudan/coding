package leetcode.double_pointer;

import java.util.List;

//Input:
//        s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//        Output:
//        "apple"
public class l_524_longestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d){
            int l1 = target.length();
            int l2 = longestWord.length();
            if (l1 < l2 || (l1==l2 && longestWord.compareTo(target)<0)) continue;
            if(isValid(s,target)){
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isValid(String s, String target) {
        int i = 0;
        for (int j = 0; j < s.length() ; j++) {
            if (i==target.length()) break;
            if (s.charAt(j) == target.charAt(i)) i++;
        }
        return i==target.length();
    }

    public static void main(String[] args) {
        System.out.println("b".compareTo("a"));
    }
}
