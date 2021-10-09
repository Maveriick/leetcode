class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if(croakOfFrogs.length() == 0){
            return 0;
        }
        Stack<Character> frogs = new Stack<>();
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        
        int maxFrogs = 1;
        
        for(int i = 0; i < croakOfFrogs.length(); i++){
            Character current = croakOfFrogs.charAt(i);
            if(current == 'c'){
                c ++;
                frogs.push(current);
                maxFrogs = Math.max(maxFrogs, frogs.size());
            }
            if(current == 'r') {
                r ++;
                if(r > c) {
                    return -1;
                }
            } 
            if(current == 'o') {
                o++;
                if(o > r){
                    return -1;
                }
            } 
            if(current == 'a') {
                a ++;
                if (a > o) {
                    return -1;
                }
            }
            if(current == 'k'){
                k ++;
                if(k > a){
                    return - 1;
                }
                if(frogs.isEmpty()){
                    return - 1;
                }
                frogs.pop();
            }
        }
        
        if (!(c==r&&r==o&&o==a&&a==k)) return -1;
        
        return maxFrogs;
    }
}