class Solution {
    public int compress(char[] chars) {
        Stack<Character> s = new Stack<>();
        int currentIndex = 0;
        for(int i = 0; i < chars.length; i++) {
            Character current = chars[i];
            if(s.isEmpty()){
                s.push(current);
            } else {
                if(current == s.peek()){
                    s.push(current);
                } else {
                    Character top = s.peek();
                    int times = s.size();
                    chars[currentIndex] = top;
                    currentIndex++;
                    if(times > 1) {
                        Stack<Character> digitStack = new Stack<>();
                        while(times != 0) {
                            int digit = times % 10;
                            digitStack.push(Character.forDigit(digit,10));
                            times = times / 10;
                        }
                        while(!digitStack.isEmpty()){
                            chars[currentIndex] = digitStack.pop();
                            currentIndex++;
                        }
                    } 
                    s.clear();
                    s.push(current);
                }
            }
        }
        chars[currentIndex] = s.peek();
        currentIndex++;
        int times = s.size();
        if(times > 1) {
                Stack<Character> digitStack = new Stack<>();
                while(times != 0) {
                    int digit = times % 10;
                    digitStack.push(Character.forDigit(digit,10));
                    times = times / 10;
                }
                while(!digitStack.isEmpty()){
                    chars[currentIndex] = digitStack.pop();
                    currentIndex++;
                }
        } 
        
        return currentIndex;
    }
}