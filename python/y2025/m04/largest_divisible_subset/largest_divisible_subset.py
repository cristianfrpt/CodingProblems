import time
from typing import List


def main():
    print("=== Largest Divisible Subset Tests ===")
    test_case([1, 2, 3], [1, 2], 1)
    test_case([1, 2, 4, 8], [1, 2, 4, 8], 2)
    test_case([2, 3, 5, 7, 11], [2], 3)
    test_case([5], [5], 4)


def test_case(nums: List[int], expected: List[int], test_id):
    print(f"\nTest Case {test_id}:")
    print(f"Input: {nums}")

    start = time.time()
    result = largest_divisible_subset(nums)
    duration = (time.time() - start) * 1_000_000

    print(f"Expected: {expected}")
    print(f"Result: {result}")
    print(f"Time: {duration:.0f} μs")

    if result == expected:
        print("✅ PASS")
    else:
        print("❌ FAIL")


def largest_divisible_subset(nums: List[int]) -> List[int]:
    res = []
    nums.sort()
    n = len(nums)

    dp = [1] * n
    parent = [-1] * n

    max_size = 1
    imax = 0

    for i in range(1, n):
        for j in range(i):
            if nums[i] % nums[j] == 0 and dp[j] + 1 > dp[i]:
                dp[i] = dp[j] + 1
                parent[i] = j

        if dp[i] > max_size:
            max_size = dp[i]
            imax = i

    while imax != -1:
        res.append(nums[imax])
        imax = parent[imax]

    return res[::-1]


if __name__ == "__main__":
    main()
