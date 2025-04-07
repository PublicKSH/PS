import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
	public Node(int y, int x, int k, int depth) {
		super();
		this.y = y;
		this.x = x;
		this.k = k;
		this.depth = depth;
	}

	int y;
	int x;
	int depth;
	int k;

}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int W;
	static int H;
	static int K;
	static int[][] map;
	static int[][] horseDirections = { { 2, 1 }, { 1, 2 }, { -2, 1 }, { -1, 2 }, { 2, -1 }, { 1, -2 }, { -2, -1 },
			{ -1, -2 } };
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Node[][] visited;

	static public void main(String[] args) throws Exception {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new Node[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<Node> que = new ArrayDeque<>();
		que.offer(new Node(0, 0, K, 0));
		visited[0][0] = new Node(0, 0, K, 0);
		
		while (!que.isEmpty()) {
			Node nowNode = que.poll();
			if (nowNode.y == H - 1 && nowNode.x == W - 1) {
				System.out.println(nowNode.depth);
				return;
			}

			if (nowNode.k > 0) {
				for (int i = 0; i < 8; i++) {
					int ny = nowNode.y + horseDirections[i][0];
					int nx = nowNode.x + horseDirections[i][1];

					if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1) {
						continue;
					}

					if (visited[ny][nx] == null || visited[ny][nx] != null && visited[ny][nx].k < nowNode.k - 1) {
						visited[ny][nx] = new Node(ny, nx, nowNode.k - 1, nowNode.depth + 1);
						que.offer(new Node(ny, nx, nowNode.k - 1, nowNode.depth + 1));
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int ny = nowNode.y + directions[i][0];
				int nx = nowNode.x + directions[i][1];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1) {
					continue;
				}

				if (visited[ny][nx] == null || visited[ny][nx] != null && visited[ny][nx].k < nowNode.k) {
					visited[ny][nx] = new Node(ny, nx, nowNode.k, nowNode.depth + 1);
					que.offer(new Node(ny, nx, nowNode.k, nowNode.depth + 1));
				}
			}
		}

		System.out.println(-1);
	}
}