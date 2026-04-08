class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         Map<Integer, List<int[]>> graph = new HashMap<>();
        
 
            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                graph.putIfAbsent(from, new ArrayList<>());
               
                    graph.get(from).add(new int[]{to, price});
            }
         
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
    );

    pq.offer(new int[]{0, src, 0});
    while(!pq.isEmpty()){
        int[] current = pq.poll();
        int cost = current[0];
        int city = current[1];
        int stops = current[2];

        if(city==dst){
            return cost;
        }

        if(stops > k){
            continue;
        }

        if(graph.containsKey(city)){
            for(int[]neighbor : graph.get(city)){
                int nextCity = neighbor[0];
                int price = neighbor[1];
           pq.offer(new int[]{
    cost + price,   
    nextCity,       
    stops + 1
});
            }
        }
    }
    return -1;
    }
    }

    