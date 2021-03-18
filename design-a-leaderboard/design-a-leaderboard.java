class Leaderboard {
    Map<Integer, Integer> playerScore = new HashMap<>();
    public Leaderboard() {
        playerScore = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!playerScore.containsKey(playerId)){
            playerScore.put(playerId, score);
        } else {
            int currentScore = playerScore.get(playerId);
            playerScore.put(playerId, currentScore + score);
        }
    }
    
    public int top(int K) {
        PriorityQueue<Integer> topPlayer = new PriorityQueue<>((a,b) -> playerScore.get(a) - playerScore.get(b));
        for (Map.Entry<Integer, Integer> entry : playerScore.entrySet()) {
            topPlayer.offer(entry.getKey());
            if (topPlayer.size() > K) {
                topPlayer.poll();
            }
        }
        
        int sum = 0;
        while(!topPlayer.isEmpty()) {
            sum += playerScore.get(topPlayer.remove());
        }
        return sum;
    }
    
    public void reset(int playerId) {
        playerScore.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */