# 2999. Count the Number of Powerful Integers

**Difficulty:** Hard    
**Topics:** `Math` `String` `Dynamic Programming`  
**LeetCode Link:** [Problem 2999](https://leetcode.com/problems/count-the-number-of-powerful-integers/)

## Problem Description
You are given three integers `start`, `finish`, and `limit`. You are also given a string `s` representing a positive integer.

A positive integer `x` is called **powerful** if:
1. It ends with `s` (i.e., `s` is a suffix of `x`)
2. Each digit in `x` is at most `limit`

Return the total number of powerful integers in the range `[start..finish]`.

### Examples

#### Example 1:
**Input**: `start = 1`, `finish = 6000`, `limit = 4`, `s = "124"`  
**Output**: `5`  
**Explanation**: The powerful integers are 124, 1124, 2124, 3124, and 4124. All have digits ≤ 4 and end with "124".

#### Example 2:
**Input**: `start = 15`, `finish = 215`, `limit = 6`, `s = "10"`  
**Output**: `2`  
**Explanation**: The powerful integers are 110 and 210. Both have digits ≤ 6 and end with "10".

#### Example 3:
**Input**: `start = 1000`, `finish = 2000`, `limit = 4`, `s = "3000"`  
**Output**: `0`  
**Explanation**: No numbers in [1000..2000] can end with "3000".

### Constraints
- `1 <= start <= finish <= 10^15`
- `1 <= limit <= 9`
- `1 <= s.length <= floor(log10(finish)) + 1`
- `s` only consists of digits ≤ `limit`
- `s` has no leading zeros
