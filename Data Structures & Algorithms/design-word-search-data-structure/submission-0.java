class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

    }
    private final TrieNode root;
    public WordDictionary() {
      root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx]== null){
                node.children[idx]=new TrieNode();
            }
            node = node.children[idx];
        }
       node.isEndOfWord=true;
    }

    public boolean search(String word) {
    
     return dfs(word, 0, root);
    }


    private boolean dfs(String word, int index, TrieNode node){
        if(index==word.length()){
           return node.isEndOfWord;
        }
        char c = word.charAt(index);
        if(c=='.'){
           for(TrieNode child : node.children){
             if(child!=null && dfs(word, index+1, child)){
                return true;
             }
            }

            return false;
        }

        int idx = c - 'a';
        if(node.children[idx]==null){
            return false;
        }
        node = node.children[idx];
     
     return dfs(word, index+1, node);
    }

}



