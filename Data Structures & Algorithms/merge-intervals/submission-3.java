class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[]curr = intervals[0];
        int i =0;
        List<int[]> result = new ArrayList<>();
       for( i=1; i<n; i++){
        int[] next = intervals[i];
        if(curr[1]>=next[0]){
            curr[1]=Math.max(curr[1], next[1]);
        }else if(
            curr[1]>next[1]){
                curr=next;
            }
        
        else{
            result.add(curr);
            curr=next;
        }
       
       }
       result.add(curr);
return result.toArray(new int[result.size()][]);
        
    
}}
