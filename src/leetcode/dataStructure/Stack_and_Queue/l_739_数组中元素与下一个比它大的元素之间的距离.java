package leetcode.dataStructure.Stack_and_Queue;

//Input: [73, 74, 75, 71, 69, 72, 76, 73]
//        Output: [1, 1, 4, 2, 1, 1, 0, 0]
//在遍历数组时用 Stack 把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数就是当前元素

import java.util.Stack;

public class l_739_数组中元素与下一个比它大的元素之间的距离 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < n ; i++) {
            while (!index.isEmpty() && temperatures[i]>temperatures[index.peek()]){
                int pre_index = index.pop();
                dist[pre_index] = i - pre_index;
            }
            index.add(i);

        }
        return dist;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
