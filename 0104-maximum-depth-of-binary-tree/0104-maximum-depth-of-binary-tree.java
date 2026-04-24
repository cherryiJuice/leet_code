/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs (TreeNode node) {
        if(node == null) return 0;
        int max = 0;
        max = Math.max(max, dfs(node.left));
        max = Math.max(max, dfs(node.right));
        return max + 1;
    }
}