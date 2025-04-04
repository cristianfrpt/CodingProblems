package me.study.y2025.m04.lowest_common_ancestor_of_deepest_leaves;

import java.util.*;

public class LowestCommonAncestorOfDeepestLeaves {

    /*
        O objetivo é encontrar o LCA que contem as folhas mais profundas da arvore.
        Basta percorrer a arvore, identificar o LCA mais profunto e retorna-lo.

        n = nodes.length
        Time: O(n)
        Space: O(n)
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    static int maxDepth = -1;
    static TreeNode res = null;

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        res = root;
        dfs(root, 0);
        return res;
    }


    public static int dfs(TreeNode root, int depth){
        if(root == null){
            maxDepth =  Math.max(depth ,maxDepth);
            return depth;
        }

        int ldmax = dfs(root.left, depth+1);
        int rdmax = dfs(root.right, depth+1);

        System.out.println("processando v:" + root.val + " d:" + depth + " maxd:" + maxDepth + " res: "+ res.val);
        if(ldmax == rdmax && ldmax == maxDepth){
            res = root;
        }
        return Math.max(ldmax, rdmax);
    }



    public static void main(String[] args) {
        System.out.println("=== Lowest Common Ancestor of Deepest Leaves Tests ===");

        // Test Case 1: Example from problem description
        testCase(createTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4}), 2, 1);

        // Test Case 2: Single node tree
        testCase(createTree(new Integer[]{1}), 1, 2);

        // Test Case 3: Deepest leaf is in right subtree
        testCase(createTree(new Integer[]{0,1,3,null,2}), 2, 3);

        // Test Case 4: Balanced tree with multiple deepest leaves
        testCase(createTree(new Integer[]{1,2,3,4,5,6,7}), 1, 4);

        // Test Case 5: Skewed tree
        testCase(createTree(new Integer[]{1,2,null,3,null,4,null}), 4, 5);
    }

    private static void testCase(TreeNode root, int expected, int testId) {
        System.out.printf("\nTest Case %d:%nInput Tree: %s%n",
                testId, treeToString(root));

        long start = System.nanoTime();
        TreeNode result = lcaDeepestLeaves(root);
        long duration = (System.nanoTime() - start) / 1000;

        System.out.printf("Expected LCA: %d%nResult: %s%n",
                expected, result != null ? result.val : "null");
        System.out.printf("Time: %d μs%n", duration);

        if (result != null && result.val == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }
    }

    // Helper method to create tree from level-order traversal array
    private static TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Helper method to convert tree to string representation
    private static String treeToString(TreeNode root) {
        if (root == null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add("null");
            }
        }

        // Remove trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            i--;
        }

        return result.subList(0, i + 1).toString();
    }

}

