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

    public int dfs(TreeNode root) {
        int lheight = 0;
        int rheight = 0;
        if(root == null) {
            return 0;
        }
        // 전위 : 루 -> 왼 -> 오
        lheight = dfs(root.left) + 1;
        rheight = dfs(root.right) + 1;
        return Math.max(lheight, rheight);
    }
}