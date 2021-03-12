class Solution {
    public int minCost(String s, int[] cost) {
        if(s.length() <= 1){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int currentIndex = 0;
        int currentCost = 0;
        while(currentIndex < s.length()) {
            if(!st.isEmpty() && s.charAt(st.peek()) == s.charAt(currentIndex)) {
                while(currentIndex < s.length() && s.charAt(st.peek()) == s.charAt(currentIndex)) {
                    if(cost[st.peek()] < cost[currentIndex]) {
                        currentCost += cost[st.peek()];
                        st.pop();
                        st.push(currentIndex);
                        currentIndex++;
                    } else {
                       
                        currentCost += cost[currentIndex];
                        currentIndex++;
                    }
                }
            } else {
                st.push(currentIndex);
                currentIndex++;
            }
            //System.out.println(st.toString());
        }
        return currentCost;
        
        
    }
}