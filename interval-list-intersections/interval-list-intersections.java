class Interval {
    int s;
    int e;
    public Interval(int s, int e) {
        this.s = s;
        this.e = e;
    }
}


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIndex = 0;
        int secondIndex = 0;
        
        List<Interval> solution = new ArrayList<>();
        while(firstIndex < firstList.length && secondIndex < secondList.length) {
            if((firstList[firstIndex][1] >= secondList[secondIndex][0]) || secondList[secondIndex][1] >= firstList[firstIndex][0]){
                int start = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
                int end = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);
                if(start <= end) {
                    Interval intersection = new Interval(start, end);
                    solution.add(intersection);
                }
            }
            
            if(firstList[firstIndex][1] < secondList[secondIndex][1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }
        
        int[][] solutionArray = new int[solution.size()][2];
        for(int i = 0; i < solution.size(); i++) {
            solutionArray[i][0] = solution.get(i).s;
            solutionArray[i][1] = solution.get(i).e;
        }
        return solutionArray;
    }
}