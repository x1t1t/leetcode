package string;

import java.util.*;

/**
 * Basic Calculator II
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
public class HardCalculate {
    public static void main(String[] args) {
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        List<Character> list1 = Arrays.asList('+', '-', '*', '/');
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (list1.contains(s.charAt(i))) {
                    list.add(s1.toString());
                    list.add(String.valueOf(s.charAt(i)));
                    s1 = new StringBuilder();
                } else {
                    s1.append(s.charAt(i));
                }
            }
        }
        if (s1.length() > 0) list.add(s1.toString());
        if (list.size() == 1) return Integer.parseInt(list.get(0));
        stack.push(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                int a = Integer.parseInt(stack.pop()), b = 0;
                b = Integer.parseInt(list.get(i + 1));
                if (list.get(i).equals("*")) {
                    stack.push(String.valueOf(a * b));
                } else {
                    stack.push(String.valueOf(a / b));
                }
                i++;
            } else {
                stack.push(list.get(i));
            }
        }
        if (stack.size() == 1) return Integer.parseInt(stack.pop());
        List<String> list2 = new ArrayList<>();
        while (!stack.empty()) {
            list2.add(stack.pop());
        }
        int res = Integer.parseInt(list2.get(list2.size() - 1));
        for (int i = list2.size() - 2; i >= 0; i--) {
            if (list2.get(i).equals("+")) {
                res += Integer.parseInt(list2.get(--i));
            } else {
                res -= Integer.parseInt(list2.get(--i));
            }
        }
        return res;
    }
}
