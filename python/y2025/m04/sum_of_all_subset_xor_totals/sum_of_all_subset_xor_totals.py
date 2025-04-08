import time
from typing import List


def main():
    print("=== Subset XOR Sum Tests ===")
    test_case([1, 3], 6, 1)
    test_case([5, 1, 6], 28, 2)
    test_case([3, 4, 5, 6, 7, 8], 480, 3)
    test_case([], 0, 4)
    test_case([10], 10, 5)


def test_case(nums, expected, test_id):
    print(f"\nTest Case {test_id}:")
    print(f"Input: {nums}")

    start = time.time()
    result = subset_xor_sum(nums)
    duration = (time.time() - start) * 1_000_000  # convertendo para microssegundos

    print(f"Expected: {expected}")
    print(f"Result: {result}")
    print(f"Time: {duration:.0f} μs")

    if result == expected:
        print("✅ PASS")
    else:
        print("❌ FAIL")


def subset_xor_sum(nums: List[int]) -> int:
    return get_xor_sum(nums, 0, 0)


def get_xor_sum(nums: List[int], index: int, current_xor: int) -> int:
    if len(nums) == index:
        return current_xor

    include = get_xor_sum(nums, index + 1, current_xor ^ nums[index])
    exclude = get_xor_sum(nums, index + 1, current_xor)

    return include + exclude


if __name__ == "__main__":
    main()
