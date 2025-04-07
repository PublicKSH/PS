
// 트리의 지름 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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

	static public void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1) {
					break;
				}
				int dist = Integer.parseInt(st.nextToken());
				tree.get(a).add(new Edge(b, dist));
			}

		}

		int[] dist = new int[N + 1];
		bfs(1, dist);

		int farNode = 1;
		int maxDist = dist[farNode];
		for (int i = 1; i <= N; i++) {
			if (maxDist < dist[i]) {
				maxDist = dist[i];
				farNode = i;
			}
		}
		// 1에서 가장 먼 노드를 찾음
		
		
		// 2번째 bfs
		dist = new int[N + 1];
		bfs(farNode, dist);

		int result = dist[farNode];
		for (int i = 1; i <= N; i++) {
			if (result < dist[i]) {
				result = dist[i];
			}
		}
		System.out.println(result);
		return;
	}

	static void bfs(int start, int[] dist) {
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;

		ArrayDeque<Edge> que = new ArrayDeque<>();
		que.offer(new Edge(start, 0));

		while (!que.isEmpty()) {
			Edge nowEdge = que.poll();
			int now = nowEdge.to;
			int nowDist = nowEdge.dist;

			for (Edge next : tree.get(now)) {
				if (visited[next.to]) {
					continue;
				}

				visited[next.to] = true;
				dist[next.to] = next.dist + dist[now];
				que.offer(next);
			}
		}

	}
}
