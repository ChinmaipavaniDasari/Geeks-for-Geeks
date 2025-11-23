class Solution {
    static class DSU {
        int[] parent, rank;
        int count;
        
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            count--;
        }
    }
    
    int maxRemove(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);

        // maps to connect stones by same row or column
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int r = stones[i][0];
            int c = stones[i][1];

            if (row.containsKey(r)) {
                dsu.union(i, row.get(r));
            } else {
                row.put(r, i);
            }

            if (col.containsKey(c)) {
                dsu.union(i, col.get(c));
            } else {
                col.put(c, i);
            }
        }

        // max stones removable = total stones - connected components
        return n - dsu.count;
    }
}
