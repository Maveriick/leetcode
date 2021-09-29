class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        char[] w = word.toCharArray(), abb = abbr.toCharArray();
        int p = 0, counter = 0;
        for(int i=0; i<abb.length; i++){
            if(Character.isLetter(abb[i])){
                p+=counter;
                if(p>=w.length || abb[i]!=w[p++]){return false;}
                counter = 0;
            }
            else{
                if(counter==0 && abb[i]=='0'){return false;}
                counter = counter*10+abb[i]-'0';
            }
        }
        return p+counter == w.length;
    }
}

/*
i12iz4n
internationalization

0
0
distance 0
*/