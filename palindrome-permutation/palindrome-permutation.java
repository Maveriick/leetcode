class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> fMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int current = fMap.getOrDefault(c, 0);
            fMap.put(c, ++current);
        }
        
        int evenChars = 0;
        int oddChars = 0;
        for(Map.Entry<Character,Integer> entry: fMap.entrySet()) {
            if(entry.getValue() % 2 == 0){
                evenChars ++;
            } else {
                oddChars ++;
            }
        }
        
        if(oddChars >1) {
            return false;
        } else {
            return true;
        }
    }
}


    
