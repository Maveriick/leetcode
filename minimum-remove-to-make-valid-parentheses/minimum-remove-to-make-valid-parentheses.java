class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s.length() == 0) {
            return s;
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                if(s.charAt(i) == ')'){
                    if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        
       // System.out.println(stack.toString());
        
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(!stack.isEmpty() && stack.peek() == i){
                stack.pop();
            } else {
                sb.insert(0, s.charAt(i));
            }
        }
        return sb.toString();
    }
}