class Solution {
    public String entityParser(String text) {
       StringBuilder sb = new StringBuilder(text);
        Stack<Integer> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        //Search the string for all the occurrences of the character '&'.
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == '&') stack.push(i);

        //For every '&'  character
        while (!stack.isEmpty()) {
            int j = stack.pop();
            //check if it matches an HTML entity by checking the ';'
            for (int i = j; i < sb.length(); i++) {
                if (text.charAt(i) == ';') {
                    String  s = sb.substring(j, i + 1);
                    //and if entity found replace it in the answer.
                    String replacement = map.getOrDefault(s,s);
                    sb.replace(j, i + 1, replacement);
                    break;
                }
            }
        }

        return sb.toString();
                
    }
}