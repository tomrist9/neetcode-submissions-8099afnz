class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }

        }
        return maxLength;
    }
}
