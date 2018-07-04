package leetcode.sort;

public class l_75_sortColors {
//    Input: [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//    题目描述：只有 0/1/2 三种颜色。

    public static void sortColors(int[] nums) {
//        int two=nums.length-1, zero=0,one = 0;
//        while (one < two) {
//            if (nums[one]==2){
//                swap(nums,one,two);
//                two--;
//            }else if (nums[one] == 0){
//                swap(nums,one,zero);
//                zero++;
//                one++;
//            }else{
//                one++;
//            }
//        }

        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0)
                swap(nums, ++zero, one++);
            else if (nums[one] == 2)
                swap(nums, --two, one);
            else
                ++one;
        }
        for (int i : nums){
            System.out.println(i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        sortColors(new int[]{1,2,0});
    }
}
