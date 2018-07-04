package sword;

public class Solution_33 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null)   return false;
        if(sequence.length==0)
            return false;
        if(sequence.length==1) return true;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public static boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
        if (end-start<=1) return true;
        int root = sequence[end];
        int i = start;
        for (;i<end;i++){
            if (sequence[i]>root) break;
        }
        for (int j = i;j<end;j++){
            if (sequence[j]<root) return false;
        }
        boolean left = true;
        left = VerifySquenceOfBST(sequence,start,i-1);
        boolean right = true;
        right = VerifySquenceOfBST(sequence,i,end-1);
        return left&&right;
    }


    public static void main(String[] args){
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5,7,6,9,4,10,8};
        int[] data1 = {5,7,6,9,11,10,8};
//        System.out.println(VerifySquenceOfBST(data));
        System.out.println(VerifySquenceOfBST(data1));
    }


}
