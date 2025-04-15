import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	int y;
	int x;
}

class Bridge implements Comparable<Bridge> {
	@Override
	public String toString() {
		return "Bridge [length=" + length + ", from=" + from + ", to=" + to + "]";
	}

	public Bridge(int length, int from, int to) {
		super();
		this.length = length;
		this.from = from;
		this.to = to;
	}

	int length;
	int from;
	int to;

	@Override
	public int compareTo(Bridge o) {
		return this.length - o.length;
	}
}

class Island {
	@Override
	public String toString() {
		return "Island [id=" + id + ", parent=" + parent + ", bridges=" + bridges + "]";
	}

	public Island(int id) {
		super();
		this.id = id;
		this.bridges = new ArrayList<>();
	}

	int id;
	Island parent;
	List<Bridge> bridges;

	void addBridge(Bridge bridge) {
		this.bridges.add(bridge);
	}

}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int islandId;
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int INF = (int) 1e9;
	static Island[] islands;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		islands = new Island[100];
		visited = new boolean[N][M];
		islandId = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. bfs로 각 섬에 id 를 할당
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		// 2. 가로열/세로열을 읽으면서 다리를 건설
		for (int i = 0; i < N; i++) {
			buildBridge(map[i]);
		}

		for (int j = 0; j < M; j++) {
			int[] line = new int[N];
			for (int i = 0; i < N; i++) {
				line[i] = map[i][j];
			}
			buildBridge(line);
		}

		// 3. mst로 최소 거리 만들기
		Queue<Bridge> pq = new PriorityQueue<>();
		for (int i = 1; i < islandId; i++) {
			for (Bridge bridge : islands[i].bridges) {
				pq.offer(bridge);
			}
		}

		int result = 0;
		int unionCnt = 1;
		while (!pq.isEmpty()) {
			Bridge bridge = pq.poll();

			if (union(islands[bridge.from], islands[bridge.to])) {
				result += bridge.length;
				unionCnt++;
			}
		}

		// 실제 섬의 개수 : islandId -1
		if (unionCnt != islandId -1) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	public static Island find(Island island) {
		if (island.parent == null) {
			return island;
		}
		return island.parent = find(island.parent);
	}

	public static boolean union(Island i1, Island i2) {
		i1 = find(i1);
		i2 = find(i2);

		// 이미 같은 집합
		if (i1 == i2) {
			return false;
		} else {
			i1.parent = i2;
			return true;
		}
	}

	// N*M
	public static void bfs(int startY, int startX) {
		Deque<Point> que = new ArrayDeque<>();
		map[startY][startX] = islandId;
		visited[startY][startX] = true;
		que.offer(new Point(startY, startX));

		while (!que.isEmpty()) {
			Point nowPoint = que.poll();

			for (int i = 0; i < 4; i++) {
				int ny = nowPoint.y + dir[i][0];
				int nx = nowPoint.x + dir[i][1];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == 0) {
					continue;
				}

				map[ny][nx] = islandId;
				visited[ny][nx] = true;
				que.offer(new Point(ny, nx));
			}

		}


		islands[islandId] = new Island(islandId);
		islandId++;
	}

	// N*M
	public static void buildBridge(int[] line) {
//		System.out.println(Arrays.toString(line));
		int nowIslandId = -1;
		int bridgeLength = 0;
		for (int i = 0; i < line.length; i++) {
			if (line[i] != 0) {
				if (nowIslandId == -1) {
					nowIslandId = line[i];
				} else {
					if (line[i] != nowIslandId) {
						int formIslandId = nowIslandId;
						nowIslandId = line[i];

						// 다리의 길이는 2이상
						if (bridgeLength >= 2) {
							islands[formIslandId].addBridge(new Bridge(bridgeLength, formIslandId, nowIslandId));
							islands[nowIslandId].addBridge(new Bridge(bridgeLength, nowIslandId, formIslandId));
						}
						bridgeLength = 0;
					} else {
						bridgeLength = 0;
			
					}
				}
			}
			if (line[i] == 0) {
				if (nowIslandId != -1) {
					bridgeLength++;
				}
			}
		}
	}
}