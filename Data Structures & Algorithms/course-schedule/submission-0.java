class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[]pre :prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<numCourses; i++){
            if(!visiting.contains(i)){
                if(hasCycle(i, graph, visiting, visited)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, Set<Integer> visiting, Set<Integer> visited){
        if(visiting.contains(course)) return true;
        if(visited.contains(course)) return false;
        visiting.add(course);
        for(int next : graph.get(course)){
            if(hasCycle(next, graph, visiting, visited)){
                return true;
            }
        }
        visiting.remove(course);
        visited.add(course);

        return false;
    }
}
