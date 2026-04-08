class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[]curr = intervals[0];
        int i =0;
       int res=0;
       for( i=1; i<n; i++){
        int[] next = intervals[i];
        if(curr[1]>next[0]){
           res++;
        
        if(
            curr[1]>next[1]){
                curr=next;
            }
       }
        else{
           
            curr=next;
        }
       }
       
       return res;
    
}}

