package leetcode.BFS;

import java.util.*;

public class l_127_wordLadder {
//    Input:
//    beginWord = "hit",
//    endWord = "cog",
//    wordList = ["hot","dot","dog","lot","log","cog"]
//
//    Output: 5
//
//    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//            return its length 5.
//    Input:
//    beginWord = "hit"
//    endWord = "cog"
//    wordList = ["hot","dot","dog","lot","log"]
//
//    Output: 0
//
//    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
//    题目描述：要找出一条从 beginWord 到 endWord 的最短路径，每次移动规定为改变一个字符，并且改变之后的字符串必须在 wordList 中。

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord))
            end++;
        if (end == N)
            return 0;
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private static List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (isConnect(wordList.get(i), wordList.get(j)))
                    graphic[i].add(j);
            }
        }
        return graphic;
    }

    private static boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diffCnt++;
        }
        return diffCnt == 1;
    }

    private static int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end)
                        return path;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        //String[] a = new String[]{"hot","dot","dog","lot","log","cog"};
        wordList.addAll( Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}) );
        ladderLength(beginWord,endWord,wordList);
    }
}
