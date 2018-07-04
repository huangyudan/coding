package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

class interval {
      int start;
      int end;
      interval() { start = 0; end = 0; }
      interval(int s, int e) { start = s; end = e; }
  }


public class l_435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(interval[] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        int count = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i].start < end) continue;
            else{
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}
