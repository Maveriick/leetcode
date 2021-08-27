class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersection = new ArrayList<>();
        
        int firstStart = 0;
        int secondStart = 0;
        while(firstStart < firstList.length && secondStart < secondList.length) {
            if(firstList[firstStart][1] >= secondList[secondStart][0] || secondList[secondStart][1] >= firstList[firstStart][0]) {
                int start = Math.max(firstList[firstStart][0], secondList[secondStart][0]);
                int end = Math.min(firstList[firstStart][1], secondList[secondStart][1]);
                if(start <= end) {
                     intersection.add(new int[]{start, end});
                }
               
            } 
            
            if(firstList[firstStart][1] < secondList[secondStart][1]){
                firstStart++;
            } else {
                secondStart++;
            }
        }
        
        
        int[][] solution = new int[intersection.size()][2];
        for(int i = 0; i < intersection.size(); i++) {
            int[] current = intersection.get(i);
            solution[i][0] = current[0];
            solution[i][1] = current[1];
            
        }
        return solution;
    }
}