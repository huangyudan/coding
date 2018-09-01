package Basic;

public class MergeSort {
    public static void mergesort(int[] a,int lo,int hi){
        if (hi<=lo) return;
        int len = a.length;
        int mid = lo + (hi-lo)/2;
        mergesort(a,lo,mid);
        mergesort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(int[] a,int lo,int mid, int hi){
        if (hi<=lo) return;
        int[] aux = new int[a.length];
        for (int i = lo; i <=hi ; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <=hi ; k++) {
            if (i>mid) {
                a[k] = aux[j++];
            }
            else if (j>hi){
                a[k] = aux[i++];
            }

            else if (aux[i]<=aux[j]) {
                a[k] = aux[i];
                i++;
            }
            else {
                a[k] = aux[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,2,7,3,2,5,9,1};
        mergesort(a,0,a.length-1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
