class Solution {
    public double averageWaitingTime(int[][] customers) {
        long canStartTime = 0l;
        long totalWaitTime = 0l;
        for(int i = 0; i < customers.length; i++){
            int arrivalTime = customers[i][0];
            int preparationTime = customers[i][1];
            System.out.println("ArrivalTime:" + arrivalTime);
            System.out.println("PreparationTime:" + preparationTime);
            System.out.println("CanStartTime:" + canStartTime);
    
            // Chef is busy and cannnot start as soon as customer arrives
            if(canStartTime > arrivalTime){
                // We add the time customer waits for the chef to be free
                totalWaitTime += canStartTime - arrivalTime;
                
                //Chef will be free once the recipe is prepared
                canStartTime += preparationTime;
                
                // We add the time to prepare recipe
                totalWaitTime += preparationTime;
            } else { // Customer arrives after chef is free
                
                //If chef was already free, he could not start till customer arrives, so update to arrivalTime
                if(canStartTime < arrivalTime){
                    canStartTime = arrivalTime;
                }
                
                //Chef will be free once the recipe is prepared
                canStartTime += preparationTime;
                
                // We add the time to prepare recipe
                totalWaitTime += preparationTime;
            }
            
            System.out.println("TotalWaitTime:" + totalWaitTime);
            System.out.println();
        }
        System.out.println("TotalWaitTime:" + totalWaitTime);
        
        return  (double)totalWaitTime / customers.length;
    }
}