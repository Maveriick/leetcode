class Solution {
    public int openLock(String[] deadends, String target) {
        
        List<String> dead = new ArrayList<>();
        for(String d : deadends){
            dead.add(d);
        }
        
        String start = "0000";
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        
        Queue<String> bfsQ = new LinkedList<>();
        bfsQ.add(start);
        int distance = 0;
        
        if(dead.contains(start)){
            return -1;
        }
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                String current = bfsQ.remove();
                if(current.equals(target)){
                    return distance;
                }
                for(int j = 0; j < current.length(); j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(current.substring(0,j));
                    Character currentChar = current.charAt(j);
                    int next = (Character.getNumericValue(currentChar) + 1) % 10;
                    sb.append(String.valueOf(Character.forDigit(next, 10)));
                    sb.append(current.substring(j + 1, current.length()));
                    
                    StringBuilder sb2 = new StringBuilder();
                     sb2.append(current.substring(0,j));
                    int previous = (Character.getNumericValue(currentChar) - 1) % 10;
                    if(previous == -1){
                        previous = 9;
                    }
                    sb2.append(String.valueOf(Character.forDigit(previous, 10)));
                    sb2.append(current.substring(j + 1, current.length()));
                    
                    //System.out.println(sb.toString());
                    if(!visited.contains(sb.toString()) && !dead.contains(sb.toString())){
                        visited.add(sb.toString());
                        bfsQ.add(sb.toString());
                    }
                    
                    if(!visited.contains(sb2.toString()) && !dead.contains(sb2.toString())){
                        visited.add(sb2.toString());
                        bfsQ.add(sb2.toString());
                    }
                }
            }
            //System.out.println(bfsQ.toString());
            distance++;
        }
        return -1;
    }
}