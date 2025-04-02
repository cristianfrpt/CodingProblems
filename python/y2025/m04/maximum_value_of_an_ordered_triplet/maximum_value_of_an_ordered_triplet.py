import time
from typing import List

'''
    Precisamos encontrar o valor máximo da expressão ((nums[i]-nums[j]) * nums[k]) sendo que i < j < k.
    
    n = nums.length
    Time:  O(n^3)
    Space: O(1)
'''

def main() -> None:
    print("=== Maximum Value of an Ordered Triplet I Tests ===")
    test_cases = [
        ([12, 6, 1, 2, 7], 77, 1),
        ([1, 10, 3, 4, 19], 133, 2),
        ([1, 2, 3], 0, 3),
        ([5, 5, 5], 0, 4)
    ]

    for nums, expected, test_id in test_cases:
        test_case(nums, expected, test_id)


def test_case(nums: List[int], expected: int, test_id: int) -> None:
    print(f"\nTest Case {test_id}:\nInput: {nums}")

    start_time = time.perf_counter_ns()
    result = maximumTripletValue(nums)
    elapsed_time = time.perf_counter_ns() - start_time

    print(f"Expected: {expected}")
    print(f"Result:   {result}")
    print(f"Time: {elapsed_time / 1000:.3f} μs")
    print("✅ PASS" if result == expected else "❌ FAIL")

'''
    Otimização:
    Repare que ao percorrer nums[] e computar na ordem res > dmax > imax a regra (i > j > k) é respeitada, visto que:
    
    - O calculo res está em t+2 pois depende diffMaxima de t+1, entretanto usa até num[n] como k
    - O calculo dmax (num[i] - num[j]) está em t+1 pois depende de imax de t
    - O imax é obtido em t, usa valores de [0..t] onde t = n
    
    É um jogo de dependencias, onde a dependencias dos calculos respeitam a regra.
    
    n = nums.length
    Time:  O(n)
    Space: O(1)
'''

def maximumTripletValue(nums: List[int]) -> int:
    res = imax = dmax = 0

    for num in nums:
        res = max(res, dmax * num)
        dmax = max(dmax, (imax - num))
        imax = max(imax, num)

    return res


if __name__ == "__main__":
    main()
