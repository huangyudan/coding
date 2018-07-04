package leetcode.double_pointer;

import java.util.Arrays;
import java.util.HashSet;

public class l_345_reverseVowelsOfString {
    public static String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i<=j){
            if (!vowels.contains(s.charAt(i))){
                result[i] = s.charAt(i);
                i++;
            }
            else if (!vowels.contains(s.charAt(j))) {
                result[j] = s.charAt(j);
                j--;
            }else{
                result[i] = s.charAt(j);
                result[j] = s.charAt(i);
                i++;
                j--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
