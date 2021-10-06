class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        Set<Integer> visited = new HashSet<>();
        
        while(!pq.isEmpty()) {
            int currentIndex = pq.poll();
            if(currentIndex == s.length()) {
                return true;
            }
            for(int i = currentIndex; i <= s.length(); i++) {
                if(visited.contains(i)){
                    continue;
                }
                String possibleWord = s.substring(currentIndex, i);
                if(wordDict.contains(possibleWord)) {
                    visited.add(i);
                    pq.add(i);
                }
            }
        }
        
        return false;
        
    }
}