class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            lastIndex.put(current, i);
        }
        
        
        int currentIndex = 0;
        int start = 0;
        int end = 0;
        
        List<Integer> solution = new ArrayList<>();
    
        while(currentIndex < s.length()) {
            Character currentChar = s.charAt(currentIndex);
            end = Math.max(end, lastIndex.get(currentChar));
            
            if(currentIndex == end) {
                solution.add(currentIndex  + 1 - start);
                start = currentIndex + 1;
            } 
            currentIndex ++;
        }
        
        return solution;
    }
}