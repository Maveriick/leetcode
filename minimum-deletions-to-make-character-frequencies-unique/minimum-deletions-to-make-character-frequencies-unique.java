class Solution {
    public int minDeletions(String s) {
        Set<Integer> presentF = new HashSet<>();
        int charToDelete = 0;
       
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        //System.out.println(sorted);
        
        Character current = sorted.charAt(0);
        int currentF = 1;
        for(int i = 1; i < sorted.length(); i++) {
            if(sorted.charAt(i) == current){
                currentF++;
            } else {
                if(!presentF.contains(currentF)){
                    //System.out.println("Doesn't contains: " + current);
                    presentF.add(currentF);
                    current = sorted.charAt(i);
                    currentF = 1;
                } else {
                    //System.out.println("Contains: " + current);
                    int removed = 1;
                    for(int j = currentF - 1; j > 0; j--){
                        if(!presentF.contains(j)){
                            presentF.add(j);
                            break;
                        } else {
                            removed++;
                        }
                    }
                    charToDelete += removed;
                    //System.out.println(presentF.toString());
                    current = sorted.charAt(i);
                    currentF = 1;
                }
            }
        }
        
        if(presentF.contains(currentF)){
            int removed = 1;
            for(int j = currentF - 1; j >= 0; j--){
                if(!presentF.contains(j)){
                    presentF.add(j);
                    break;
                } else {
                    removed++;
                }
            }
            charToDelete += removed;
        }
        return charToDelete;
    }
        
}
    
