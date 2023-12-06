package com.demo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgo {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src= s;
            this.dest= d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
    }
    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start){

        Queue<Integer> q = new LinkedList<>(); //create the queue

        q.add(start);//any starting point
        while(!q.isEmpty()){
            int curr= q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i=0; i< graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr]= true;

        for(int i=0; i< graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph, e.dest, vis);
            }
        }
    }

    //print all paths from source to target using DFS:
    /*
    - we will first print the path
    - we will keep track of that path using a string
    dfs(graph, vis[], curr, String path, target)
        if current node is same as target
            print that path
         for(i to graph[curr].size) //gives us all the neighbors
            Edge e = graph[curr].get(i)
            if(vis[e.des] == false)
                make the current visited as true
                dfs(graph, vis, e.dist, path+ e.dest, tar)
                make the current visited as false for backtracking
     - Time: O(V^V)
     */
    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar){
        //base case: if current node is same as target print the path
        if(curr == tar){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr]= true;
                printAllPath(graph, vis, e.dest, path+e.dest, tar);
                vis[curr]= false;
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

//        boolean vis[] = new boolean[V];//create visitor array
//        for(int i= 0; i< V; i++){
//            if(vis[i]==false){
//                dfs(graph, i, vis);
//            }
//        }
        int src= 0, tar= 5;
        printAllPath(graph, new boolean[V], src, "0", tar);
    }
}
