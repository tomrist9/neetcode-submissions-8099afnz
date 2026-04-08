class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
            Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
        backtracking(0, digits, map, new StringBuilder(), res);
        return res;
    }

    private void backtracking(int index, String digits, Map<Character, String> map, StringBuilder path, List<String> res){
        if(index==digits.length()){
            res.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for(char letter : letters.toCharArray()){
           path.append(letter);
           backtracking(index + 1, digits, map, path,res);
           path.deleteCharAt(path.length()-1);
           }
            }
        }
    
