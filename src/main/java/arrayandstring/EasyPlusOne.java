package arrayandstring;

import java.util.Arrays;

/**
 * Plus One
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class EasyPlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {

//        方法一：
//        int flag = 1;
//        int len = digits.length;
//        for (int i = len - 1; i >= 0; i--) {
//            int val = digits[i] + flag;
//            digits[i] = val % 10;
//            flag = val / 10;
//        }
//        if (flag > 0) {
//            int[] newDigits = new int[len + 1];
//            newDigits[0] = 1;
//            for (int i = 0; i < len; i++) {
//                newDigits[i + 1] = digits[i];
//            }
//            return newDigits;
//        }
//        return digits;

        int a = digits.length - 1;
        digits[a] += 1;
        while (a >= 0 && digits[a] > 9) {
            digits[a] = 0;
            a--;
            if (a < 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            } else {
                digits[a] += 1;
            }
        }
        return digits;
    }
}
