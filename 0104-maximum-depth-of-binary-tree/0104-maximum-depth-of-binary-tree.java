public class TreeNode {
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
 
class Solution {
    int depth = 0;
    public int maxDepth(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int L=0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode curNode = queue.remove();
                if(curNode.left != null) {
                    queue.add(curNode.left);
                }

                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            L++;
        }
        return L;
    }
}