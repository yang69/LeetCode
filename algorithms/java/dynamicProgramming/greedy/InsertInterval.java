package dynamicProgramming.greedy;

import java.util.List;

/**
 * Created by Yang on 2017/10/7.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        // 早于newInterval开始之前结束的都不可能与newInterval重叠
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }
        // 将所有早于newInterval结束前开始的间隔与newInterval进行合并
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end)
            );
            intervals.remove(i);
        }
        // 将合并后的间隔插入到合适位置
        intervals.add(i, newInterval);

        return intervals;
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
