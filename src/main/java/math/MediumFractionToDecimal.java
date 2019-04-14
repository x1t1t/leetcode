package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Fraction to Recurring Decimal
 * <p>
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 */
public class MediumFractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(Integer.MIN_VALUE, -1));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }
        long numerator1 = Math.abs((long) numerator);
        long denominator1 = Math.abs((long) denominator);
        if (numerator1 % denominator1 == 0) {
            return sb.append(numerator1 / denominator1).toString();
        }
        sb.append(numerator1 / denominator1).append(".");
        long num = numerator1 % denominator1, index = 0;
        while (num != 0) {
            if (list.contains(num)) {
                sb.insert((int) (sb.length() - index + list.indexOf(num)), "(");
                sb.append(")");
                break;
            }
            list.add(num);
            num *= 10;
            sb.append(num / denominator1);
            num %= denominator1;
            index++;
        }
        return sb.toString();
    }
}
