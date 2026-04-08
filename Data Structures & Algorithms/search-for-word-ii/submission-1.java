class Solution {
    class TrieNode{
        TrieNode [] children = new TrieNode[26];
        boolean isEndOfWord;
        String word;
    }
   private final TrieNode root = new TrieNode();

    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
     
        for(String word : words){
             TrieNode node = root;
            for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node = node.children[idx];
       
        }
        node.isEndOfWord = true;
        node.word = word;
       
    }
    for(int i =0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
            dfs(board,  i, j, root);
        }
    }

    return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node){
        if(i<0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        char c = board[i][j];
        if(c=='#' || node.children[c-'a']==null){
            return;
        }

        node = node.children[c - 'a'];
        if(node.isEndOfWord){
            result.add(node.word);
            node.isEndOfWord = false;
        }
        board[i][j]='#';

        dfs(board, i+1, j, node);
        dfs(board, i-1, j, node);
        dfs(board, i, j+1, node);
        dfs(board, i, j-1, node);
        board[i][j] = c;  
    }

   
}
