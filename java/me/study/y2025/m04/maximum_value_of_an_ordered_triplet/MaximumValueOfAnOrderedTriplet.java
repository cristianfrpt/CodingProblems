package me.study.y2025.m04.maximum_value_of_an_ordered_triplet;

import java.util.Arrays;

public class MaximumValueOfAnOrderedTriplet {

    /*
        Precisamos encontrar o valor máximo da expressão (nums[i]-nums[j])*nums[k] sendo que i < j < k.
        n = nums.length
        Time:  O(n^3)
        Space: O(1)
     */

    /*
    public static int maximumTripletValue(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        int maxTriplet = 0;

        for (int i = 0; i < n-2; i++) { // O(n)
            for (int j = i + 1; j < n-1; j++) {// * O(n)
                for (int k = j + 1; k < n; k++) {// * O(n)
                    int value = (nums[i] - nums[j]) * nums[k];
                    maxTriplet = Math.max(maxTriplet, value);
                }
            }
        }

        return maxTriplet;
    }
    */

    /*
        Otimização:
        Repare que ao percorrer nums[] e computar na ordem resultado > diferençaMaxima > iMaximo a regra (i > j > k)
            é respeitada, visto que:
            - O calculo do resultado esta em t+2 pois depende diffMaxima de t+1, porém usa até num[n] como k
            - O calculo da diferença (num[i] - num[j]) está em t+1 pois depende de iMaximo de t
            - O calculo de iMaximo é obtido em t, usa valores de [0..t] onde t = n

        É um jogo de dependencias, onde a dependencias dos calculos respeitam a regra.

        n = nums.length
        Time:  O(n)
        Space: O(1)
    */
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        long resultadoMaximo = 0;
        int iMaximo = 0, diffMaximo = 0;

        for (int num : nums){
            resultadoMaximo = Math.max(resultadoMaximo, (long) diffMaximo * num);
            diffMaximo = Math.max(diffMaximo, iMaximo - num);
            iMaximo = Math.max(iMaximo, num);
        }

        return  resultadoMaximo;
    }

    // ===== TEST CASES =====
    public static void main(String[] args) {
        System.out.println("=== Maximum Value of an Ordered Triplet I Tests ===");

        // Test Case 1: Example from problem description
        testCase(new int[]{12,6,1,2,7}, 77, 1);

        // Test Case 2: Second example from problem description
        testCase(new int[]{1,10,3,4,19}, 133, 2);

        // Test Case 3: All triplets have negative values
        testCase(new int[]{1,2,3}, 0, 3);

        // Test Case 4: Edge case - minimum array size
        testCase(new int[]{5,5,5}, 0, 4);

        // Test Case 5: Large array test
        testCase(new int[100], 0, 5); // Array de zeros
    }

    private static void testCase(int[] nums, int expected, int testId) {
        System.out.printf("\nTest Case %d:%nInput: %s%n",
                testId, nums.length > 10 ?
                        Arrays.toString(Arrays.copyOf(nums, 10)) + "..." :
                        Arrays.toString(nums));

        long start = System.nanoTime();
        long result = maximumTripletValue(nums);
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