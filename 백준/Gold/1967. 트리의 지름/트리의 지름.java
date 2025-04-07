
// 트리의 지름 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
	int to;
	int dist;

	Edge(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static ArrayList<ArrayList<Edge>> tree;
	static boolean[] visited;
	static int[] rootToNodeDist;
	static int[] farNodeToNodeDist;

	static public void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		visited = new boolean[N + 1];
		rootToNodeDist = new int[N + 1];
		farNodeToNodeDist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			tree.get(p).add(new Edge(c, dist));
			tree.get(c).add(new Edge(p, dist));
		}

		// 1번째 dfs
		visited = new boolean[N + 1];
		visited[1] = true;
		rootToNodeDist[1] = 0;
		dfs(1);

		// 가장 먼 노드
		int farNode = 1;
		int maxDist = rootToNodeDist[farNode];
		for (int i = 1; i <= N; i++) {
			if (maxDist < rootToNodeDist[i]) {
				maxDist = rootToNodeDist[i];
				farNode = i;
			}
		}
		// 2번째 dfs
		visited = new boolean[N + 1];
		visited[farNode] = true;
		farNodeToNodeDist[farNode] = 0;
		dfs2(farNode);

		int result = farNodeToNodeDist[farNode];
		for (int i = 1; i <= N; i++) {
			if (result < farNodeToNodeDist[i]) {
				result = farNodeToNodeDist[i];
			}
		}

		System.out.println(result);
		return;
	}

	static public void dfs(int node) {
		for (Edge nextEdge : tree.get(node)) {
			if (visited[nextEdge.to]) {
				continue;
			}

			visited[nextEdge.to] = true;
			rootToNodeDist[nextEdge.to] = rootToNodeDist[node] + nextEdge.dist;
			dfs(nextEdge.to);
		}
	}

	static public void dfs2(int node) {
		for (Edge nextEdge : tree.get(node)) {
			if (visited[nextEdge.to]) {
				continue;
			}

			visited[nextEdge.to] = true;
			farNodeToNodeDist[nextEdge.to] = farNodeToNodeDist[node] + nextEdge.dist;
			dfs2(nextEdge.to);
		}
	}
}
