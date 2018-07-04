package leetcode.binary_search;

public class l_34_searchForRange {
    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m,left,right;
        while(l <= h){
            m = l + (h - l) / 2;
            if (nums[m] == target){
                left = m;
                right = m;
                while (left >= 0 && nums[left]== target) left--; //这个&&的顺序不能错，不然会index报错！！！！！
                while (right <= h && nums[right]== target ) right++;
                return new int[]{left + 1,right - 1};
            }
            else if (nums[m] > target) h = m - 1;
            else if (nums[m] < target) l = m + 1;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,7,7,8,8,10};
        int[] b = searchRange(a,8);
    }
}
