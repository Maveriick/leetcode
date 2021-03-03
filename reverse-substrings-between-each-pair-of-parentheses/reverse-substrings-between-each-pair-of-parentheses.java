class Solution {
    public String reverseParentheses(String s) {
        if(s.length() <= 1){
            return s;
        }
        Stack<Character> reverseStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(current == ')') {
                Queue<Character> temp = new LinkedList<>();
                while(reverseStack.peek() != '('){
                    temp.add(reverseStack.pop());
                }
                reverseStack.pop();
                while(!temp.isEmpty()){
                    reverseStack.push(temp.remove());
                }
            } else {
                reverseStack.push(current);
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!reverseStack.isEmpty()){
            sb.insert(0,reverseStack.pop());
        }
        return sb.toString();
    }
}