import time
from typing import List

'''
    Precisamos encontrar o valor máximo da expressão ((nums[i]-nums[j]) * nums[k]) sendo que i < j < k.
    
    n = nums.length
    Time:  O(n^3)
    Space: O(n)
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


def maximumTripletValue(nums: List[int]) -> int:
    n = len(nums)
    maxTriplet = 0

    for i in range(n - 2):
        for j in range(i + 1, n - 1):
            for k in range(j + 1, n):
                maxTriplet = max(maxTriplet, (nums[i] - nums[j]) * nums[k])

    return maxTriplet


if __name__ == "__main__":
    main()
