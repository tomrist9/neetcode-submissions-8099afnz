class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();

      for(String word : strs){
        int[] freq = new int[26];

        for(char c : word.toCharArray()){
            freq[c -'a' ]++;
        }
            String key = Arrays.toString(freq);

            map.computeIfAbsent(key, k-> new ArrayList<>()).add(word);

        }

      
      
      return new ArrayList<>(map.values());
    }
  
}
