class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isAllCaps = true;
        boolean isFirstCaps = false;
        boolean isNoneCaps = true;
        boolean isAnyCaps = false;
        int caps = 0;
        for(int i = 0; i < word.length(); i++) {
            Character current = word.charAt(i);
            if(Character.isUpperCase(current)) {
                isAnyCaps = true;
                isNoneCaps = false;
                if(i == 0){
                    isFirstCaps = true;
                }
                caps ++;
            } else {
                isAllCaps = false;
               
            }
        }
        
        return isAllCaps || isNoneCaps || (caps == 1 && isFirstCaps == true);
    }
}