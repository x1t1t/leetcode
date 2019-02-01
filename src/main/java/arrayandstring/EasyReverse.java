package arrayandstring;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class EasyReverse {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) y;
    }
}
