class Solution {
    public static boolean isAnagram(String s1, String s2){
     
       

        if (s1.length() != s2.length()) return false;

        int[] charCount = new int[26];

        for (char c : s1.toCharArray()) {
            if (Character.isLetter(c)) {
                charCount[c - 'a']++;
            }
        }

        for (char c : s2.toCharArray()) {
            if (Character.isLetter(c)) {
                charCount[c - 'a']--;
            }
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }
}
