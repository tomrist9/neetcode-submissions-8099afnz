class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level =1;
        while(!queue.isEmpty()){
            int size = queue.size();
      

            for(int i=0; i<size; i++){
                         String current = queue.poll();

            char[] chars = current.toCharArray();
            for(int j=0; j<chars.length; j++){
                 char original = chars[j];
            for(char c = 'a'; c <='z'; c++){
                if(c==original) continue;
                chars[j]=c;
                String newWord = new String(chars);

                if(newWord.equals(endWord)){
                  return level+1;
                }

                if(words.contains(newWord)){
                    queue.offer(newWord);

                    words.remove(newWord);
                }
            }
                chars[j]= original;
            
            }
            }
            level++;
        }

        return 0;
    }
}
