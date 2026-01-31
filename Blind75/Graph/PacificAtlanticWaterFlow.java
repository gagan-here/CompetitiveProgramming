package Blind75.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    // {0, 1} → move right (same row, column + 1)
    // {0, -1} → move left (same row, column - 1)
    // {1, 0} → move down (row + 1, same column)
    //{-1, 0} → move up (row - 1, same column)
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return res;

    }
}
