package leetcode.double_pointer;
//Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]
//        题目描述：把归并结果存到第一个数组上。


public class l_88_onsiteMergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i>=0 || j>=0){
            if (i<0){
                nums1[index] = nums2[j--];
            }else if(j<0){
                nums1[index] = nums1[i--];
            }else if (nums1[i]<nums2[j]){
                nums1[index] = nums2[j--];
            }else {
                nums1[index] = nums1[i--];
            }
            index--;
        }

    }
}
