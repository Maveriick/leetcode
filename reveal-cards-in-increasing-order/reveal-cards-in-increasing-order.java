class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        // [2,13,3,11,5,17,7]
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < deck.length; i++) {
            q.add(i);
        }
        //
    
        System.out.println(q.toString());
        int[] solution = new int[deck.length];
        
        for(int i = 0; i < deck.length; i++) {
            int qPoll = q.poll();
            solution[qPoll] = deck[i];
            
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        return solution;
        
    }
}