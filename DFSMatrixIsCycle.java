// Java implementation of the approach

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class DFSMatrixIsCycle {

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
        static boolean dfs(int[][] adj, int curr,  boolean[] vis, int v,int parent) {
            vis[curr]=true;
            //rec[curr]=true;
            for(int i=0;i<v;i++){
                if(adj[curr][i]==1 && vis[i] && parent!=curr){
                    System.out.println("here:"+parent+"curr:"+curr);
                    return true;
                }
                if(adj[curr][i]==1 && !vis[i] ){
                    boolean flag = dfs(adj,i,vis,v,curr);
                    if(flag) return true;
                }
            }
            //vis[curr]=false;
            return false;
        }

    }
    // Driver code
    public static void main(String[] args)
    {

        int v = 5, e = 4;

        // Create the graph
        Graph G = new Graph(v, e);
        G.addEdge(0, 1);
        //G.addEdge(0, 2);
        G.addEdge(0, 3);

        G.addEdge(1, 0);
        G.addEdge(1, 2);

      //  G.addEdge(2,0);
        G.addEdge(2,1);

        G.addEdge(3,0);
        G.addEdge(3,4);

        G.addEdge(4,3);

        boolean[] vis = new boolean[v];
        boolean[] rec = new boolean[v];
        //Deque<Integer> s = new LinkedList();
        boolean flag = G.dfs(G.adj,0,vis,v,0);
        System.out.println(flag);
    }
}

// This code is contributed by sanjeev2552

