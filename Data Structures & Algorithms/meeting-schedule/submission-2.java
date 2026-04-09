/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
     int i =0;
     int n = intervals.size();
    
         if (intervals == null || intervals.size() <= 1) return true;

    intervals.sort((a, b) -> a.start - b.start);
     Interval curr = intervals.get(0);
     for(i=1; i<n ; i++){
        Interval next = intervals.get(i);
        if(curr.end > next.start){
            return false;
        }else{
            curr=next;
        }
     }
     return true;
    }
     
}
