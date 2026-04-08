class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high = Arrays.stream(piles).max().getAsInt();
        int result = high;

        while(low<= high){
            int mid = low + (high - low)/2;
            int hours = totalHours(piles, mid);

            if(hours<=h){
                result = mid;
                high = mid-1;
                
            }else{
               low = mid +1;
            }
        }
        return result;
    }

    private int totalHours(int [] piles, int k){
        int hours =0;
        for(int pile : piles){
               hours += Math.ceil((double) pile / k);
        }
        return hours;
    }
}
