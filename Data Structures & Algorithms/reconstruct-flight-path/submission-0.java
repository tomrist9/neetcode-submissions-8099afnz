class Solution {
    LinkedList<String> result = new LinkedList<>();
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
      for(List<String>ticket : tickets){
        String from = ticket.get(0);
        String to = ticket.get(1);

        graph.computeIfAbsent(from, k-> new PriorityQueue<>())
        .offer(to);
      }
        dfs("JFK");
        return result;
      }
    
        private void dfs(String airport){
            PriorityQueue<String> neighbors =  graph.get(airport);
            while(neighbors!=null && !neighbors.isEmpty()){
                String next = neighbors.poll();

                dfs(next);
            }

            result.addFirst(airport);
        }
    }

