class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=1;i<=n; i++){
           parent[i] = i;
           size[i] = 1;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!union(u, v)){
                return edge;
            }
        }

        return new int[0];   
    }

    private int find(int x){
        if(parent[x] != x){
            parent[x]=find(parent[x]);
        }

        return parent[x];
    }

    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return false;
        }
        
         if(size[rootA]<size[rootB]){
            parent[rootA]= rootB;
        }else if(size[rootB]<size[rootA]){
            parent[rootB]= rootA;
        }else{
            parent[rootA]= rootB;
            size[rootB]++;
        }

        return true;
    }
}
