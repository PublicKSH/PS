// 접근 법은 맞았는데 구현에서 중복 경로 처리를 잘못해주었다
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int K;
	static final int INF = 1_000_000_000;
	static ArrayList<ArrayList<Edge>> graph;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b, c));
		}

		dijk();
	}

	public static void dijk() {
		int start = 1;
		ArrayList<PriorityQueue<Integer>> dist = new ArrayList<PriorityQueue<Integer>>();
		for (int i = 0; i <= N; i++) {
			dist.add(new PriorityQueue<>(Collections.reverseOrder()));
		}
		PriorityQueue<Edge> que = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.dist - o2.dist;
			}

		});
		
		dist.get(start).offer(0);
		que.offer(new Edge(1, 0));

		while (!que.isEmpty()) {
			Edge nowE = que.poll();
			int now = nowE.to;
			int nowDist = nowE.dist;

			for (Edge nextEdge : graph.get(now)) {
				// 현재의 최단거리(0~K-1)에서 nextEdge로 next로 가는 값을 갱신할 수 있는경우만 고고
				int cost = nextEdge.dist + nowDist;
				if (dist.get(nextEdge.to).size() < K) {
					dist.get(nextEdge.to).offer(cost);
					que.offer(new Edge(nextEdge.to, cost));
				} else if (dist.get(nextEdge.to).peek() > cost) {
					dist.get(nextEdge.to).poll();
					dist.get(nextEdge.to).offer(cost);
					que.offer(new Edge(nextEdge.to, cost));
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (dist.get(i).size() < K) {
				System.out.println(-1);
			} else {
				System.out.println(dist.get(i).peek());
			}
		}
	}
}

class Edge {
	int to;
	int dist;

	public Edge(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}