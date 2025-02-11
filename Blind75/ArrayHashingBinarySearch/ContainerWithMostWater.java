package Blind75.ArrayHashingBinarySearch;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * Example 1:
 *
 * <pre>
 *  8 |     █                   █
 *  7 |     █                   █       █
 *  6 |     █   █               █       █
 *  5 |     █   █       █       █       █
 *  4 |     █   █       █   █   █       █
 *  3 |     █   █       █   █   █   █   █
 *  2 |     █   █   █   █   █   █   █   █
 *  1 | █   █   █   █   █   █   █   █   █
 *  0 +-----------------------------------
 *      1   2   3   4   5   6   7   8   9
 * </pre>
 *
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * <br> Output: 49
 * <br>
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water the container can contain is 49.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * <br>Output: 1
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;

        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);

            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3};
        int[] b = {3, 1, 2, 4, 5};

        System.out.println(maxArea(a));
        System.out.println(maxArea(b));
    }
}
