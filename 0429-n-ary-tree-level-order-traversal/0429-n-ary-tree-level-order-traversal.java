/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
       

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++) {
                Node node = q.remove();
                if(node == null) return result;
                level.add(node.val);

                for(Node child : node.children) {
                    q.add(child);
                }
            }

            result.add(level);
        }

        return result;
    }
}