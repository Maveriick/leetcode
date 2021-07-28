class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            if(words[i].trim().length() > 0) {
                  sb.append(words[i]);
                sb.append(" ");
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
        
    }
}