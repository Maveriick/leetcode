/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        
        if(isCelebrityCandidate(celebrityCandidate, n)){
            return celebrityCandidate;
        }
        return -1;
    }
    
    
    private boolean isCelebrityCandidate( int candidate, int n) {
        for(int i = 0; i < n; i++) {
            if(i == candidate) {
                continue;
            }
            
            if(!knows(i, candidate) || knows(candidate, i)){
                return false;
            }
        }
        return true;
    }
}