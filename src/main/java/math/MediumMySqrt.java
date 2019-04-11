package math;

/**
 * Sqrt(x)
 * <p>
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MediumMySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {
        int s = 0, e = x;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if ((long) mid * mid > x) {
                e = mid;
            } else if (mid * mid == x) {
                return mid;
            } else {
                s = mid + 1;
            }
        }
        return (long)s * s > x ? s - 1 : s;
    }
}
