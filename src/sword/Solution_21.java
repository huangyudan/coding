package sword;

/**
 * Created by ryder on 2017/7/14.
 * 调整数组顺序使奇数位于偶数前面 注释掉的是不需要保证不改变顺序的
 */
public class Solution_21 {
    // public static void reorder(int[] data){
    //     if(data==null||data.length<2)
    //         return;
    //     int left=0,right=data.length-1;
    //     while(left<right){
    //         // while (left<right&&!isEven(data[left]))
    //         //     left++;
    //         // while (left<right&&isEven(data[right]))
    //         //     right--;
    //         if (!isEven(data[left]))
    //             left++;
    //         if (isEven(data[right]))
    //             right--;
    //         if(left<right){
    //             int temp=data[left];
    //             data[left]=data[right];
    //             data[right]=temp;
    //         }
    //     }
    // }



    /**
      * 1.要想保证原有次序，则只能顺次移动或相邻交换。
      * 2.i从左向右遍历，找到第一个偶数。
      * 3.j从i+1开始向后找，直到找到第一个奇数。
      * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
      * 5.終止條件：j向後遍歷查找失敗。
      */
    public static void reorder(int [] array) {
        if (array==null || array.length<2) return;
        int count = 0;
        int next_jishu=0;
        for (int i = 0;i<array.length;i++){
            if (isEven(array[i])){
                if (count==0) next_jishu = i+1;
                for (int j=next_jishu;j<array.length;j++){
                    if (!isEven(array[j])){
                        count++;
                        next_jishu = j+1;
                        int t = array[j];
                        for (int m = j-1;m>=i;m--){
                            array[m+1] = array[m];
                        }
                        array[i] = t;
                        break;
                    }

                }
            }
        }

    }

    public static boolean isEven(int n){
        return (n&1)==0;
    }
    public static void main(String[] args){
        int[] data = {1,3,5,7,2,4,6};
        reorder(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}


