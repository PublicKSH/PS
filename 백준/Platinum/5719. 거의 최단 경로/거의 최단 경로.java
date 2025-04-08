import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int to;
	int dist;

	@Override
	public int compareTo(Edge o) {
		return this.dist - o.dist;
	}

	Edge(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "to : " + to + " dist : " + dist;
	}
}

class Node {
	int id;
	ArrayList<Edge> edgeList;
	// 역방향 간선
	ArrayList<Edge> revEdgeList;
	// 그래프(bfs를 위함) 간선
	ArrayList<Edge> graphEdgeList;

	Node(int id) {
		this.id = id;
		edgeList = new ArrayList<>();
		revEdgeList = new ArrayList<>();
		graphEdgeList = new ArrayList<>();
	}

	void addEdge(Edge edge) {
		edgeList.add(edge);
	}

	void addRevEdge(Edge revEdge) {
		revEdgeList.add(revEdge);
	}

	void addGraphEdge(Edge edge) {
		graphEdgeList.add(edge);
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int S;
	static int D;
	static final int INF = (int) 1e9;
	static Node[] nodeArr;
	// [U][V]
	static boolean[][] shortestPath;

	static public void main(String[] args) throws Exception {
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				break;
			}

			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			nodeArr = new Node[N];
			shortestPath = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				nodeArr[i] = new Node(i);
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				nodeArr[U].addEdge(new Edge(V, P));
				nodeArr[V].addRevEdge(new Edge(U, P));
			}

			// 1. 역방향 다익스트라 진행 하면서 최단 경로 저장
			revDijk(S, D);
			// 2. 최단경로를 정방향 edge에서 제거
			bfs(S, D);
			// 3. 최단 경로 다익스트라 진행
			dijk(S, D);
		}
	}

	// end -> start
	static void revDijk(int S, int D) {
		int[] dist = new int[N];
		Arrays.fill(dist, INF);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(D, 0));
		dist[D] = 0;

		while (!pq.isEmpty()) {
			Edge nowE = pq.poll();
			Node nowNode = nodeArr[nowE.to];
			int nowDist = nowE.dist;

			for (Edge edge : nowNode.revEdgeList) {
				int nextCost = nowDist + edge.dist;
				if (dist[edge.to] > nextCost) {
					dist[edge.to] = nextCost;
					nodeArr[edge.to].graphEdgeList = new ArrayList<>();
					nodeArr[edge.to].addGraphEdge(new Edge(nowNode.id, edge.dist));
					pq.offer(new Edge(edge.to, nextCost));
				} else if (dist[edge.to] == nextCost) {
					nodeArr[edge.to].addGraphEdge(new Edge(nowNode.id, edge.dist));
				}
			}
		}
		
		return;
	}

	static void bfs(int S, int D) {
		// 2. 최단경로를 정방향 edge에서 제거
		boolean[] visitied = new boolean[N];
		ArrayDeque<Edge> que = new ArrayDeque<>();
		que.offer(new Edge(S, 0));
		visitied[S] = true;

		while (!que.isEmpty()) {
			Edge nowE = que.poll();
			Node nowNode = nodeArr[nowE.to];
			
			for (Edge edge : nowNode.graphEdgeList) {
				shortestPath[nowNode.id][edge.to] = true;
				if (!visitied[edge.to]) {
					visitied[edge.to] = true;
					que.offer(new Edge(edge.to, edge.dist));
				}
			}
		}
		return;
	}
	
	static void dijk(int S, int D) {
		int[] dist = new int[N];
		Arrays.fill(dist, INF);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(S, 0));
		dist[S] = 0;

		while (!pq.isEmpty()) {
			Edge nowE = pq.poll();
			Node nowNode = nodeArr[nowE.to];
			int nowDist = nowE.dist;

			for (Edge edge : nowNode.edgeList) {
				if (shortestPath[nowNode.id][edge.to]) {
					continue;
				}

				int nextCost = nowDist + edge.dist;
				if (dist[edge.to] > nextCost) {
					dist[edge.to] = nextCost;
					pq.offer(new Edge(edge.to, nextCost));
				}
			}
		}

		if (dist[D] != INF) {
			System.out.println(dist[D]);
		} else {
			System.out.println(-1);
		}
	}
}
