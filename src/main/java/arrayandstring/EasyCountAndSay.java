package arrayandstring;

/**
 * Count and Say
 * <p>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 */
public class EasyCountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String num = "1";
        for (int i = 1; i < n; i++) {
            num = handleNum(num);
        }
        return num;
    }

    private static String handleNum(String num) {
        StringBuilder newNum = new StringBuilder();
        int c = 1;
        if (num.length() == 1) {
            return 1 + num;
        }
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                c++;
            } else {
                newNum = newNum.append(c).append(num.charAt(i - 1));
                c = 1;
            }
            if (i == num.length() - 1)
                newNum = newNum.append(c).append(num.charAt(i));
        }
        return newNum.toString();
    }
}
