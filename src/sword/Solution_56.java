package sword;

public class Solution_56 {
    public static int[] findNumsAppearOnce(int[] data){
        int ret[] = new int[]{0,0};
        if(data==null ||data.length<2)
            return ret;
        int result = 0;
        for (int i = 0; i < data.length ; i++) {
            result ^= data[i];
        }
        int indexOf1 = findFirstBit1(result);

        for (int i = 0; i < data.length ; i++) {
            if (isBit(data[i],indexOf1)){
                ret[0] ^= data[i];
            }else {
                ret[1] ^= data[i];
            }
        }
        return ret;

    }

    public static int findFirstBit1(int num){
        int index = 0;
        while ((num&1)==0){
            num = num>>1;
            index++;
        }
        return index;
    }

    public static boolean isBit(int num,int indexBit){
        num = num>>indexBit;
        return (num&1)==1;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        int[] result = findNumsAppearOnce(data); // 4,6
        System.out.println(result[0]);
        System.out.println(result[1]);

    }


}
