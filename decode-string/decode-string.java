class Solution {
   
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String current = "";
        int ptr = 0;
        while(ptr < s.length()){
            Character currentChar = s.charAt(ptr);
            if(Character.isDigit(currentChar)){
                int start = ptr;
                int num = 0;
                while( Character.isDigit(s.charAt(ptr))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(ptr));
                    ptr++;
                }
                numStack.push(num);
            } else if(currentChar == '[') {
                stringStack.push(current);
                current = "";
                ptr++;
            } else if (currentChar == ']'){
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int times = numStack.pop();
                for(int i = 0; i < times;i ++) {
                    sb.append(current);
                }
                
                current = sb.toString();
                ptr++;
            } else {
                current += currentChar;
                ptr++;
            }
        }
        return current;
        
    }
}