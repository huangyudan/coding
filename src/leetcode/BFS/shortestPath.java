package leetcode.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPath {
//    在程序实现 leetcode.BFS 时需要考虑以下问题：
//    队列：用来存储每一轮遍历得到的节点；
//    标记：对于遍历过的节点，应该将它标记，防止重复遍历。

    public int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                for (int[] d : direction) {
                    Pair<Integer, Integer> next = new Pair(cur.getKey() + d[0], cur.getValue() + d[1]);
                    if (next.getKey() < 0 || next.getValue() >= m || next.getKey() < 0 || next.getValue() >= n)
                        continue;
                    grids[next.getKey()][next.getValue()] = 0; // 标记
                    if (next.getKey() == tr && next.getValue() == tc)
                        return pathLength;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
