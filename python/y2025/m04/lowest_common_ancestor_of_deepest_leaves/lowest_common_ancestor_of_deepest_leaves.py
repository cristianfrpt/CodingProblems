import time
from typing import List, Optional

'''
    Reescrita em python do problema desenvolvido em java.
'''


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.max_depth = -1
        self.res = None

    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.res = root
        self.dfs(root, 0)
        return self.res

    def dfs(self, node: Optional[TreeNode], depth: int) -> int:
        if not node:
            self.max_depth = max(self.max_depth, depth)
            return depth

        ld = self.dfs(node.left, depth + 1)
        rd = self.dfs(node.right, depth + 1)

        if ld == rd and ld == self.max_depth:
            self.res = node

        return max(ld, rd)


def main() -> None:
    print("=== Lowest Common Ancestor of Deepest Leaves Tests ===")
    test_cases = [
        ([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4], 2, 1),
        ([1], 1, 2),
        ([0, 1, 3, None, 2], 2, 3),
        ([1, 2, 3, 4, 5, 6, 7], 1, 4),
        ([1, 2, None, 3, None, 4, None], 4, 5)
    ]

    for nodes, expected, test_id in test_cases:
        root = createTree(nodes)
        test_case(root, expected, test_id)


def test_case(root: Optional[TreeNode], expected: int, test_id: int) -> None:
    print(f"\nTest Case {test_id}:\nInput: {treeToString(root)}")

    start_time = time.perf_counter_ns()
    solution = Solution()
    result_node = solution.lcaDeepestLeaves(root)
    result = result_node.val if result_node else None
    elapsed_time = time.perf_counter_ns() - start_time

    print(f"Expected: {expected}")
    print(f"Result:   {result}")
    print(f"Time: {elapsed_time / 1000:.3f} μs")
    print("✅ PASS" if result == expected else "❌ FAIL")


def createTree(nodes: List[Optional[int]]) -> Optional[TreeNode]:
    if not nodes or nodes[0] is None:
        return None

    root = TreeNode(nodes[0])
    queue = [root]
    i = 1

    while queue and i < len(nodes):
        current = queue.pop(0)

        if i < len(nodes) and nodes[i] is not None:
            current.left = TreeNode(nodes[i])
            queue.append(current.left)
        i += 1

        if i < len(nodes) and nodes[i] is not None:
            current.right = TreeNode(nodes[i])
            queue.append(current.right)
        i += 1

    return root


def treeToString(root: Optional[TreeNode]) -> List[str]:
    if not root:
        return []

    result = []
    queue = [root]

    while queue:
        node = queue.pop(0)

        if node:
            result.append(str(node.val))
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append("null")

    while len(result) > 0 and result[-1] == "null":
        result.pop()

    return result


if __name__ == "__main__":
    main()
