class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(s.length() < k) {
            return 0;
        }
        int startingWindow = 0;
        int endingWindow = 0 ;
        Set<Character> currentSet = new HashSet<>();
        for(int i = 0; i < k - 1; i++){
            currentSet.add(s.charAt(i));
            endingWindow++;
        }
       
        int substrings = 0;
        while(endingWindow < s.length()){
            currentSet.add(s.charAt(endingWindow));
            if(currentSet.size() == k) {
                //System.out.println(currentSet.toString());
                substrings ++;
            }
            currentSet.remove(s.charAt(startingWindow));
            startingWindow++;
            for(int j = startingWindow; j <= endingWindow; j++){
                if(!currentSet.contains(s.charAt(j))){
                    currentSet.add(s.charAt(j));
                }
            }
            endingWindow++;
        }
        
        return substrings;
        
    }
}