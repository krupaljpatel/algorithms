import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFS {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(List<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new DFS.Edge(0, 1, 1));
        graph[0].add(new DFS.Edge(0, 2, 1));
        graph[1].add(new DFS.Edge(1, 0, 1));
        graph[1].add(new DFS.Edge(1, 3, 1));
        graph[2].add(new DFS.Edge(2, 0, 1));
        graph[2].add(new DFS.Edge(2, 4, 1));
        graph[3].add(new DFS.Edge(3, 1, 1));
        graph[3].add(new DFS.Edge(3, 4, 1));
        graph[3].add(new DFS.Edge(3, 5, 1));
        graph[4].add(new DFS.Edge(4, 2, 1));
        graph[4].add(new DFS.Edge(4, 3, 1));
        graph[4].add(new DFS.Edge(4, 5, 1));
        graph[5].add(new DFS.Edge(5, 3, 1));
        graph[5].add(new DFS.Edge(5, 4, 1));
        graph[5].add(new DFS.Edge(5, 6, 1));
        graph[5].add(new DFS.Edge(6, 5, 1));
    }
    public static void main(String[] args) {
        List<Edge>[] graph=new ArrayList[7];
        createGraph(graph);
        boolean[] vis = new boolean[8] ;
        dfs(graph,0,vis);
    }
    static void dfs(List<Edge>[] graph,int src,boolean[] vis){
        Deque<Integer> q = new LinkedList<>();
        q.push(src);
        System.out.println("stack" + q + " ");
        while(!q.isEmpty()){
            Integer curr = q.pop();
          //  System.out.println("popping from stack" + q+ " ");
            if(vis[curr]==false) {
                System.out.print(curr + " ");
            vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if (vis[e.dest] == false) {
                        //vis[curr] = true;
                        q.push(e.dest);
                      System.out.println("stack" + q + " ");
                    }
                }
            }
        }
    }

}
