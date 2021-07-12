class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        
        int haystackStart = 0;
        while(haystackStart <= haystack.length() - needle.length()) {
            //System.out.println(haystackStart);
            if(haystack.charAt(haystackStart) == needle.charAt(0)) {
                    if(isMatching(haystack, haystackStart, needle)){
                        return haystackStart;
                    } else {
                        haystackStart ++;
                    }

            } else {
                haystackStart ++;
            }
        }
        return -1;
    }
    
    private boolean isMatching(String haystack, int startIndex, String needle) { 
        int needleStart = 0;
        for(int i = startIndex ; i < startIndex + needle.length(); i++) {
            if(haystack.charAt(i) != needle.charAt(needleStart)) {
                return false;
            }
            needleStart++;
        }
        return true;
    }
}