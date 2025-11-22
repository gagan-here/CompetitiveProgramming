package Blind75.Graph;

import java.util.ArrayList;

public class DFS {
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ls = new ArrayList<>();

        if (V == 0) {
            return ls;
        }

        boolean vis[] = new boolean[V + 1];
        vis[0] = true;
        dfs(0, vis, adj, ls);

        return ls;
    }

}

