package Blind75.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void dfs(int node, boolean[] vis, List<ArrayList<Integer>> adj, List<Integer> ls) {
        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    public List<Integer> dfsOfGraph(int v, List<List<Integer>> adj) {
        ArrayList<Integer> ls = new ArrayList<>();

        if (v == 0) {
            return ls;
        }

        boolean[] vis = new boolean[v + 1];
        vis[0] = true;
        dfs(0, vis, adj, ls);

        return ls;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v) — 0-based indices:");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        DFS dfs = new DFS();
        List<Integer> dfsOrder = dfs.dfsOfGraph(vertex, adj);

        System.out.println("DFS traversal starting from node 0:");
        for (int node : dfsOrder) {
            System.out.print(node + " ");
        }
        System.out.println();

        sc.close();
    }
}

