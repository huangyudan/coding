package sword;

public class Solution_42 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        boolean invalidInput = false;
        if (array==null || array.length<=0) {
            invalidInput = true;
            return 0;
        }
        int curSum = 0;
        int maxSum = 0x80000000;//32位int 的最小值，负2的32次方
        for (int i = 0; i < array.length; i++) {
            if (curSum<=0){
                curSum = array[i];
            }
            else{
                curSum += array[i];
            }
            if (curSum>maxSum) maxSum = curSum;
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int[] data = {-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray(data));
    }
}
