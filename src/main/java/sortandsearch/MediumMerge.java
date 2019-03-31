package sortandsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class MediumMerge {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        for (Interval in : merge(intervals)) {
            System.out.println(in.start + "," + in.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        //leetcode lambda写法慢40ms左右
        intervals.sort(new Comparator<Interval>() {
                 @Override
                 public int compare(Interval o1, Interval o2) {
                     return o1.start - o2.start;
                 }
             });
//        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        List<Interval> res = new ArrayList<>();
        Interval in = new Interval(intervals.get(0).start, intervals.get(0).end);
        res.add(in);
        for (int i = 1; i < intervals.size(); i++) {
            if (in.end >= intervals.get(i).start) {
                in.end = Math.max(in.end, intervals.get(i).end);
            } else {
                if (i < intervals.size()) {
                    in = new Interval(intervals.get(i).start, intervals.get(i).end);
                    res.add(in);
                }
            }
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
