class Solution {
    public void reverseWords(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            Character temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }
        
        int currentStart = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                int st = currentStart;
                int en = i - 1;
                while( st < en) {
                     Character temp = s[st];
                     s[st] = s[en];
                     s[en] = temp;
                    st++;
                    en--;
                }
                currentStart = i + 1;
            }
        }
        
        int a = currentStart;
        int e = s.length - 1;
        while( a < e) {
                     Character temp = s[a];
                     s[a] = s[e];
                     s[e] = temp;
                    a++;
                    e--;
                }
        
    }
}