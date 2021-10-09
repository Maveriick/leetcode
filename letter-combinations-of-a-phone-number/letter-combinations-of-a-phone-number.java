class Solution {
    List<String> solution = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return solution;
        }
        Map<Character, String> keyMap = new HashMap<>();
        keyMap.put('0', "");
        keyMap.put('1', "");
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
        
        backTrack(digits ,0, new StringBuilder(), keyMap);
        return solution;
    }
    
    private void backTrack(String digits, int currentIndex, StringBuilder current, Map<Character, String> keyMap) {
        if(currentIndex == digits.length()){
            solution.add(new String(current));
            return;
        }
        
        Character currentChar = digits.charAt(currentIndex);
        String mapping = keyMap.get(currentChar);
        for(int i = 0; i < mapping.length(); i++){
            current.append(mapping.charAt(i));
            backTrack(digits, currentIndex + 1, current, keyMap);
            current.deleteCharAt(current.length() - 1);
        }
    }
}