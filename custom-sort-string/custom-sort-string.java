class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> sortOrder = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            sortOrder.put(S.charAt(i), i);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> sortOrder.get(a) - sortOrder.get(b));
        List<Integer> noKey = new ArrayList<>();
        for(int i = 0; i < T.length(); i++){
            if(sortOrder.containsKey(T.charAt(i))) {
                pq.add(T.charAt(i));
            } else {
                noKey.add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.remove());
        }
        
        for(int i = 0; i < noKey.size(); i++){
            sb.append(T.charAt(noKey.get(i)));
        }
        return sb.toString();
    }
}