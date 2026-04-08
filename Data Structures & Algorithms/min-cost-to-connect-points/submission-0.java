class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        // 1. Create all edges
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) +
                             Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, weight});
            }
        }

        // 2. Sort edges by weight
        edges.sort((a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // 3. Kruskal
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU != rootV) {
                // union
                if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }

                totalCost += weight;
                edgesUsed++;

                if (edgesUsed == n - 1) break;
            }
        }

        return totalCost;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
