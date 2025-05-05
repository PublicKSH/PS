// 간선의 길이가 1이니까 BFS로 최단거리로 이동하면서 이동한 간선의 개수 CHECK
import java.util.*;


class Solution {
    static int INF = (int) 1e9;
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        // O(20000);
        for (int i=0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // O(50000);
        for (int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int answer = bfs(1, n, graph);
        
        return answer;
    }
    
    static int bfs(int startNode, int n, ArrayList<Integer>[] graph) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        int maxDist = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.offer(startNode);
        visited[startNode] = true;
        while(!que.isEmpty()) {
            Integer nowNode = que.poll();
            // System.out.println(nowNode);

            for (int nextNode : graph[nowNode]) {
                if (visited[nextNode]) {
                    continue;
                }
                
                
                dist[nextNode] = dist[nowNode] + 1;
                visited[nextNode] = true;
                maxDist = Math.max(maxDist, dist[nextNode]);
                que.offer(nextNode);
            }
        }
        
        // System.out.println(Arrays.toString(dist));
        int result = 0;
        for (int d : dist) {
            if (d == maxDist) {
                result++;
            }
        }
        return result;
    }
}