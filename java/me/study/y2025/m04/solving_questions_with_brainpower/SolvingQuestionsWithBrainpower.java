package me.study.y2025.m04.solving_questions_with_brainpower;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {

    /*
        Para resolver essa questão preciso selecionar quais melhores questões resolver, sabendo que a questão me
            impedirá de resolver as proximas (brainpower-i) questões

        A implementação percorre o array salvando a maior pontuação possivel para cada casa, acumulando a maior pontuação possivel em n.

        n = questions.length
        Time:  O(n)
        Space: O(n)
     */
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] answerValues = new long[n + 1];

        for (int i = 0; i < n; i++) { // O(n)
            answerValues[i + 1] = Math.max(answerValues[i + 1], answerValues[i]);

            int next = i + questions[i][1] + 1;
            if (next <= n) {
                answerValues[next] = Math.max(answerValues[next], answerValues[i] + questions[i][0]);
            } else {
                answerValues[n] = Math.max(answerValues[n], answerValues[i] + questions[i][0]);
            }
        }

        return answerValues[n];
    }

    // ===== TEST CASES =====
    public static void main(String[] args) {
        System.out.println("=== Solving Questions With Brainpower Tests ===");

        // Test Case 1: Example from problem description
        testCase(new int[][]{{3,2}, {4,3}, {4,4}, {2,5}}, 5, 1);

        // Test Case 2: Second example from problem description
        testCase(new int[][]{{1,1}, {2,2}, {3,3}, {4,4}, {5,5}}, 7, 2);

        // Test Case 3: Single question
        testCase(new int[][]{{5,2}}, 5, 3);

        // Test Case 4: All questions can be solved
        testCase(new int[][]{{1,0}, {2,0}, {3,0}}, 6, 4);

        // Test Case 5: Large test case (edge case)
        testCase(new int[100000][2], 0, 5); // Will need to be implemented properly
    }

    private static void testCase(int[][] questions, long expected, int testId) {
        System.out.printf("\nTest Case %d:%nInput: %s%n",
                testId, Arrays.deepToString(questions.length > 10 ?
                        Arrays.copyOf(questions, 10) : questions));

        long start = System.nanoTime();
        long result = mostPoints(questions);
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