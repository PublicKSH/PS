import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[][] dp;
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList<>();
        visited = new boolean[n+1];
        dp = new int[2][n+1];
        
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<lighthouse.length; i++) {
            graph.get(lighthouse[i][0]).add(lighthouse[i][1]);
            graph.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        dfs(1);
        return Math.min(dp[0][1],dp[1][1]);
    }
    
    static public void dfs(int node) {
        visited[node] = true;
    
        dp[0][node] = 0;
        dp[1][node] = 1;
        
        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
                
                dp[0][node] += dp[1][child];
                dp[1][node] += Math.min(dp[1][child], dp[0][child]);
            }
        }
    }
}