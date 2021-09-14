class Solution {
    public String minWindow(String s, String t) {
        int startWindow = 0;
        int endWindow = 0;
        Map<Character, Integer> tMap = buildMap(t);
        Map<Character, Integer> currentMap = new HashMap<>();
        int minLength = s.length()+1;
        int startIndex = -1;
        int endIndex = -1;
        
        while(endWindow < s.length()) {
            currentMap.put(s.charAt(endWindow), currentMap.getOrDefault(s.charAt(endWindow), 0) + 1);
            //System.out.println(currentMap.toString());
            if(compare(tMap, currentMap) == false) {
                endWindow ++;
            } else {
               
                while(compare(tMap, currentMap) == true) {
                    if(endWindow - startWindow + 1 < minLength  ) {
                        startIndex = startWindow;
                        endIndex = endWindow;
                        minLength = endWindow - startWindow + 1;
                    }
                    Character startWindowChar = s.charAt(startWindow);
                    int startWindowCharF = currentMap.get(startWindowChar);
                    startWindowCharF--;
                    if(startWindowCharF == 0){
                        currentMap.remove(startWindowChar);
                    } else {
                        currentMap.put(startWindowChar, startWindowCharF);
                    }
                    startWindow++;
                }
                endWindow++;
            }
        }
        
        while(compare(tMap, currentMap) == true) {
            if(endWindow - startWindow + 1 < minLength  ) {
                startIndex = startWindow;
                endIndex = endWindow;
                minLength = endWindow - startWindow + 1;
            }
            Character startWindowChar = s.charAt(startWindow);
            int startWindowCharF = currentMap.get(startWindowChar);
            startWindowCharF--;
            if(startWindowCharF == 0){
                currentMap.remove(startWindowChar);
            } else {
                currentMap.put(startWindowChar, startWindowCharF);
            }
            startWindow++;
        }
        
        /*
        "ADOBECODEBANC"
        "ABC"
        */
        /*
        System.out.println(endWindow);
        System.out.println(startWindow);
        System.out.println(currentMap.toString());
        System.out.println(minLength);
        */
    
        if(startIndex != -1 && endIndex != -1) {
            return s.substring(startIndex, endIndex +1);
        } else {
            return "";
        }
    }
    
    private boolean compare(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for(Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if(!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    private Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}