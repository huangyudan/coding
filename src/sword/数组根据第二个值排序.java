package sword;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 数组根据第二个值排序 {
    private static final int N = 100005;

    private static class node {
        int x, y;
    }

    private static class cmp implements Comparator<node> {
        @Override
        public int compare(node a, node b) {
            if (a.y == b.y) {
                if (a.x == b.x) return 0;
                return a.x < b.x ? -1 : 1;
            }
            return a.y < b.y ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            int[] task = new int[n];
            node s1[] = new node[n];
            for (int i = 0; i < n; i++) {
                s1[i] = new node();
            }
            for (int i = 0; i < n; i++) {
                s1[i].x = sc.nextInt();
                s1[i].y = sc.nextInt();
            }
            Arrays.sort(s1, 0, n, new cmp());
            task[0] = s1[0].x;
            int min = task[0];
            for (int j = 1; j < n; j++) {
                task[j] = Math.max(task[j - 1], s1[j].y) + s1[j].x;
                min += task[j];
            }

            System.out.println(min % 1000000007);
        }
        sc.close();
    }
}

