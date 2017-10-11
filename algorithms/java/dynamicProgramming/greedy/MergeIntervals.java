package dynamicProgramming.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/7.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        for(Interval itv : intervals) {
            int size = result.size();
            if(size > 0 && result.get(size - 1).end >= itv.start) {
                result.get(size - 1).end = Math.max(result.get(size - 1).end, itv.end);
            }
            else {
                result.add(itv);
            }
        }
        return result;
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
