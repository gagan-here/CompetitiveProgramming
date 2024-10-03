package Blind75.Graph;

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
 *
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
}
