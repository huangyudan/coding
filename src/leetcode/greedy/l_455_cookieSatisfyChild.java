package leetcode.greedy;

import java.util.Arrays;

public class l_455_cookieSatisfyChild {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        int satisfy = 0;
        while (sIndex < s.length && gIndex < g.length) {
            if (sIndex < s.length && gIndex < g.length && s[sIndex] < g[gIndex]) {
                sIndex++;
            }
            if (sIndex < s.length && gIndex < g.length && s[sIndex] >= g[gIndex]) {
                satisfy++;
                sIndex++;
                gIndex++;
            }

        }
        return satisfy;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3}; //小孩需要的满足度
        int[] s = new int[]{1,1}; //饼干能满足小孩的程度
        System.out.println(findContentChildren(g,s));
    }
}
