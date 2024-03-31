package src.com.kp.graph;

import java.util.ArrayList;
import java.util.List;



//1202 // 1217
public class Bridge {
    public static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;

        }
    }
    public static void main(String args[]){
        int v=5;
        List<Edge>[] adj = new ArrayList[v];
        createGraph(adj);
        int[] dist = new int[v];
        int[] low = new int[v];
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                bridge(adj,0,-1,dist,low,vis,0);
            }
        }

    }

    private static void bridge(List<Edge>[] adj, int curr, int par, int[] dist, int[] low, boolean[] vis,int time) {
        vis[curr]=true;
        dist[curr]=low[curr]=++time;
        for(int i=0;i<adj[curr].size();i++){
            Edge e = adj[curr].get(i);
            int neigh = e.dest;
            if(neigh == par){
                continue;
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr],dist[neigh]);
            }
            else if(!vis[neigh]){
                bridge(adj,neigh,curr,dist,low,vis,time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dist[curr] < low[neigh]){
                    System.out.println("Src:"+curr +":dest :"+neigh);
                }
            }
        }
    }

    private static void createGraph(List<Edge> adj[]){
        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }
        adj[0].add(new Edge(0,1));
        adj[0].add(new Edge(0,2));
        adj[0].add(new Edge(0,3));

        adj[1].add(new Edge(1,0));
        adj[1].add(new Edge(1,2));

        adj[2].add(new Edge(2,0));
        adj[2].add(new Edge(2,1));

        adj[3].add(new Edge(3,0));
        adj[3].add(new Edge(3,4));

        adj[4].add(new Edge(4,3));

    }
}
