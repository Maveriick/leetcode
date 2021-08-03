class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean canBreak = false;;
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(0);
        boolean[] visited = new boolean[s.length()];
        
        while(!bfsQ.isEmpty()){
            if(canBreak){
                break;
            }
            //System.out.println(bfsQ);
            int currentIndex = bfsQ.remove();
             if (visited[currentIndex]) {
                continue;
            }
            if(currentIndex == s.length()) {
                canBreak = true;
                break;
            }
            for(int i = currentIndex ; i < s.length(); i++) {
                String word = s.substring(currentIndex, i + 1);
                if(wordDict.contains(word) && canBreak == false){
                    if(i + 1 == s.length()) {
                        canBreak = true;
                        break;
                    }
                    bfsQ.add(i + 1);
                }
            }
            visited[currentIndex] = true;
        }
        
        return canBreak;
    }
}