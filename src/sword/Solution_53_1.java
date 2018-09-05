package sword;

public class Solution_53_1 {
    public static int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if (length==0) return 0;
        int firstK = getFirstK(array,k,0,length -1);
        int lastK = getLastK(array,k,0,length-1);
        if (firstK!=-1 && lastK!=-1) return lastK-firstK+1;
        return 0;
    }

    //递归写法
    public static int getFirstK(int[] array,int k,int start,int end){
        if (start>end) return -1;
        int mid = (end+start)>>1;
        if (array[mid]>k){
            return getFirstK(array,k,start,mid-1);
        }else if (array[mid]<k){
            return getFirstK(array,k,mid+1,end);
        }else if (mid-1>=start && array[mid-1]==k){
            return getFirstK(array,k,start,mid-1);
        }else {
            return mid;
        }
    }

    //循环写法
    public static int getLastK(int[] array,int k,int start,int end){
        int length = array.length;
        if (start>end) return -1;
        int mid = (start+end)>>1;
        while (start<=end){
            mid = (start+end)>>1;
            if (array[mid]>k){
                end = mid-1;
            }else if (array[mid]<k){
                start = mid + 1;
            }else if (mid+1<=end && array[mid+1]==k){
                start = mid + 1;
            }else{
                break;
            }
        }
        return mid;
    }

    public static void main(String[] args){
        int[] data1 = new int[]{1,2,3,3,3,3,5,6};
        int[] data2 = new int[]{1,2,3,3,3,3,4,5};
        int[] data3 = new int[]{3,3,3,3,3,3,3,3};
        System.out.println(GetNumberOfK(data1,4));
        System.out.println(GetNumberOfK(data2,3));
        System.out.println(GetNumberOfK(data3,3));
    }




}
