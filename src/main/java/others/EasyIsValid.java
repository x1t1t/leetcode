package others;

import java.util.Stack;

/**
 * Valid Parentheses
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class EasyIsValid {
    public static void main(String[] args) {
        System.out.println(isValid("{}()"));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ']':
                    if (!stack.empty() && stack.peek().equals('[')) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (!stack.empty() && stack.peek().equals('(')) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (!stack.empty() && stack.peek().equals('{')) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                default:
                    stack.push(s.charAt(i));

            }
        }
        return stack.empty();
    }
}
