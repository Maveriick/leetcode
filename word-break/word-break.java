class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(0);
        
        
        while(!bfsQ.isEmpty()) {
            int currentIndex = bfsQ.remove();
            if(currentIndex == s.length()) {
                return true;
            } else {
                for(int i = currentIndex + 1; i <= s.length(); i++) {
                    if(wordDict.contains(s.substring(currentIndex, i))) {
                        if(!visited.contains(i)) {
                            visited.add(i);
                            bfsQ.add(i);
                        }
                    }
                }
            }
        }
        return false;
    }
}