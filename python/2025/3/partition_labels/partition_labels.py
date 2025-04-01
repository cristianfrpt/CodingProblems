import time
from typing import List

'''
    Reescrita em python do problema desenvolvido em java.
'''


def main() -> None:
    print("=== Partition Labels Tests ===")
    test_cases = [
        ("ababcbacadefegdehijhklij", [9, 7, 8], 1),
        ("eccbbbbdec", [10], 2),
        ("abcdefg", [1, 1, 1, 1, 1, 1, 1], 3),
        ("aabbaabb", [8], 4),
        ("", [], 5)
    ]

    for s, expected, test_id in test_cases:
        testPartition(s, expected, test_id)


def testPartition(input_str: str, expected: List[int], testId: int) -> None:
    print(f"\nTest Case {testId}:\nInput: {input_str}")

    start_time = time.perf_counter_ns()
    result = partitionLabels(input_str)
    elapsed_time = time.perf_counter_ns() - start_time

    print(f"Expected: {expected}")
    print(f"Result:   {result}")
    print(f"Time: {elapsed_time / 1000:.3f} μs")
    print("✅ PASS" if result == expected else "❌ FAIL")


def partitionLabels(s: str) -> List[int]:
    partitions = []
    n = len(s)
    i = 0

    while i < n:
        current = s[i]
        last_index = s.rfind(current)

        for j in range(i + 1, last_index):
            last_index = max(last_index, s.rfind(s[j]))

        partitions.append(s[i:last_index + 1])
        i = (last_index + 1)

    return [len(partition) for partition in partitions]


if __name__ == "__main__":
    main()
