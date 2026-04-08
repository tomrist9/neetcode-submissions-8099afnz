class Solution {
    public boolean isValid(String s) {
        Stack<Character> seen = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c== '['){
            seen.push(c);
        }

        else{
            if(seen.isEmpty()) return false;

            char top = seen.pop();
            if((c == ')' && top != '(')
            || (c == '}'&& top != '{')
            || (c == ']' && top != '[')){
             return false;
            }
        }
        }
        return seen.isEmpty();
        }
        
    
}
