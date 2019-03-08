/**
 https://leetcode.com/problems/merge-intervals/
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    public class CustomComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        
        if(intervals.size() == 0 || intervals.size() == 1)
            return intervals;
        
        Collections.sort(intervals, new CustomComparator());
        List<Interval> sol = new ArrayList();
        
        while(true) {
            if(intervals.size() == 0) break;
            Interval tmp = intervals.get(0);
            intervals.remove(0);
            while(true){
                if(intervals.size() == 0) break;
                Interval next = intervals.get(0);
                if(tmp.end >= next.start){
                    tmp.end = Math.max(tmp.end, next.end);
                    intervals.remove(0);
                } else
                    break;
            }
            
            sol.add(tmp);
        }
        
        return sol;
    }
}
