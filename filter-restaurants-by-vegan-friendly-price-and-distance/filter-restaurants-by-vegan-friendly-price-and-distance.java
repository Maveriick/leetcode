public class Restaurant{
    public int veganFriendly;
    public int id;
    public int rating;
    public int price;
    public int distance;
    
    public Restaurant(int vF, int id, int rating, int price, int distance) {
        this.veganFriendly = vF;
        this.id = id;
        this.rating = rating;
        this.price = price;
        this.distance = distance;
    }
}

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Restaurant> pq = new PriorityQueue<Restaurant>((a,b) -> a.rating == b.rating ? b.id - a.id : b.rating - a.rating);
        for(int i = 0; i < restaurants.length; i++) {
            int id = restaurants[i][0];
            int rating = restaurants[i][1];
            int vF = restaurants[i][2];
            int price = restaurants[i][3];
            int distance = restaurants[i][4];
            if(veganFriendly == 0) {
                if(price <= maxPrice && distance <= maxDistance) {
                    Restaurant r = new Restaurant(vF, id, rating, price, distance);
                    pq.add(r);
                }
            } else {
                if(price <= maxPrice && distance <= maxDistance && vF == 1) {
                    Restaurant r = new Restaurant(vF, id, rating, price, distance);
                    pq.add(r);
                }
            }
        }
        
        List<Integer> solution = new ArrayList<>();
        while(!pq.isEmpty()){
            Restaurant c = pq.remove();
            solution.add(c.id);
        }
        return solution;
    }
}