package Blind75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
 *
 * <p><b>graph:</b></p>
 * Represents a directed graph where each course points to the courses that depend on it.
 *
 * <p>The graph is implemented as an array of ArrayLists. Each index in the array corresponds
 * to a course, and the list at graph[i] contains all the courses that have course 'i' as a prerequisite.
 * This helps in visualizing course dependencies and managing course ordering.</p>
 *
 * <p><b>degree:</b></p>
 * Stores the number of prerequisites (incoming edges) for each course.
 *
 * <p>The degree array helps track how many prerequisites a course has. A course with an
 * indegree of 0 means that it has no dependencies and can be taken immediately. This array is
 * updated dynamically as courses are processed.</p>
 *
 * <p><b>queue:</b></p>
 * A queue used to perform Breadth-First Search (BFS) on the course dependency graph.
 *
 * <p>The queue initially contains all courses with no prerequisites (indegree 0).
 * As we process courses, we remove them from the queue, reduce the indegree of dependent courses,
 * and add newly eligible courses (with indegree 0) to the queue.</p>
 */

public class CourseSchedule {

    // implementation using breadth first search

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        e.g. prerequisites = {{1, 0}, {0, 1}}
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        // Build the graph and fill in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            degree[prereq]++;
            graph[course].add(prereq);
        }

        for (int i = 0; i < degree.length; i++) {
            // If a course’s indegree is 0 (meaning it has no prerequisites),
            // we add it to the queue because it can be taken immediately.
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        // Process the courses using BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : graph[course]) {
                degree[nextCourse]--;
                if (degree[nextCourse] == 0) {
                    queue.add(nextCourse);
                    count++;
                }
            }
        }

        return count == numCourses;
    }

    // Main method to test the canFinish function
    public static void main(String[] args) {

        // numCourses = highest course + 1.
        // In {{1, 0}, {0, 1}}, highest course is 1. So, numcourses = 1 + 1 = 2

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        boolean result1 = canFinish(numCourses1, prerequisites1);
        System.out.println("Can finish all courses (Example 1)? " + result1);

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean result2 = canFinish(numCourses2, prerequisites2);
        System.out.println("Can finish all courses (Example 2)? " + result2);

        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}};
        boolean result3 = canFinish(numCourses3, prerequisites3);
        System.out.println("Can finish all courses (Example 3)? " + result3);
    }
}
