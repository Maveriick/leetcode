class Solution {
    List<String> solution = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backTrack(s, new StringBuilder(), 0);
        return solution;
    }
    
    private void backTrack(String s, StringBuilder currentString, int currentIndex) {
        if(currentString.length() == s.length()) {
            solution.add(currentString.toString());
            return;
        }
        
        Character current = s.charAt(currentIndex);
        if(Character.isDigit(current)) {
            currentString.append(current);
            backTrack(s, currentString, currentIndex + 1);
            currentString.deleteCharAt(currentString.length() - 1);
        } else {
            if(Character.isUpperCase(current)) {
                currentString.append(Character.toLowerCase(current));
                 backTrack(s, currentString, currentIndex + 1);
                currentString.deleteCharAt(currentString.length() - 1);
            } else {
                currentString.append(Character.toUpperCase(current));
                 backTrack(s, currentString, currentIndex + 1);
                currentString.deleteCharAt(currentString.length() - 1);
            }
             currentString.append(current);
             backTrack(s, currentString, currentIndex + 1);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}