package Blind75.Graph;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> dfsOfGraph(int v, List<ArrayList<Integer>> adj) {
        ArrayList<Integer> ls = new ArrayList<>();

        if (v == 0) {
            return ls;
        }

        boolean[] vis = new boolean[v + 1];
        vis[0] = true;
        dfs(0, vis, adj, ls);

        return ls;
    }
}

