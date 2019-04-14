package math;

/**
 * Sum of Two Integers
 * <p>
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class MediumGetSum {
    public static void main(String[] args) {
        System.out.println(getSum(2, 3));
    }

    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            //&获得进位值，<<1是放到正确的位置
            int carry = a & b;
            //^是求和后位置的值
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
