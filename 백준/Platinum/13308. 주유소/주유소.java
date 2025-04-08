import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class City {
	int cost;
	ArrayList<Edge> edgeList;

	City(int cost) {
		this.cost = cost;
		edgeList = new ArrayList<>();
	}

	void addEdge(Edge edge) {
		edge.updateCost(cost);
		// 주의할점 : weight는 업데이트된 최소 cost로 계산하는 것이 아닌 가지고있던 cost 로 계산
		edge.weight = edge.cost * edge.dist;
		edgeList.add(edge);
	}
}

class Edge implements Comparable<Edge> {
	int s;
	int e;
	int dist;
	int cost;
	int weight; // dist * cost

	Edge(int s, int e, int dist) {
		this.s = s;
		this.e = e;
		this.dist = dist;
		this.cost = 2500;
		this.weight = this.dist * this.cost;
	}

	Edge(Edge edge) {
		this.s = edge.s;
		this.e = edge.e;
		this.dist = edge.dist;
		this.cost = edge.cost;
		this.weight = edge.weight;
	}

	void updateCost(int cost) {
		// 주의할점 : weight는 업데이트된 최소 cost로 계산하는 것이 아닌 가지고있던 cost 로 계산
		if (cost < this.cost) {
			this.cost = cost;
		}
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static City[] cityArr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		cityArr = new City[N + 1];
		for (int i = 1; i <= N; i++) {
			cityArr[i] = new City(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sCity = Integer.parseInt(st.nextToken());
			int eCity = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			cityArr[sCity].addEdge(new Edge(sCity, eCity, dist));
			cityArr[eCity].addEdge(new Edge(eCity, sCity, dist));
		}

		System.out.println(dijk(1, N));
	}

	public static long dijk(int s, int e) {
		// dp[city][oil] 최소 oil로 city에 갈 수 있는 최소 값
		long[][] dp = new long[N + 1][2501];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 2501; j++) {
				dp[i][j] = INF;
			}
		}

		dp[s][cityArr[s].cost] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (Edge edge : cityArr[s].edgeList) {
			Edge newEdge = new Edge(edge);
			int nowCost = newEdge.cost;
			int nextCost = Math.min(newEdge.cost, cityArr[newEdge.e].cost);
			if (dp[newEdge.e][nextCost] > dp[newEdge.s][nowCost] + nowCost * newEdge.dist) {
				dp[newEdge.e][nextCost] = dp[newEdge.s][nowCost] + nowCost * newEdge.dist;
				newEdge.weight = nowCost * newEdge.dist;
				newEdge.cost = nextCost;
				pq.add(newEdge);
			}
		}

		while (!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			int nowCost = nowEdge.cost;
			
			for (Edge edge : cityArr[nowEdge.e].edgeList) {
				Edge newEdge = new Edge(edge);
				int nextCost = Math.min(nowCost, cityArr[newEdge.e].cost);
				if (dp[newEdge.e][nextCost] > dp[newEdge.s][nowCost] + nowCost * newEdge.dist) {
					dp[newEdge.e][nextCost] = dp[newEdge.s][nowCost] + nowCost * newEdge.dist;
					newEdge.weight = nowCost * newEdge.dist;
					newEdge.cost = nextCost;
					pq.add(newEdge);
				}
			}
		}

		long result = Long.MAX_VALUE;
		for (int j = 0; j < 2501; j++) {
			result = Math.min(result, dp[e][j]);
		}
		return result;
	}
}