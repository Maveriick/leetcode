class Solution {
    public int distributeCandies(int[] candyType) {
        if(candyType.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> candyTypeCount = new HashMap<>();
        for(int i = 0; i < candyType.length; i++) {
            int type = candyType[i];
            int currentCount = candyTypeCount.getOrDefault(type, 0);
            candyTypeCount.put(type, ++currentCount);
        }
                
        
        int canEat = candyType.length / 2;
        
        Iterator it = candyTypeCount.entrySet().iterator();
        int types = 0;
       
        while(canEat > 0 && it.hasNext()){
        types++;
           Map.Entry<Integer, Integer> me = (Map.Entry)it.next();
           int value = me.getValue();
            value --;
            if(value == 0) {
                it.remove();
            } else {
                me.setValue(value);
            }
            canEat--;
        }
        
        return types;
        
    }
}