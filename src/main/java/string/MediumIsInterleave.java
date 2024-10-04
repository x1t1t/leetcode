package string;

public class MediumIsInterleave {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        if (l3 != l1 + l2) {
            return false;
        }

//        return interleave(s1, s2, s3, 0 ,0 ,0);

        boolean[][] res = new boolean[l1 + 1][l2 + 1];
        res[0][0] = true;
        for (int i1 = 0; i1 <= l1; i1++) {
            for (int i2 = 0; i2 <= l2; i2++) {
                if (i1 > 0) {
                    res[i1][i2] = res[i1][i2] || res[i1 - 1][i2] && s1.charAt(i1-1) == s3.charAt(i1 + i2 - 1);
                }
                if (i2 > 0) {
                    res[i1][i2] = res[i1][i2] || res[i1][i2-1] && s2.charAt(i2-1) == s3.charAt(i1 + i2 - 1);
                }
            }
        }
        return res[l1][l2];
    }

    //此法超时
    public static boolean interleave(String s1, String s2, String s3, int i1, int i2, int i3) {
        if (i3 >= s3.length()) {
            return true;
        }
        boolean a = false, b = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            a = interleave(s1, s2, s3, i1 + 1, i2, i3 + 1);
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            b = interleave(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }
        return a || b;
    }

}
