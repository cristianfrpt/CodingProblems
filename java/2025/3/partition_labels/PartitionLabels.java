import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PartitionLabels {

    /* Buscamos nesse problema separar a string no maior numero de partições onde as letras de uma partição
        não se existam em nenhuma outra partição.
       Basta criar a partição da letra corrente e verificar se há algum letra de dentro dessa partição em um local
        mais distante na string, se sim, aumentar a partição até a ultima ocorrecia dessas ocorrencias.

        n = s.length

        Time: O(n^2)
        Space (n)
    */

    public static List<Integer> partitionLabels(String s) {
        List<String> partitions = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) { //O(n)
            //Busca ultimo index da letra
            char current = s.charAt(i);
            int lastIndex = s.lastIndexOf(current);

            //Busca ultimo index real do trecho selecionado
            for (int j = i + 1; j < lastIndex; j++) { //* O(n)
                char inner = s.charAt(j);
                int innerLastIndex = s.lastIndexOf(inner);
                if(innerLastIndex > lastIndex) {
                    lastIndex = innerLastIndex;
                }
            }

            //Adiciona a particao encontrada
            partitions.add(s.substring(i, lastIndex+1));
            i = lastIndex+1;
        }

        return partitions.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    // ===== TEST CASES =====
    public static void main(String[] args) {
        System.out.println("=== Partition Labels Tests ===");

        testPartition("ababcbacadefegdehijhklij", Arrays.asList(9,7,8), 1);

        testPartition("eccbbbbdec", Arrays.asList(10), 2);

        testPartition("abcdefg", Arrays.asList(1,1,1,1,1,1,1), 3);

        testPartition("aabbaabb", Arrays.asList(8), 4);

        testPartition("", Arrays.asList(), 5);
    }

    private static void testPartition(String input, List<Integer> expected, int testId) {
        System.out.printf("\nTest Case %d:%nInput: \"%s\"%n", testId, input);

        long startTime = System.nanoTime();
        List<Integer> result = partitionLabels(input);
        long endTime = System.nanoTime();

        System.out.println("Expected: " + expected);
        System.out.println("Result:   " + result);
        System.out.printf("Time: %d μs%n", (endTime - startTime) / 1000);

        if (result.equals(expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }
    }
}