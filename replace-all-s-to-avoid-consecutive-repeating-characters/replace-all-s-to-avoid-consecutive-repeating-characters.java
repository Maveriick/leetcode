class Solution {
    public String modifyString(String s) {
        if(s.length() == 0){
            return s;
        }
        
        
        if(s.length() == 1){
            if(s.charAt(0) != '?'){
                return s;
            } else {
                return "a";
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '?'){
                for(char j = 'a' ; j <= 'z'; j++) {
                    if(i > 0 && i < s.length() - 1) {
                        if(sb.charAt(i - 1) != j && j != s.charAt(i + 1)){
                            sb.append(j);
                            break;
                        } 
                    }else if(i == 0){
                        if(j != s.charAt(i + 1)){
                            sb.append(j);
                            break;
                        }
                    } else if(i == s.length() - 1) {
                        if(j != sb.charAt(i - 1)){
                            sb.append(j);
                            break;
                        }
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}