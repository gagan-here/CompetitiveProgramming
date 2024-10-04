package Blind75.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
 * The ball can go through the empty spaces by rolling <b>up, down, left, or right,</b> but it won’t
 * stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the m x n maze, the ball’s start position and the destination, where start = [start_row, start_col]
 * and destination = [destination_row, destination_col], return true if the ball can stop at the
 * destination, otherwise return false.
 * <p>
 * <b>Example - 1</b>
 * <p>
 * Maze layout:
 * 0 - Empty space
 * 1 - Wall
 * S - Start (Ball's starting position)
 * D - Destination (Goal position)
 * <p>
 * Maze representation:
 * <p> [0, 0, 1, 0, S]
 * <p> [0, 0, 0, 0, 0]
 * <p> [0, 0, 0, 1, 0]
 * <p> [1, 1, 0, 1, 1]
 * <p> [0, 0, 0, 0, D]
 *
 * <p><b>Input:</b> maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],
 * start = [0,4], destination = [4,4]
 * <p>
 * <b>Output:</b> true
 * <p>
 * <b>Explanation:</b> One possible way is: left -> down -> left -> down -> right -> down -> right.
 */

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;

        // Track visited positions in the maze
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        // Directions to move in the maze: up, down, left, right
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // when the ball is at destination i.e.  cur == destination
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }

            // Explore all four directions from the current position
            for (int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];

                // Continue moving in the current direction until hitting a wall or boundary
                while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                // Step back to the last valid position before the walli.e decrement x and y index
                // when you hit wall i.e. maze[x][y] = 1
                x -= dir[0];
                y -= dir[1];

                // If the new position has not been visited, add it to the queue
                if (!visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TheMaze solver = new TheMaze();

        // Define the maze (0 = open path, 1 = wall)
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        // Define the start and destination points
        int[] start = {0, 4};
        int[] destination = {4, 4};

        // Check if there is a path from start to destination
        boolean result = solver.hasPath(maze, start, destination);

        // Print the result
        if (result) {
            System.out.println("There is a path to the destination.");
        } else {
            System.out.println("There is no path to the destination.");
        }
    }
}
