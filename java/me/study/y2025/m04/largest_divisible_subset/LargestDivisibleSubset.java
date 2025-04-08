package me.study.y2025.m04.largest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxSize = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        Collections.reverse(res);
        return res;
    }


//
//    public static int getXORSum(int[] nums, int index, int currentXOR) {
//        if(nums.length == index)
//            return currentXOR;
//
//        int include = getXORSum(nums, index + 1, currentXOR ^ nums[index]); // T(n-1)
//        int exclude = getXORSum(nums, index + 1, currentXOR); // T(n-1)
//
//        return include + exclude;
//    }

//    public static List<Integer> largestDivisibleSubset(int[] nums) {
//        List<List<Integer>> subsets = getSubsets(nums);
//        List<Integer> result = new ArrayList<>();
//        int maxSize = 0;
//
//        for (List<Integer> subset : subsets) {
//            if (isDivisibleSubset(subset) && subset.size() > maxSize) {
//                maxSize = subset.size();
//                result = subset;
//            }
//        }
//
//        return result;
//    }
//
//    public static List<List<Integer>> getSubsets(int[] nums){
//        List<List<Integer>> subsets = new ArrayList<>();
//        int n = nums.length;
//        subsets.add(new ArrayList<>());
//
//        for(int i = 0; i < n; i++){
//            int num = nums[i];
//            int size = subsets.size();
//            for(int j = 0; j < size; j++){
//                List<Integer> subset = new ArrayList<>(subsets.get(j));
//                subset.add(num);
//                subsets.add(subset);
//            }
//        }
//
//        return subsets;
//    }
//
//    private static boolean isDivisibleSubset(List<Integer> subset) {
//        for (int i = 0; i < subset.size(); i++) {
//            for (int j = i + 1; j < subset.size(); j++) {
//                if (subset.get(i) % subset.get(j) != 0 && subset.get(j) % subset.get(i) != 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // ===== TEST CASES =====
    public static void main(String[] args) {
        System.out.println("=== Largest Divisible Subset Tests ===");

        // Test Case 1: Example from problem description
        testCase(new int[]{1,2,3}, Arrays.asList(1,2), 1);

        // Test Case 2: Second example from problem description
        testCase(new int[]{1,2,4,8}, Arrays.asList(1,2,4,8), 2);

        // Test Case 3: All prime numbers
        testCase(new int[]{2,3,5,7,11}, Arrays.asList(2), 3);

        // Test Case 4: Single element
        testCase(new int[]{5}, Arrays.asList(5), 4);

    }

    private static void testCase(int[] nums, List<Integer> expected, int testId) {
        System.out.printf("\nTest Case %d:%nInput: %s%n",
                testId, nums.length > 10 ?
                        Arrays.toString(Arrays.copyOf(nums, 10)) + "..." :
                        Arrays.toString(nums));

        long start = System.nanoTime();
        List<Integer> result = largestDivisibleSubset(nums);
        long duration = (System.nanoTime() - start) / 1000;

        System.out.printf("Expected: %s%nResult: %s%n", expected, result);
        System.out.printf("Time: %d μs%n", duration);

        if (result.equals(expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }
    }
}