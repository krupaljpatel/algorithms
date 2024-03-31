package src.com.kp.graph;
import  java.util.*;
/*
This is to find all the articulation points/cutting nodes in a graph in a network.
Definition : If we remove the cutting node, the graph splits into multiple components.

 */
public class ArticulationPoint {
    private static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void main(String args[]){
        int V = 5;
        List<Edge> adj[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i] =  new ArrayList();
        }
        createGraph(adj);
        //we need following variables.
        int dist[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        List<Integer> ap = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!vis[i]) {
                dfs(adj, 0, -1, dist, low, ap,vis,0);
            }
        }
        for(int j=0;j<ap.size();j++){
                System.out.println("AP:"+  ap.get(j));
        }


    }

    private static void dfs(List<Edge>[] adj, int curr, int par, int[] dist, int[] low, List<Integer> ap, boolean[] vis,int time) {
        vis[curr] = true;
        int child = 0;
        dist[curr]=low[curr]=++time;
        for(int i=0;i<adj[curr].size();i++){
            Edge e  = adj[curr].get(i);
            //int src = e.src;
            int dest = e.dest;
            if(curr == par){
                continue;
            }// if !parent , if its visited , low fro
            else if(vis[dest]){
                low[curr] = Math.min(low[curr],dist[dest]);
            }
            else if(!vis[dest]){
                child++;
                dfs(adj,dest,curr,dist,low,ap,vis,time);
                low[curr] = Math.min(low[curr],low[dest]);
                if(dist[curr]<=low[dest] && (par!=-1)){
                    ap.add(curr);
                }
            }
        }
        if(par==-1 && child>1){
            ap.add(curr);
        }
        return;
    }

    private static void createGraph(List<Edge>[] adj) {
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
