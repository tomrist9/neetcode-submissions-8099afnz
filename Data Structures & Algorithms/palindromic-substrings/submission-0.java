class Solution {
    int count =0;
    public int countSubstrings(String s) {
        int start=0;
        int end=0;
        for(int i=0; i< s.length(); i++){
            int len1= expandAround(s, i ,i );
            int len2= expandAround(s, i, i+1);
            count= Math.max(len1, len2);
        }
            return count;
        }
    

    private int expandAround(String s, int left, int right){
        while(left>=0 && right < s.length()&& s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
