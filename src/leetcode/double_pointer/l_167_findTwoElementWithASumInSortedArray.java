package leetcode.double_pointer;

public class l_167_findTwoElementWithASumInSortedArray {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j){
            if (numbers[i]+numbers[j] == target) return new int[]{i,j};
            else if (numbers[i]+numbers[j] > target) j--;
            else i++;
        }
        return null;
    }

    public static void main(String[] args) {
        for(int i : twoSum(new int[]{2,7,11,15},9)){
            System.out.println(i);
        }
    }
}
