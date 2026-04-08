class Solution {
    public boolean isPalindrome(String s) {
     if(s==null) return false;
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
         while(left <right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }
        char L = Character.toLowerCase(s.charAt(left));
        char R = Character.toLowerCase(s.charAt(right));
        if(L!=R)
            return false;
        
        left++;
        right--;
    }
    return true;
}
}
