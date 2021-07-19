class Solution {
    public boolean confusingNumber(int n) {
        Queue<Integer> q = new LinkedList<>();
        int originalNumber = n;
        Map<Integer, Integer> flipped = new HashMap<>();
        flipped.put(0,0);
        flipped.put(1,1);
        flipped.put(6,9);
        flipped.put(8,8);
        flipped.put(9,6);
        
        while(n != 0) {
            int digit = n % 10;
            if(!flipped.containsKey(digit)){
                return false;
            }
            q.add(digit);
            n = n / 10;
        }
        
        int newNum = 0;
        while(!q.isEmpty()) {
            newNum = newNum * 10 + flipped.get(q.remove());
        }
        
        System.out.println(originalNumber);
        System.out.println(newNum);
        return newNum != originalNumber;
        
        
    }
}