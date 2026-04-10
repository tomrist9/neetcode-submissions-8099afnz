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
    public int minMeetingRooms(List<Interval> intervals) {
       int j =0;
       int room=0;
       int reuse =0;
       int n = intervals.size();
 
                if (intervals == null || intervals.size() <= 0) return 0;
    int[] start = new int[n];
    int[] end = new int[n];

    for(int i=0;i<n; i++){
        start[i] = intervals.get(i).start;
        end[i]= intervals.get(i).end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
       for(int i=0;i<n; i++){
  if(start[i]<end[j]){
    room++;
  }else{
    j++;
  }
     
       }
       return room;
    }
}
