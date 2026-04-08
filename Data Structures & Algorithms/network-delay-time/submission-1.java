class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[]t : times){
          
                  graph
                .computeIfAbsent(t[0], x -> new ArrayList<>())
             .add(new int[]{t[1], t[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]);
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time> dist[node]) continue;
            if(!graph.containsKey(node)) continue;


            for(int[]nq : graph.get(node)){
                int next = nq[0];
                int w = nq[1];

                if(dist[next]>time+w){
                    dist[next]=time+w;

                    pq.offer(new int[]{dist[next], next});
                }
            }
        }
          int ans =0;
        for(int i =1; i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
         ans = Math.max(dist[i], ans);

        }

        return ans;
    }
}
