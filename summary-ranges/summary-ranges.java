class Solution {
    public List<String> summaryRanges(int[] nums) {
       
         List<String> solution = new ArrayList<>();
         if(nums.length == 0) {
             return solution;
         }
        
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(nums[0]));
        
        int current = 1;
        int previous = 0;
        while(current < nums.length) {
            if(nums[current] - nums[current - 1] == 1) {
                current ++;
            } else {
                if(current - previous > 1) {
                    sb.append("->");
                    sb.append(Integer.toString(nums[current - 1]));
                    solution.add(sb.toString());
                    sb = new StringBuilder();
                    sb.append(Integer.toString(nums[current]));
                    previous = current;
                } else {
                    solution.add(sb.toString());
                    sb = new StringBuilder();
                    sb.append(Integer.toString(nums[current]));
                    previous = current;
                }
                current++;
            }
        }
        
      
        if(nums[current - 1] != nums[previous]){
            sb.append("->");
            sb.append(Integer.toString(nums[nums.length - 1]));
            solution.add(sb.toString());
        } else {
            solution.add(sb.toString());
        }
        
        return solution;
    }
}