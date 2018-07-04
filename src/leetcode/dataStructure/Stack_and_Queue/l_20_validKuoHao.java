package leetcode.dataStructure.Stack_and_Queue;

//"()[]{}"
//
//        Output : true
// 重点在if (stack.isEmpty()) return false; 和 最后的return
import java.util.Stack;

public class l_20_validKuoHao {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else{
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                boolean b1 = c == ')' && t != '(';
                boolean b2 = c == ']' && t != '[';
                boolean b3 = c == '}' && t != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
