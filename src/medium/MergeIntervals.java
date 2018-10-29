package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> test = new ArrayList<>();
        test.add(new Interval(4,5));
        test.add(new Interval(1,4));
        new MergeIntervals().merge(test);
    }

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1)
            return intervals;

        // 排序, comparator比lambda要快很多，y？
//        Collections.sort(intervals, Comparator.comparing((Interval i) -> i.start));
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> res = new ArrayList<>();

        // 假设所有都是非负数
        Interval last = intervals.get(0);
        int start, end;

        for (Interval i: intervals) {
            if (i.start > last.end){
                res.add(last);
                last = i;
            }else {
                last.end = Math.max(i.end, last.end);
            }
        }

        if (res.isEmpty() || res.get(res.size() - 1) != last)
            res.add(last);

        return res;
    }



}
//Definition for an interval.
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