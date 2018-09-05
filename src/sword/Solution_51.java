package sword;

public class Solution_51 {
    public static int InversePairs(int[] array){
        if (array==null || array.length==0) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);
        return count;
    }

    public static int InversePairsCore(int[] array,int[] copy,int low,int high){
        if (low==high) return 0;
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid);
        int rightCount = InversePairsCore(array,copy,mid+1,high);
        int count = 0;
        int i = mid,j = high;
        int locCopy = high;
        while (i>=low && j >=mid+1){
            if (array[i]>array[j]){
                count += j-mid;
                copy[locCopy--] = array[i--];
            }
            else{
                copy[locCopy--] = array[j--];
            }
        }
        for (;j>=mid +1;j--){
            copy[locCopy--] = array[j];
        }
        for (;i>=low;i--){
            copy[locCopy--] = array[i];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return leftCount+rightCount+count;
    }

    public static void main(String[] args){
        System.out.println(InversePairs(new int[]{7,5,6,4}));
        System.out.println(InversePairs(new int[]{5,6,7,8,1,2,3,4}));
    }


}

