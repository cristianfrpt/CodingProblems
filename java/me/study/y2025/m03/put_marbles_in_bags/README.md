# 🏷 2551. Put Marbles in Bags

**Difficulty:** Hard  
**Tags:** `Greedy`, `Sorting`, `Priority Queue`  
**Companies:** Google, Amazon  
**LeetCode Link:** [Problem 2551](https://leetcode.com/problems/put-marbles-in-bags/)

## 📝 Problem Description

You have `k` bags and an array `weights` where `weights[i]` is the weight of the `i-th` marble. Divide the marbles into `k` bags following these rules:

1. No bag is empty.
2. If marbles `i` and `j` are in the same bag, all marbles between them must also be in that bag.
3. The cost of a bag containing marbles from `i` to `j` is `weights[i] + weights[j]`.

Return **the difference** between the **maximum** and **minimum** possible total cost across all distributions.

### Examples

**Example 1:**
```plaintext
Input: weights = [1,3,5,1], k = 2
Output: 4
Explanation:
- Minimal score: [1], [3,5,1] → (1+1) + (3+1) = 6
- Maximal score: [1,3], [5,1] → (1+3) + (5+1) = 10
Difference: 10 - 6 = 4
```

**Example 2:**
```plaintext
Input: weights = [1,3], k = 2
Output: 0
Explanation: Only one possible distribution.
```