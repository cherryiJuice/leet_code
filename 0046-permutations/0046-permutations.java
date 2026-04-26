import java.util.*;
class Solution {
    List<List<Integer>> result;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        
        dfs(nums, new ArrayList<>());
        return result;
    }

    void dfs(int[] nums, List<Integer> temp) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                dfs(nums, temp);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}