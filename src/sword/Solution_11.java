package sword;

import java.util.ArrayList;
public class Solution_11 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1; //如果移动了0个元素的话，不满足while直接返回
        while (array[index1] >= array[index2]){
            if (index2 - index1 == 1){
                mid = index2;
                break;
            }

            mid = (index1 + index2) /2 ;
            if (array[mid]>=array[index1] && array[mid]<=array[index2]){
                return MinInOrder(array,index1,index2);
            }
            if (array[mid]>=array[index1]) index1 = mid;
            else if (array[mid]<=array[index2]) index2 = mid;
        }
        return array[mid];
    }
    
    public int MinInOrder(int[] array,int index1,int index2){
        int result = array[index1];
        for (int i = index1+1;i<=index2;i++){
            if (array[i]<result){
                result = array[i];
            }
        }
        return result;
    }
    

    
}