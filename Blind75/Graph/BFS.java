package Blind75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Performs a Breadth-First Search (BFS) traversal on a graph starting from vertex 0.
 *
 * <p>The graph is represented as an adjacency list, where each index corresponds
 * to a vertex and contains a list of its neighbors. The method returns the order
 * in which vertices are visited.</p>
 */

public class BFS {
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
}
