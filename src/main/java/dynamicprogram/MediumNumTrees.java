package dynamicprogram;

public class MediumNumTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    public static int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

}
