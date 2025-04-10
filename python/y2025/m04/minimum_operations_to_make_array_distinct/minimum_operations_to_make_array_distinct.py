import time
from typing import List


def main():
    print("=== Minimum Number of Operations to Make Elements in Array Distinct ===")
    test_case([1, 2, 3, 4, 2, 3, 3, 5, 7], 2, 1)
    test_case([4, 5, 6, 4, 4], 2, 2)
    test_case([6, 7, 8, 9], 0, 3)


def test_case(nums, expected, test_id):
    print(f"\nTest Case {test_id}:")
    print(f"Input: {nums}")

    start = time.time()
    result = minimumOperations(nums)
    duration = (time.time() - start) * 1_000_000

    print(f"Expected: {expected}")
    print(f"Result: {result}")
    print(f"Time: {duration:.0f} μs")

    if result == expected:
        print("✅ PASS")
    else:
        print("❌ FAIL")


def minimumOperations(nums: List[int]) -> int:
    res = 0

    while True:
        if len(set(nums)) == len(nums):
            break

        remove_elements = min(3, len(nums))
        nums = nums[remove_elements:]
        res += 1

    return res


if __name__ == "__main__":
    main()
