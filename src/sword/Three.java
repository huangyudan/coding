package sword;

import java.util.Scanner;
import java.util.Stack;

public class Three {
    static String[][] numberMap = new String[][] {
            {"66666", "....6", "66666", "66666", "6...6", "66666", "66666", "66666", "66666", "66666"},
            {"6...6", "....6", "....6", "....6", "6...6", "6....", "6....", "....6", "6...6", "6...6"},
            {"6...6", "....6", "66666", "66666", "66666", "66666", "66666", "....6", "66666", "66666"},
            {"6...6", "....6", "6....", "....6", "....6", "....6", "6...6", "....6", "6...6", "....6"},
            {"66666", "....6", "66666", "66666", "....6", "66666", "66666", "....6", "66666", "66666"}
    };
    public static long calculate(String expr) {
        Stack<Long> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int begin = 0;
        int end = 0;
        int size = expr.length();
        for (int i = 0; i < size; ++i) {
            char temp = expr.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*') {
                end = i-1;
                long number = Long.parseLong(expr.substring(begin, end+1));
                begin = i+1;
                if (operators.size() > 0 && operators.peek() == '*') {
                    operators.pop();
                    long result = number * numbers.peek();
                    numbers.pop();
                    numbers.push(result);
                } else {
                    numbers.push(number);
                }
                operators.push(temp);
            }
        }
        long number = Long.parseLong(expr.substring(begin, size));
        if (operators.peek() == '*') {
            operators.pop();
            long result = number * numbers.peek();
            numbers.pop();
            numbers.push(result);
        }
        else {
            numbers.push(number);
        }
        int operatorSize = operators.size();
        long result = 0;
        for (int i = 0; i < operatorSize; ++i) {
            char oper = operators.pop();
            long add1 = numbers.pop();
            if (oper == '+') {
                result += add1;
            }
            else if (oper == '-') {
                result -= add1;
            }
        }
        return result + numbers.pop();
    }

    public static void printResult(String result) {
        int size = result.length();
        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < size; ++i) {
                int number = result.charAt(i) - '0';
                System.out.print(numberMap[j][number]);
                if (i < size - 1) {
                    System.out.print("..");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            String expression = in.next();
            long result = calculate(expression);
            printResult(String.valueOf(result));
        }
    }
}
