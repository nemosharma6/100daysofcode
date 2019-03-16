/**
 https://leetcode.com/problems/non-overlapping-intervals/
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new CustomComparator());
        int prev = intervals[0].end;
        int c = 1;        

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= prev) {
                prev = intervals[i].end;
                c++;
            }
        }
        
        return intervals.length - c;
    }
    
    class CustomComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
