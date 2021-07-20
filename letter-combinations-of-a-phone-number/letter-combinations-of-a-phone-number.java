class Solution {
    List<String> sol = new ArrayList<>();
     Map<Integer, String> keyPad = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return sol;
        }
       
        keyPad.put(2, "abc");
        keyPad.put(3, "def");
        keyPad.put(4, "ghi");
        keyPad.put(5, "jkl");
        keyPad.put(6, "mno");
        keyPad.put(7, "pqrs");
        keyPad.put(8, "tuv");
        keyPad.put(9, "wxyz");
        
        dfs(digits, 0, new StringBuilder());
        return sol;
        
    }
    
    private void dfs(String digits, int currentIndex, StringBuilder currentString) {
        if(currentString.length() == digits.length()) {
            sol.add(new String(currentString.toString()));
            return;
        }
        
        int currentDigit = Integer.parseInt(String.valueOf(digits.charAt(currentIndex)));
        String keys = keyPad.get(currentDigit);
        for(int i = 0; i < keys.length(); i++) {
            currentString.append(keys.charAt(i));
            dfs(digits, currentIndex + 1, currentString);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}