package Blind75;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] ints = TwoSum.twoSum(new int[]{1, 3, 5, 4}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
