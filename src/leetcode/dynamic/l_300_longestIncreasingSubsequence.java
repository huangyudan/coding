package leetcode.dynamic;

public class l_300_longestIncreasingSubsequence {
//    已知一个序列 {S1, S2,...,Sn} ，取出若干数组成新的序列 {Si1, Si2,..., Sim}，其中 i1、i2 ... im 保持递增，即新序列中各个数仍然保持原数列中的先后顺序，称新序列为原序列的一个 子序列 。
//    如果在子序列中，当下标 ix > iy 时，Six > Siy，称子序列为原序列的一个 递增子序列 。
// 用一个数组存放以第n个数结尾（必须）的递增子序列
// 还有更有的方法，找比你小的最大元素的时候因为是有序的所以可以二分，具体看github，最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int[] sequence = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sequence[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (nums[j] < nums[i]){
                    sequence[i] = Math.max(sequence[i],sequence[j]+1);
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = Math.max(ret, sequence[i]);
        }
        return ret;
    }
}
