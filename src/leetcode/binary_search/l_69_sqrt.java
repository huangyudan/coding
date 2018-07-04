package leetcode.binary_search;

public class l_69_sqrt {
    public static int sqrt_with_bs(int x) {
        if (x < 1) return 0;
        if (x == 1) return 1;
        int l = 1;
        int h = x;
        int m;
        while (l <= h){
            //别用乘法乘法会溢出
            m = l + (h - l) / 2;
            int divide = x / m;
            if (divide == m) return m;
            else if(divide < m ) h = m - 1;
            else if (divide > m ) l = m + 1;
        }
        return h;
    }
    public static void main(String[] args){
        System.out.println(sqrt_with_bs(8));
    }
}
