class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> position = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(current == c) {
                position.add(i);
            }
        }
        
        System.out.println(position.toString());
        
        int[] solution = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(current == c) {
                solution[i] = 0;
            } else {
                int currentMin = Integer.MAX_VALUE;
                for(int j = 0; j < position.size(); j++) {
                    currentMin = Math.min(currentMin, Math.abs(i - position.get(j)));
                }
                solution[i] = currentMin;
            }
        }
        return solution;
        
    }
}