class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String k =s+s;     // 1.
        k=k.substring(1,k.length()-1);  //2.
        System.out.println(k);
        if(k.contains(s))    //3.
            return true;
        return false;    //4.
    }
}

