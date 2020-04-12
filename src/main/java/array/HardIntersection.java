package array;

import java.util.Arrays;

/**
 * 16.03. 交点
 * <p>
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * <p>
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 * 解二元一次方程。。
 */
public class HardIntersection {

    public static void main(String[] args) {
        int[] start1 = {1, 0};
        int[] end1 = {1, 1};
        int[] start2 = {-1, 0};
        int[] end2 = {3, 2};
        System.out.println(Arrays.toString(intersection(start1, end1, start2, end2)));
    }

    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] > end1[0]) {
            int[] temp = end1;
            end1 = start1;
            start1 = temp;
        } else {
            if (start1[0] == end1[0] && start1[1] > end1[1]) {
                int[] temp = end1;
                end1 = start1;
                start1 = temp;
            }
        }
        if (start2[0] > end2[0]) {
            int[] temp = end2;
            end2 = start2;
            start2 = temp;
        } else {
            if (start2[0] == end2[0] && start2[1] > end2[1]) {
                int[] temp = end2;
                end2 = start2;
                start2 = temp;
            }
        }

        double[] res = new double[2];
        if ((end1[0] - start1[0]) == 0 || (end2[0] - start2[0]) == 0) {
            if ((end1[0] - start1[0]) == 0 && (end2[0] - start2[0]) == 0) {
                if (start1[0] == start2[0]) {
                    double x1 = start1[0];
                    double y1 = start1[1] == start2[1] ? Math.min(end1[1], end2[1]) : Math.max(start1[1], start2[1]);
                    if ((y1 >= start2[1] && y1 <= end2[1]) && (y1 <= end1[1] && y1 >= start1[1])) {
                        res[0] = x1;
                        res[1] = y1;
                        return res;
                    }
                }
                return new double[0];
            } else {
                if ((end1[0] - start1[0]) == 0) {
                    double x1 = start1[0];
                    double k2 = (double) (end2[1] - start2[1]) / (end2[0] - start2[0]);
                    double b2 = end2[1] - k2 * end2[0];
                    double y1 = k2 * x1 + b2;
                    if ((y1 >= start1[1] && y1 <= end1[1])) {
                        res[0] = x1;
                        res[1] = y1;
                        return res;
                    }
                    return new double[0];
                } else {
                    double x1 = start2[0];
                    double k1 = (double) (end1[1] - start1[1]) / (end1[0] - start1[0]);
                    double b1 = end1[1] - k1 * end1[0];
                    double y1 = k1 * x1 + b1;
                    if ((y1 >= start2[1] && y1 <= end2[1])) {
                        res[0] = x1;
                        res[1] = y1;
                        return res;
                    }
                    return new double[0];
                }
            }
        }
        double k1 = (double) (end1[1] - start1[1]) / (end1[0] - start1[0]);
        double k2 = (double) (end2[1] - start2[1]) / (end2[0] - start2[0]);
        double b1 = end1[1] - k1 * end1[0];
        double b2 = end2[1] - k2 * end2[0];
        if (k1 == k2) {
            if (b1 == b2) {
                if (start2[0] > end1[0]) {
                    return new double[0];
                }
                int[] x = start1[0] == start2[0] ?
                        end1[0] > end2[0] ? end2 : end1 :
                        start1[0] > start2[0] ? start1 : start2;
                res[0] = x[0];
                res[1] = x[1];
                return res;
            }
            return new double[0];
        } else {
            double x1 = (b2 - b1) / (k1 - k2);
            double y1 = k1 * x1 + b1;
            if ((x1 >= start1[0] && x1 <= end1[0]) || (x1 >= start2[0] && x1 <= end2[0])) {
                res[0] = x1;
                res[1] = y1;
                return res;
            }
            return new double[0];
        }
    }

}
