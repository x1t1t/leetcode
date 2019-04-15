package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class MediumEvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (list.contains(s)) {
                if (s.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                }
                if (s.equals("-")) {
                    stack.push(-stack.pop() + stack.pop());
                }
                if (s.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                }
                if (s.equals("/")) {
                    Integer num = stack.pop();
                    stack.push(stack.pop() / num);
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
