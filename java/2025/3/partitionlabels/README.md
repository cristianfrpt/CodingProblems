# 🏷 763. Partition Labels

**Difficulty:** Medium  
**Tags:** `Greedy`, `Hash Table`, `Two Pointers`  
**LeetCode Link:** [Problem 763](https://leetcode.com/problems/partition-labels/)

## 📝 Problem Description

Given a string `s`, partition it into as many parts as possible so that each character appears in at most one part. The concatenation of all parts should reconstruct the original string.

Return a list of integers representing the sizes of these parts.

### Examples

**Example 1:**
```plaintext
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
```

**Example 2:**
```plaintext
Input: s = "eccbbbbdec"
Output: [10]
```