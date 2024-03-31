// Java implementation of the approach
import java.util.*;

class DFSMatrix {

    static class Graph
    {

        // Number of vertex
        int v;

        // Number of edges
        int e;

        // Adjacency matrix
        int[][] adj;

        // Function to fill the empty
        // adjacency matrix
        Graph(int v, int e)
        {
            this.v = v;
            this.e = e;

            adj = new int[v][v];
            for(int row = 0; row < v; row++)
                Arrays.fill(adj[row], 0);
        }

        // Function to add an edge to the graph
        void addEdge(int start, int e)
        {

            // Considering a bidirectional edge
            adj[start][e] = 1;
            adj[e][start] = 1;
        }

        // Function to perform BFS on the graph
        void DFS(int start)
        {

            // Visited vector to so that
            // a vertex is not visited more than once
            // Initializing the vector to false as no
            // vertex is visited at the beginning
            boolean[] visited = new boolean[v];
            Arrays.fill(visited, false);
            Deque<Integer> q = new LinkedList<>();
            q.push(start);
            int vis;
            while (!q.isEmpty())
            {
                vis = q.pop();
                // the current vertex
                if(!visited[vis]){
                    System.out.print(vis + " ");
                    visited[vis] = true;
                    for(int i = 0; i < v; i++)
                    {
                        if (adj[vis][i] == 1)
                        {
                            q.push(i);
                        }
                    }
                }
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

        G.DFS(0);
    }
}

// This code is contributed by sanjeev2552

