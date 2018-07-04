package leetcode.binary_search;

//如果你出现了赋值l,h没有在m上加减的操作，循环条件肯定要变成<,不然会死循环，而且跳出循环不代表成功了，要在调用函数的地方检察
//找什么小于啥的最大，大于啥的最小，大胆的写m加减1，条件还是l <= h ，最后不是return l就是return h，自己验证一下

public class binarySearch {
    //无重复元素
    public static int binary_search(int[] a , int target){
        int l = 0;
        int h = a.length - 1;
        int m;
        while (l <= h){
            m = l + (h - l) / 2;
            if (a[m] == target) return m;
            else if (a[m] > target) h = m - 1;
            else if (a[m] < target) l = m + 1;
        }
        return -1;
    }

    //有重复元素找最左边的
    public static int binary_left_search(int[] a , int target){
        int l = 0;
        int h = a.length - 1;
        int m;
        while (l < h){
            m =  l + (h - l) / 2;
            if (a[m] >= target) h = m;
            else l = m + 1;
        }
        return l;
    }



    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,6,8,9};
        System.out.println(binary_search(a,8));
        a = new int[]{1,2,8,8,8,8,8,8,8,9};
        int target = 10;
        if (a[binary_left_search(a,target)] == target){
           System.out.println(binary_left_search(a,target));
        }else{
            System.out.println("not found");
        }

    }
}
