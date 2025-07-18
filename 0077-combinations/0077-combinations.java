import java.util.*;

class Solution {
    boolean[] visited;
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        visited = new boolean[n + 1];
        List<Integer> temp = new ArrayList<>();
        dfs(0, n, visited, k, temp);

        return answer;
    }

    private void dfs(int L, int n, boolean[] visited, int k, List<Integer> temp) {
        if(L == k) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        int init = temp.isEmpty() ? 0 : temp.get(temp.size()-1);
        for(int i=init+1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(i);
                dfs(L+1, n, visited, k, temp);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}