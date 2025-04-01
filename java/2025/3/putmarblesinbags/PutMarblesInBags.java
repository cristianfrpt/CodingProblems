import java.util.Arrays;

public class PutMarblesInBags {

    /* Buscamos achar nesse problema a divisão com menor e maior peso.
       Porem o peso da sacola é sempre definido pelo valor do primeiro peso da sacola + peso do ultimo.
       Logo, é possivel encontrar a resposta somando os pares de pesos mais aptos k-1 vezes,
        que representaria a quantidade de cortes feitos no array weights.


        n = weights size
        Time: O(n log n)
        Space (n)
    */

    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || n == k) return 0;

        int[] pairWeights = new int[n-1];

        // Calcula o peso da divisão em pares para saber o peso de cada corte
        for (int i = 0; i < n-1; i++) {  //                O(n-1)
            pairWeights[i] = weights[i] + weights[i+1]; // * 1
        }

        Arrays.sort(pairWeights); //O(n log n)

        int  cuts = k-1;
        long min = 0;
        long max = 0;

        for (int i = 0; i < cuts; i++) { // O(k-1)
            min += pairWeights[i];  //           * 1
            max += pairWeights[n - 2 - i];  //   * 1
        }

        return max - min;
    }

    // ===== TESTES =====
    public static void main(String[] args) {
        System.out.println("=== Testes Put Marbles in Bags ===");

        testCase(new int[]{1, 3, 5, 1}, 2, 4, 1);
        testCase(new int[]{1, 3}, 2, 0, 2);
        testCase(new int[]{1, 3, 5, 6, 2, 8}, 2, 7, 2);
    }

    private static void testCase(int[] weights, int k, long expected, int testId) {
        long start = System.nanoTime();
        long result = putMarbles(weights, k);
        long duration = (System.nanoTime() - start) / 1000;

        System.out.printf("\nTeste %d:\nInput: %s, k=%d\n", testId, Arrays.toString(weights), k);
        System.out.printf("Resultado: %d (Esperado: %d)\n", result, expected);
        System.out.printf("Tempo: %d μs\n", duration);
        System.out.println(result == expected ? "✅ PASS" : "❌ FAIL");
    }
}