import time
from typing import List

'''
    Reescrita em python do problema desenvolvido em java.
'''


def main() -> None:
    print("=== Testes Put Marbles in Bags ===")
    test_cases = [
        ([1, 3, 5, 1], 2, 4, 1),
        ([1, 3], 2, 0, 2),
        ([1, 3, 5, 6, 2, 8], 2, 7, 2)
    ]

    for weights, k, expected, test_id in test_cases:
        test_case(weights, k, expected, test_id)


def test_case(weights: List[int], k: int, expected: int, test_id: int) -> None:
    print(f"\nTest Case {test_id}:\nInput: {weights}")

    start_time = time.perf_counter_ns()
    result = putMarbles(weights, k)
    elapsed_time = time.perf_counter_ns() - start_time

    print(f"Expected: {expected}")
    print(f"Result:   {result}")
    print(f"Time: {elapsed_time / 1000:.3f} μs")
    print("✅ PASS" if result == expected else "❌ FAIL")


def putMarbles(weights: List[int], k: int) -> int:
    n = len(weights)
    if k == 1 or n == k:
        return 0

    pair_weights = [weights[i] + weights[i + 1] for i in range(n - 1)]
    pair_weights.sort()

    cuts = k - 1
    min_sum = sum(pair_weights[:cuts])
    max_sum = sum(pair_weights[-cuts:]) if cuts > 0 else 0

    return max_sum - min_sum


if __name__ == "__main__":
    main()
