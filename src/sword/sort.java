package sword;

public class sort {
    //稳定
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length-1 ; j++) {
                if (a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }
    //不稳定 序列5 8 5 2 9，5会和2交换
    public static void selectionSort(int[] a){
        int min;
        for (int i = 0; i <a.length; i++) {
            min = i;
            for (int j = i+1; j <a.length ; j++) {
                if (a[j]<a[min]) min=j;
            }
            swap(a,i,min);
        }
    }
    //稳定
    public static void insertSort(int[] a){
        for (int i = 1; i <a.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if (a[j]<a[j-1]) swap(a,j,j-1);
            }
        }
    }

    //稳定
    public static void mergeSort(int[] a,int s,int e){
        int[] aux = new int[a.length];
        if (s>=e) return;
        int mid = (s+e)/2;
        mergeSort(a,s,mid);
        mergeSort(a,mid+1,e);
        merge(a,aux,s,mid,e);
    }

    public static void merge(int[] a, int[] aux, int s, int mid, int e) {
        for (int i = 0; i < a.length ; i++) {
            aux[i] = a[i];
        }
        int i = s,j=mid+1;
        for (int k = s; k <= e; k++) {
            if (i>mid) a[k]=aux[j++];
            else if(j>e) a[k]=aux[i++];
            else if(aux[i]<=aux[j]) a[k]=aux[i++];
            else a[k]=aux[j++];
        }
    }

    public static void quickSort(int[] a,int s,int e){
        if (s>=e) return;
        int index = partition(a,s,e);
        quickSort(a,s,index-1);
        quickSort(a,index+1,e);
    }

    public static int partition(int[] a, int s, int e) {
        int base = a[s];
        int i=s,j=e+1;
        while(true){
            while(a[++i]<=base) if (i==e) break;
            while(a[--j]>=base) if (j==s) break;
            if(i>=j) break;
            swap(a,i,j);
        }
        swap(a,s,j);
        return j;
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] to_be_sorted = new int[]{5,1,7,4,5,3,8,1};
//        bubbleSort(to_be_sorted);
//        selectionSort(to_be_sorted);
//        insertSort(to_be_sorted);
//        mergeSort(to_be_sorted,0,to_be_sorted.length-1);
        quickSort(to_be_sorted,0,to_be_sorted.length-1);
        for (int i: to_be_sorted) {
            System.out.print(i+"-");
        }
    }
}
