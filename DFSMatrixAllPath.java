// Java implementation of the approach

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class DFSMatrixAllPath {

    static class Graph {

        // Number of vertex
        int v;

        // Number of edges
        int e;

        // Adjacency matrix
        int[][] adj;

        // Function to fill the empty
        // adjacency matrix
        Graph(int v, int e) {
            this.v = v;
            this.e = e;

            adj = new int[v][v];
            for (int row = 0; row < v; row++)
                Arrays.fill(adj[row], 0);
        }

        // Function to add an edge to the graph
        void addEdge(int start, int e) {

            // Considering a bidirectional edge
            adj[start][e] = 1;
            adj[e][start] = 1;
        }

        // Function to perform BFS on the graph
        static void dfs(int[][] adj, int curr, int end, String path, boolean[] vis, Deque<Integer> s, int v) {
            if (curr == end) {
                System.out.println(path);
                return;
            }
            if (!vis[curr]) {
                vis[curr] = true;
                for (int i = 0; i < v; i++) {
                    if (adj[curr][i] == 1 && !vis[i]) {
                        dfs(adj, i, end, path + i, vis, s, v);
                    }
                }
                vis[curr] = false;
            }
        }

    }
    // Driver code
    public static void main(String[] args)
    {

        int v = 5, e = 4;

        // Create the graph
        Graph G = new Graph(v, e);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(2,3);
        G.addEdge(3,4);
        boolean[] vis = new boolean[v];
        Deque<Integer> s = new LinkedList();
        G.dfs(G.adj,0,4,"0",vis,s,v);
    }
}

// This code is contributed by sanjeev2552

