class UndergroundSystem {

    Map<Integer, String> checkInStation;
    Map<Integer, Integer> checkInTime;
    Map<String, Map<String, List<Integer>>> times;
    
    public UndergroundSystem() {
        times = new HashMap<>();
        checkInStation = new HashMap<>();
        checkInTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInStation.put(id, stationName);
        checkInTime.put(id, t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int currentCheckInTime = checkInTime.get(id);
        String checkIs = checkInStation.get(id);
        int tripTime = t - currentCheckInTime;
        Map<String, List<Integer>> trips = times.getOrDefault(checkIs, new HashMap<String, List<Integer>>());
        List<Integer> currentTimes = trips.getOrDefault(stationName, new ArrayList<Integer>());
        currentTimes.add(tripTime);
        trips.put(stationName, currentTimes);
        times.put(checkIs, trips);
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Map<String, List<Integer>> trips = times.getOrDefault(startStation, new HashMap<String, List<Integer>>());
        List<Integer> currentTimes = trips.getOrDefault(endStation, new ArrayList<Integer>());
        double sum = 0.0;
        if(currentTimes.size() == 0){
            return sum;
        } else {
            for(int i = 0; i < currentTimes.size(); i++){
                sum += currentTimes.get(i);
            }
        }
        return sum / currentTimes.size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */