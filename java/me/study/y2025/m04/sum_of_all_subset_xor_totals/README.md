# 1863. Sum of All Subset XOR Totals

**Difficulty:** Easy    
**Topics:** `Array` `Math` `Backtracking` `Bit Manipulation` `Combinatorics` `Enumeration`  
**LeetCode Link:** [Problem 1863](https://leetcode.com/problems/sum-of-all-subset-xor-totals/)

## Descrição do Problema

O XOR total de um array é definido como o XOR bit a bit de todos os seus elementos, ou 0 se o array estiver vazio.

- Por exemplo, o XOR total do array `[2,5,6]` é `2 XOR 5 XOR 6 = 1`.
- Dado um array `nums`, retorne a soma de todos os XOR totais para todos os subconjuntos de `nums`.

**Nota**: Subconjuntos com os mesmos elementos devem ser contados múltiplas vezes.

Um array `a` é um subconjunto de um array `b` se `a` pode ser obtido de `b` deletando alguns (possivelmente zero) elementos de `b`.

## Exemplos

### Exemplo 1
**Input:** `nums = [1,3]`  
**Output:** `6`  
**Explicação:**  
Os 4 subconjuntos de `[1,3]` são:
- O subconjunto vazio tem XOR total de 0.
- `[1]` tem XOR total de 1.
- `[3]` tem XOR total de 3.
- `[1,3]` tem XOR total de `1 XOR 3 = 2`.  
  `0 + 1 + 3 + 2 = 6`

### Exemplo 2
**Input:** `nums = [5,1,6]`  
**Output:** `28`  
**Explicação:**  
Os 8 subconjuntos de `[5,1,6]` são:
- O subconjunto vazio: 0
- `[5]`: 5
- `[1]`: 1
- `[6]`: 6
- `[5,1]`: `5 XOR 1 = 4`
- `[5,6]`: `5 XOR 6 = 3`
- `[1,6]`: `1 XOR 6 = 7`
- `[5,1,6]`: `5 XOR 1 XOR 6 = 2`  
  `0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28`

### Exemplo 3
**Input:** `nums = [3,4,5,6,7,8]`  
**Output:** `480`  
**Explicação:** A soma de todos os XOR totais para cada subconjunto é 480.

## Restrições
- `1 <= nums.length <= 12`
- `1 <= nums[i] <= 20`
