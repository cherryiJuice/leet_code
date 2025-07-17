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
    int answer;
    public int maxDepth(TreeNode root) {
        answer = 0;
        return dfs(root);
        // return answer;
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