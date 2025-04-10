import time
from typing import List


def main():
    print("=== Minimum Number of Operations to Make Elements in Array Distinct ===")
    test_case([5, 2, 5, 4, 5], 2, 2, 1)
    test_case([2, 1, 2], 2, -1, 2)
    test_case([9, 7, 5, 3], 1, 4, 3)


def test_case(nums, k, expected, test_id):
    print(f"\nTest Case {test_id}:")
    print(f"Input: {nums}, {k}")

    start = time.time()
    result = minimumOperations(nums, k)
    duration = (time.time() - start) * 1_000_000

    print(f"Expected: {expected}")
    print(f"Result: {result}")
    print(f"Time: {duration:.0f} μs")

    if result == expected:
        print("✅ PASS")
    else:
        print("❌ FAIL")


def minimumOperations(nums: List[int], k: int) -> int:
    hash_set = set()
    n = len(nums)

    for i in range(n):
        if nums[i] < k:
            return -1
        else:
            hash_set.add(nums[i])

    return len(hash_set) - 1 if k in hash_set else len(hash_set)


if __name__ == "__main__":
    main()
