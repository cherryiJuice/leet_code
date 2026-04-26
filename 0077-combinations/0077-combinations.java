class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();

        dfs(n, k, 1, new ArrayList<>());

        return result;
    }

    void dfs(int n, int k, int start, List<Integer> temp) {
        if(temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++) {
            temp.add(i);
            dfs(n, k, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}