class Solution {
    private static final int [][] DIRS = {
        {0,1},
        {0, -1},
        {-1, 0},
        {1, 0}
    };
       private List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
      
        for(int i=0; i<numCourses; i++){
         graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }

      
   
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (hasCycle(i, graph, visiting, visited)) {
                    return new int[0];
                }
            }
        }

        // List<Integer> → int[]
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    
    }

    private boolean hasCycle(
            int course,
            List<List<Integer>> graph,
            Set<Integer> visiting,
            Set<Integer> visited

    ) {
        if (visiting.contains(course)) return true;
        if (visited.contains(course)) return false;

        visiting.add(course);

        for (int next : graph.get(course)) {
            if (hasCycle(next, graph, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(course);
        visited.add(course);
        res.add(course);
        return false;
    }
}
