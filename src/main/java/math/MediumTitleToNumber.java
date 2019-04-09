package math;

/**
 * Excel Sheet Column Number
 * <p>
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class MediumTitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return num;
    }
}
