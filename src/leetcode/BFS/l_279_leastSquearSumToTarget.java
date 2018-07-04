package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l_279_leastSquearSumToTarget {
    //不会做~~~~~~~~~~~~~~
    //生成平方数的那个函数好巧妙啊！
//    For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
//    可以将每个整数看成图中的一个节点，如果两个整数只差为一个平方数，那么这两个整数所在的节点就有一条边。
//
//    要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
//
//    本题也可以用动态规划求解，在之后动态规划部分中会再次出现。


    public static int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int num = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            num++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0)
                        break;
                    if (next == 0)
                        return num;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(cur - s);
                }
            }
        }
        return n;
    }

    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
