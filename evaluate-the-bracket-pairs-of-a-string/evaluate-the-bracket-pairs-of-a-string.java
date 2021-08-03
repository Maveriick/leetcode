class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        for(int i = 0; i < knowledge.size(); i++) {
            List<String> c = knowledge.get(i);
            knowledgeMap.put(c.get(0), c.get(1));
        }
        
       
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start < s.length()) {
            Character currentChar = s.charAt(start);
            if(currentChar == '('){
                int end = start + 1;
                while(s.charAt(end) != ')'){
                    end ++;
                }
                String key = s.substring(start + 1, end);
                if(knowledgeMap.containsKey(key)) {
                    sb.append(knowledgeMap.get(key));
                } else {
                    sb.append("?");
                }
                start = end ;
            } else {
                sb.append(currentChar);
            }
            start++;
        }
        return sb.toString();
       
    }
}