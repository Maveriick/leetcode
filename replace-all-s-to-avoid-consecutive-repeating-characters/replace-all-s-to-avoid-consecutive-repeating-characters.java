class Solution {
    public String modifyString(String s) {
        if(s.length() == 1) {
            if(s.charAt(0) == '?'){
                return "a";
            } else {
                return s;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(current == '?') {
                for(char j = 'a'; j <= 'z'; j++) {
                    if(i == 0 ){
                        if(s.charAt(i + 1) != j){
                             sb.append(j);
                            break;
                        }
                    } else if( i == s.length() - 1) {
                        if(sb.charAt(i - 1) != j){
                             sb.append(j);
                             break;
                        }
                    } else {
                        if(s.charAt(i + 1) != j && sb.charAt(i-1) != j){
                            sb.append(j);
                             break;
                        }
                    }
                }
            } else {
                sb.append(current);
            }
        }
        return sb.toString();
                    
    }
}