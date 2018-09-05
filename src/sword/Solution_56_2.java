package sword;

public class Solution_56_2 {
    public static int singleNumber(int A[]) {
        int bit_time[] = new int[32];
        int i = 0;
        int j = 0;
        int result = 0;
        for(i = 0; i < 32; i++){
            for(j = 0; j < A.length; j++){
                bit_time[i] += (A[j] >> i) & 0x01;//>>i把当前位的值移动到了最后，&是取这一位的值
            }
            result |=  (bit_time[i] % 3) << i;  //result所有位都是0 |
        }
        return result;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,4,3,3,2,5,5,2,3,5};
        int result = singleNumber(data);
        System.out.println(result);

    }
}
