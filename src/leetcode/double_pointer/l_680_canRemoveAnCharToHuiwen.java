package leetcode.double_pointer;

public class l_680_canRemoveAnCharToHuiwen {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j)
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            else {
                i++;
                j--;
            }

        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
