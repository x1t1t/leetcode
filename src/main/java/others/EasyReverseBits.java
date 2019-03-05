package others;

/**
 * Reverse Bits
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class EasyReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int j = n & 1;
            result <<= 1;
            result += j;
            n>>=1;
        }
        return result;
    }
}
