import java.util.*;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp;
        for(int i=0; i<nums.length; i++) {
            temp = new ArrayList<>();
            visited = new boolean[nums.length];
            visited[i] = true;
            temp.add(nums[i]);
            dfs(1, nums, visited, temp);
        }
        
        return answer;
    }

    private void dfs(int L, int[] nums, boolean[] visited, List<Integer> temp) {
        if(L == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                dfs(L + 1, nums, visited, temp);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}