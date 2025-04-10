import time


def main():
    print("=== Number of Powerful Integers ===")
    test_case(1, 6000, 4, "124", 5, 1)
    test_case(15, 215, 6, "10", 2, 2)
    test_case(1000, 2000, 4, "3000", 0, 3)


def test_case(start, finish, limit, s, expected, test_id):
    print(f"\nTest Case {test_id}:")
    print(f"Input: start={start}, finish={finish}, limit={limit}, s='{s}'")

    start_time = time.time()
    result = numberOfPowerfulInt(start, finish, limit, s)
    duration = (time.time() - start_time) * 1_000_000

    print(f"Expected: {expected}")
    print(f"Result: {result}")
    print(f"Time: {duration:.0f} μs")

    if result == expected:
        print("✅ PASS")
    else:
        print("❌ FAIL")


# TODO Refatorar com DP
def numberOfPowerfulInt(start: int, finish: int, limit: int, s: str) -> int:
    s_int = int(s)
    s_len = len(s)
    if finish < s_int:
        return 0

    res = 0
    i = max(start, s_int)
    power = 10 ** s_len

    while i <= finish:
        str_i = str(i)
        if str_i.endswith(s):
            if all(int(d) <= limit for d in str(str_i)[:-s_len]):
                res += 1
                i += power
                continue
        i += 1

    return res


if __name__ == "__main__":
    main()
