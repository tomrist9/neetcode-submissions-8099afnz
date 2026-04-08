class Solution {
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> state = new HashMap<>();
    StringBuilder result = new StringBuilder();
    public String foreignDictionary(String[] words) {
       for(String word : words){
        for(char c : word.toCharArray()){
            graph.putIfAbsent(c, new ArrayList<>());
            state.putIfAbsent(c, 0);
        }
       }

       for(int i=0; i<words.length-1; i++){
        String w1 = words[i];
        String w2 = words[i+1];

              if (w1.length() > w2.length() && w1.startsWith(w2)) {
            return "";
        }
        int len = Math.min(w1.length(), w2.length());
        for(int j =0; j<len; j++){
        if(w1.charAt(j)!=w2.charAt(j)){
            graph.get(w1.charAt(j)).add(w2.charAt(j));
            break;
        }
        }
       }
       for(char c : graph.keySet()){
        if(state.get(c)==0){
            if(
                !dfs(c)
            ){
                return "";
            }
        }
       }
        return result.reverse().toString();
       
    }

    private boolean dfs(char c){
        state.put(c, 1);

        for(char nb : graph.get(c)){
            if(state.get(nb)==1){
                return false;
            }
            if(state.get(nb)==0){
                if(!dfs(nb)){
                    return false;
                }
            }


        }

        state.put(c, 2);
        result.append(c);
        return true;
    }
}
