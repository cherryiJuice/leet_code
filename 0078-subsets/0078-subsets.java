import java.util.*;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return answer;
    }

    private void dfs(int L, int[] nums, List<Integer> temp) {
        answer.add(new ArrayList<>(temp));

        for(int i=L; i<nums.length; i++) {
            temp.add(nums[i]);
            dfs(i + 1, nums, temp);
            temp.remove(temp.size()-1);
        }
    }
}