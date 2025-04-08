package me.study.y2025.m04.sum_of_all_subset_xor_totals;

import java.util.Arrays;

public class SumofAllSubsetXORTotals {

    /*
        Complexidade =
        T(n) = O(1) + T(n-1) + T(n-1) + O(1)
        T(n) = 2T(n-1) + c
        T(n-1) = 2(2T(n-2) + c) + c = 4T(n-2) + 2c + c
        T(n-k) = 0
        T(n) = 2^n

        Time = O(2^n)
        Space = O(n) onde n = stack size
     */
    public static int subsetXORSum(int[] nums) {
        return getXORSum(nums, 0, 0);
    }

    public static int getXORSum(int[] nums, int index, int currentXOR) {
        if(nums.length == index)
            return currentXOR;

        int include = getXORSum(nums, index + 1, currentXOR ^ nums[index]); // T(n-1)
        int exclude = getXORSum(nums, index + 1, currentXOR); // T(n-1)

        return include + exclude;
    }

//    public static int subsetXORSum(int[] nums) {
//        int res = 0;
//
//        List<List<Integer>> subsets = getSubsets(nums); // T(n) = n * 2^(n-1)
//
//        for (List<Integer> subset : subsets){
//            int subsetRes = 0;
//            if(!subset.isEmpty()) {
//                subsetRes = subset.get(0);
//                for (int i = 1; i < subset.size(); i++) { //n[i]
//                    subsetRes = subsetRes ^ subset.get(i);
//                }
//            }
//            res += subsetRes;
//        }
//
//        return res;
//    }
//
//    public static List<List<Integer>> getSubsets(int[] nums){ // T(n) = n * 2^(n-1)
//        List<List<Integer>> subsets = new ArrayList<>();
//        int n = nums.length;
//
//        subsets.add(new ArrayList<>());
//
//        for (int num : nums) { // n
//            int size = subsets.size();
//            for (int j = 0; j < size; j++) { // i = 0 : 1, i = 1 : 2, i = 2 : 4, i = 3 : 8 ...  2^(n-1)
//                List<Integer> subset = new ArrayList<>(subsets.get(j));
//
//                subset.add(num);
//                subsets.add(subset);
//            }
//        }
//
//        return subsets;
//    }

    // ===== TEST CASES =====
    public static void main(String[] args) {
        System.out.println("=== Subset XOR Sum Tests ===");

        // Test Case 1: Exemplo do problema
        testCase(new int[]{1, 3}, 6, 1);

        // Test Case 2: Segundo exemplo do problema
        testCase(new int[]{5, 1, 6}, 28, 2);

        // Test Case 3: Terceiro exemplo do problema
        testCase(new int[]{3, 4, 5, 6, 7, 8}, 480, 3);

        // Test Case 4: Array vazio
        testCase(new int[]{}, 0, 4);

        // Test Case 5: Array com um elemento
        testCase(new int[]{10}, 10, 5);
    }

    private static void testCase(int[] nums, int expected, int testId) {
        System.out.printf("\nTest Case %d:%nInput: %s%n",
                testId, Arrays.toString(nums));

        long start = System.nanoTime();
        int result = subsetXORSum(nums);
        long duration = (System.nanoTime() - start) / 1000;

        System.out.printf("Expected: %d%nResult: %d%n", expected, result);
        System.out.printf("Time: %d μs%n", duration);

        if (result == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }
    }
}
