package Blind75.Graph;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [ <br>
 * ["1","1","1","1","0"], <br>
 * ["1","1","0","1","0"], <br>
 * ["1","1","0","0","0"], <br>
 * ["0","0","0","0","0"] <br>
 * ] <p>
 * <p>
 * Output: 1 <p>
 * Example 2: <br>
 * Input: grid = [ <br>
 * ["1","1","0","0","0"], <br>
 * ["1","1","0","0","0"], <br>
 * ["0","0","1","0","0"], <br>
 * ["0","0","0","1","1"] <br>
 * ] <br>
 * Output: 3
 */
public class NumberOfIslands {

    /**
     * We will use Depth-First Search (DFS) approach to solve this problem.
     * <p>
     * <br>
     * The DFS approach involves exploring each cell in the grid. When encountering a '1' (representing land), it signifies the start of a new island. The goal is to explore and mark all connected land cells (forming an island) using recursive DFS.
     * <p>
     * 1. DFS Function: Define a recursive markCurrentIsland function that takes the grid, the current cell coordinates (i, j),
     * row size and column size as parameters.
     * <li>If the cell is out of the grid boundaries or not land ('1'), simply return.</li>
     * <li>Mark the current cell as visited by changing it from '1' to '0'.</li>
     * <li>Recursively call markCurrentIsland for the neighboring cells (up, down, left, right) to explore
     * and mark all connected land cells.</li>
     * <p>
     * 2. Main Function:
     * <li>Iterate through each cell in the grid.</li>
     * <li>When encountering an unvisited '1', increment the island count and trigger markCurrentIsland to explore and mark all connected land cells belonging to this island.</li>
     */

    static int totalIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    markCurrentIsland(grid, i, j, rowSize, colSize);
                }
            }
        }
        return numIslands;
    }

    static void markCurrentIsland(char[][] grid, int i, int j, int rowSize, int colSize) {

        // Check for boundaries and if the current cell is water or already visited
        if (i < 0 || j < 0 || i >= rowSize || j >= colSize || grid[i][j] != '1') {
            return;
        }

        // Since current cell has value "1" which is a "land", so we will
        // mark it as visited by changing it's value from 1 to 0
        grid[i][j] = '0';

        // Visit all adjacent cells (up, down, left, right)
        markCurrentIsland(grid, i + 1, j, rowSize, colSize); // traverse down
        markCurrentIsland(grid, i - 1, j, rowSize, colSize); // traverse up
        markCurrentIsland(grid, i, j - 1, rowSize, colSize); // traverse left
        markCurrentIsland(grid, i, j + 1, rowSize, colSize); // traverse right
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int total = totalIslands(grid);
        System.out.println("Number of islands is : " + total);
    }
}
