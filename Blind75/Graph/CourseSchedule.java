package Blind75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. <br>
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that <br>
 * you must take course bi first if you want to take course ai. <br>
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1. <br>
 * Return true if you can finish all courses. Otherwise, return false. <br>
 * <p>
 * <b>Example 1:</b>
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]] <br>
 * Output: true <br>
 * Explanation: There are a total of 2 courses to take. <br>
 * To take course 1 you should have finished course 0. So it is possible. <br>
 * <p>
 * <b>Example 2:</b>
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] <br>
 * Output: false <br>
 * Explanation: There are a total of 2 courses to take. <br>
 * To take course 1 you should have finished course 0, and to take course 0 <br>
 * you should also have finished course 1. So it is impossible. <br>
 */
public class CourseSchedule {

    // implementation using breadth first search

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if (count == numCourses)
            return true;
        else
            return false;
    }

    // Main method to test the canFinish function
    public static void main(String[] args) {

        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        boolean result1 = canFinish(numCourses1, prerequisites1);
        System.out.println("Can finish all courses (Example 1)? " + result1);

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean result2 = canFinish(numCourses1, prerequisites2);
        System.out.println("Can finish all courses (Example 1)? " + result2);

        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}};
        boolean result3 = canFinish(numCourses2, prerequisites3);
        System.out.println("Can finish all courses (Example 2)? " + result3);
    }
}
