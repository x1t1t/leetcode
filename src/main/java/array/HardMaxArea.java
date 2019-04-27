package array;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class HardMaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        /**ideaI
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= 0) {
                continue;
            }
            int k = i - 1 - max / height[i];
            while (k >= 0) {
                max = Math.max(max, (i - k) * Math.min(height[i], height[k]));
                k--;
            }
        }
        return max;*/

        /**ideaII*/
        for (int i = 0, j = height.length - 1; i < height.length; ) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[j] < height[i]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
