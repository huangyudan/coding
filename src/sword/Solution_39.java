package sword;

import java.util.Dictionary;

public class Solution_39 {
    public static int MoreThanHalfNum_Solution(int [] nums) {
        int result = 0;
        int count = 1;
        if (nums.length == 0)
            return -1;
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
                continue;
            }
            if (result == nums[i])
                count++;
            else
                count--;
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==result){
                count++;
            }
            if (count>nums.length/2) return result;
        }
        return 0;
    }



    public static int Partition(int[] nums,int start,int end){
        int pivotkey = nums[start];
        int origin = start;
        while(start<end){
            while(start<end&&nums[end]>=pivotkey) end--;
            while(start<end&&nums[start]<pivotkey) start++;
            swap(nums,start,end);
        }
        swap(nums,start,end);
        swap(nums,origin,end);
        return end;
    }

    public static int[] swap(int[] ints, int x, int y) {
        int temp = ints[x];
        ints[x] = ints[y];
        ints[y] = temp;
        return ints;
    }

    public static int MoreThanHalf(int[] nums){
        if(nums.length==0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        int index = Partition(nums, start, end);
        int mid = nums.length/2;
        while(index!=mid){
            if(index>mid)
                //如果调整数组以后获得的index大于middle，则继续调整start到index-1区段的数组
                index = Partition(nums, start, index-1);
            else{
                //否则调整index+1到end区段的数组
                index = Partition(nums, index+1, end);
            }
        }
        return nums[index];
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,2,2,2,5,4,2};
//        int[] test = new int[]{1};
        int n = MoreThanHalfNum_Solution(test);
        int m = MoreThanHalf(test);
        System.out.println(n);
        System.out.println(m);
    }
}
