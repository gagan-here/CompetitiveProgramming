package Blind75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    /**
     * Performs BFS on a graph starting from node 0.
     *
     * @param v   number of vertices in the graph (vertices are 0..v-1)
     * @param adj adjacency list where adj.get(i) contains neighbors of vertex i
     * @return list of vertices in BFS order starting from 0
     */
    public List<Integer> bfsOfGraph(int v, List<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    /**
     * Example main — reads a graph and prints BFS order starting from 0.
     * <p>
     * Input format:
     * First line: v e
     * Next e lines: u v   (edge between u and v) — 0-based vertices assumed
     * <p>
     * Example: <br>
     * 5 4 <br>
     * 0 1 <br>
     * 0 2 <br>
     * 1 3 <br>
     * 2 4 <br>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        // Initialize adjacency list
        List<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v) — 0-based indices:");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            // Assuming undirected graph; for directed, only add one direction
            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        BFS solver = new BFS();
        List<Integer> bfsOrder = solver.bfsOfGraph(v, adj);

        System.out.println("BFS traversal starting from node 0:");
        for (int node : bfsOrder) {
            System.out.print(node + " ");
        }
        System.out.println();

        sc.close();
    }
}
