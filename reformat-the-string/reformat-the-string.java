class Solution {
    public String reformat(String s) {
        if(s.length() <= 1){
            return s;
        }
        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                digit.append(s.charAt(i));
            } else {
                letter.append(s.charAt(i));
            }
        }
        
        String onlyDigit = digit.toString();
        String onlyLetters = letter.toString();
        
        if(Math.abs(onlyDigit.length() - onlyLetters.length()) >= 2) {
            return "";
        } 
        
        StringBuilder solution = new StringBuilder();
        if(onlyDigit.length() > onlyLetters.length()) {
            for(int i = 0; i < onlyDigit.length() - 1; i++){
                solution.append(onlyDigit.charAt(i));
                solution.append(onlyLetters.charAt(i));
            }
            solution.append(onlyDigit.charAt(onlyDigit.length() -1));
        } else if(onlyDigit.length() < onlyLetters.length()){
             for(int i = 0; i < onlyLetters.length() - 1; i++){
                solution.append(onlyLetters.charAt(i));
                solution.append(onlyDigit.charAt(i));
                
            }
            solution.append(onlyLetters.charAt(onlyLetters.length() -1));
        } else {
            for(int i = 0; i < onlyLetters.length() ; i++){
                solution.append(onlyLetters.charAt(i));
                solution.append(onlyDigit.charAt(i));
            }
        }
        return solution.toString();
    }
}