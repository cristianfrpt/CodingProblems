import time
from typing import List


def main():
    print("=== Partition Equal Subset Sum ===")
    test_case([1, 5, 11, 5], True, 1)
    test_case([1, 2, 3, 5], False, 2)


def test_case(nums, expected, test_id):
    print(f"\nTest Case {test_id}:")
    print(f"Input: {nums}")

    start = time.time()
    result = canPartition(nums)
    duration = (time.time() - start) * 1_000_000

    print(f"Expected: {expected}")
    print(f"Result: {result}")
    print(f"Time: {duration:.0f} μs")

    if result == expected:
        print("✅ PASS")
    else:
        print("❌ FAIL")


def canPartition(nums: List[int]) -> bool:
    total = sum(nums)

    if total % 2 != 0:
        return False

    target = total // 2
    dp = [False] * (target + 1)
    dp[0] = True

    for num in nums:
        for j in range(target, num - 1, -1):
            if dp[j - num]:
                dp[j] = True
        if dp[target]:
            return True

    return dp[target]


if __name__ == "__main__":
    main()
