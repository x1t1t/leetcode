package math;

/**
 * Divide Two Integers
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 */
public class MediumDivide {
    public static void main(String[] args) {
        System.out.println(divide(-1048958272, 336470323));
    }

    public static int divide(int dividend, int divisor) {
        boolean f = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            f = true;
        }
        //防止溢出
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);

        if (divisor1 > dividend1) return 0;
        long count = 0, num = 1, sum = divisor1, value = dividend1;
        while (sum <= dividend1) {
            value = dividend1 - sum;
            count = num;
            num += num;
            sum += sum;
        }
        if (count > Integer.MAX_VALUE && f) {
            return Integer.MAX_VALUE;
        }
        //divisor > 0 ? divisor : -divisor)为了保持同号
        return f ?
                (int) count + divide((int) value, divisor > 0 ? divisor : -divisor) :
                (int) -count + divide((int) value, divisor > 0 ? -divisor : divisor);
    }
}
