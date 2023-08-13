package array;

import java.util.Arrays;

public class MediumHIndex {

    public static void main(String[] args) {
        int[] citations = {1,0};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int len = citations.length;
        int h = 0, num = 0;
        for (int i = len - 1; i >= 0; i--) {
            num++;
            if (citations[i] >= num) {
                h = Math.max(h, num);
            } else {
                break;
            }
        }
        return h;
    }
}
