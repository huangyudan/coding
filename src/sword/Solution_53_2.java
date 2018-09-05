package sword;

public class Solution_53_2 {
    public static int getMissingNumber(int[] data){
        int left = 0,right = data.length-1,mid;
        while (left<=right){
            //mid=left+(right-left)/2 用位运算替换除法
            //注意加减法优先级高于位运算
            mid = left+((right-left)>>1);
            if (data[mid]!=mid){
                if (mid==0 ||data[mid-1]==mid-1) return mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] data1 = new int[]{0,1,2,3,4,5}; //6
        int[] data2 = new int[]{0,1,3,4,5}; //2
        int[] data3 = new int[]{1,2}; //0
        System.out.println(getMissingNumber(data1));
        System.out.println(getMissingNumber(data2));
        System.out.println(getMissingNumber(data3));
    }


}
