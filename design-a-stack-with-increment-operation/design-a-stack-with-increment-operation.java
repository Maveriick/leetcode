class CustomStack {

    int maxSize;
    int[] stackArray;
    int currentIndex;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        currentIndex = 0;
    }
    
    public void push(int x) {
         System.out.println("push");
        if(currentIndex < maxSize) {
            stackArray[currentIndex] = x;
             currentIndex++;
        }
    
        System.out.println(Arrays.toString(stackArray));
        System.out.println(currentIndex);
    }
    
    public int pop() {
        System.out.println("pop");
        
        if(currentIndex > 0) {
            currentIndex--;
            int toReturn = stackArray[currentIndex];
             System.out.println(Arrays.toString(stackArray));
              System.out.println(currentIndex);
            return toReturn;
        } else {
            return -1;
        }
       
        
    }
    
    public void increment(int k, int val) {
         System.out.println("increment");
        System.out.println(currentIndex);
        if(currentIndex <= 0) {
            return;
        }
        if(k > currentIndex) {
            for(int i = 0; i < currentIndex; i++) {
                stackArray[i] += val;
            }
        } else {
            for(int i = 0; i < k; i++) {
                stackArray[i] += val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */