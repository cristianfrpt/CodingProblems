import time
from typing import List

'''
    Reescrita em python do problema desenvolvido em java.
'''


def main() -> None:
    print("=== Testes Solving Questions With Brainpower ===")
    test_cases = [
        ([[3, 2], [4, 3], [4, 4], [2, 5]], 5, 1),
        ([[1, 1], [2, 2], [3, 3], [4, 4], [5, 5]], 7, 2),
        ([[5, 2]], 5, 3),
        ([[1, 0], [2, 0], [3, 0]], 6, 4)
    ]

    for questions, expected, test_id in test_cases:
        test_case(questions, expected, test_id)


def test_case(questions: List[List[int]], expected: int, test_id: int) -> None:
    print(f"\nTest Case {test_id}:\nInput: {questions}")

    start_time = time.perf_counter_ns()
    result = most_points(questions)
    elapsed_time = time.perf_counter_ns() - start_time

    print(f"Expected: {expected}")
    print(f"Result:   {result}")
    print(f"Time: {elapsed_time / 1000:.3f} μs")
    print("✅ PASS" if result == expected else "❌ FAIL")


def most_points(questions: List[List[int]]) -> int:
    n = len(questions)
    dp = [0] * (n + 1)

    for i in range(n):
        points, skip = questions[i]
        dp[i + 1] = max(dp[i + 1], dp[i])

        next_index = i + skip + 1

        if next_index <= n:
            dp[next_index] = max(dp[next_index], dp[i] + points)
        else:
            dp[n] = max(dp[n], dp[i] + points)

    return dp[n]


if __name__ == "__main__":
    main()

