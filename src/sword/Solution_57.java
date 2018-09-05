package sword;

public class Solution_57 {
    public static int[] findNumbersWithSum(int[] data,int sum){
        int[] result = new int[]{0,0};
        if(data==null || data.length<2)
            return result;
        int curSum = data[0]+data[data.length-1];
        int left = 0,right = data.length-1;
        while (curSum!=sum && left<right){
            if(curSum>sum)
                right--;
            else
                left++;
            curSum = data[left]+data[right];
        }
        if(curSum==sum){
            result[0] = data[left];
            result[1] = data[right];
        }
        return result;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,4,7,11,15};
        int[] result = findNumbersWithSum(data,15);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
