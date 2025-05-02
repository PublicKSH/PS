import java.util.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int dist;
    
    Edge (int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
    
    @Override
    public String toString() {
        return "from : " + from + ", to : " + to + ", dist : " + dist;
    }
}

class Solution {
    static Edge[] edges;
    static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        edges = new Edge[costs.length];
        parents = new int[n];
        
        for (int i=0; i<n; i++) {
            parents[i] = -1;
        }
        
        for (int i=0; i<costs.length; i++) {
            edges[i] = new Edge(costs[i][0],costs[i][1],costs[i][2]);
        }
        
        int mergeCnt = 0;
        Arrays.sort(edges);
        for (Edge edge : edges) {
            // System.out.println(edge.toString());
            
            if (union(edge.from, edge.to)) {
                answer += edge.dist;
                mergeCnt++;
            }
            
            if (mergeCnt == n-1) {
                break;
            }
        }
        
        
        return answer;
    }
    
    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) {
            return false;
        }
        else {
            parents[b] = a;
            return true;
        }
    }
    
    public int find(int a) {
        if (parents[a] == -1) {
            return a;
        }
        
        return parents[a] = find(parents[a]);
    }
    
}