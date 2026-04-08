class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res =new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(),res);
        return res;
    }

    private void backtracking(String s, int start, List<String> path, List<List<String>> res){
        if(start==s.length()){
           res.add(new ArrayList<>(path));

        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                path.add(s.substring(start, i +1));
                backtracking(s, i+1, path, res);
                path.remove(path.size()-1);
            
            }
        }
    }


    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
