package leetcode.dataStructure.Stack_and_Queue;

import java.util.Stack;

public class l_232_queueUsingStacks {
    class MyQueue {

        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        private void in2out() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
