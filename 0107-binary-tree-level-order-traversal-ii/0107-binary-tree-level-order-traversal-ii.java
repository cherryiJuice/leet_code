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

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode poll = q.poll();
                sub.add(poll.val);

                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
            }

            if (!sub.isEmpty()) {
                result.add(sub);
            }
        }

        Collections.reverse(result);

        return result;
    }
}