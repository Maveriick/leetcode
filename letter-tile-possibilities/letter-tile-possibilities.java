class Solution {
    int possibilities = 0;
    public int numTilePossibilities(String tiles) {
        
        char[] input = tiles.toCharArray();
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();
        backTrack(sb, new String(input), new HashSet<>());
        return possibilities;
    }
    
    private void backTrack(StringBuilder current, String input, Set<Integer> visited){  
        if(current.length() >= 1){
            possibilities++;
        }
        
        for(int i = 0; i < input.length(); i++){
            if(visited.contains(i) || (i > 0 && input.charAt(i) == input.charAt(i - 1) && visited.contains(i-1) == false)){
                continue;
            }
            visited.add(i);
            current.append(input.charAt(i));
            backTrack(current, input, visited);
            current.deleteCharAt(current.length() - 1);
            visited.remove(i);
        }
    }
}