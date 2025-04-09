import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

enum Direction {
	D(1, 0), U(-1, 0), L(0, -1), R(0, 1);

	private Direction(int dy, int dx) {
		this.dy = dy;
		this.dx = dx;
	}

	private final int dy;
	private final int dx;

	public int getDy() {
		return dy;
	}

	public int getDx() {
		return dx;
	}
}

class Minsik {
	int y;
	int x;
	// 움직인 횟수
	int moveCnt;
	// 방문 기록
	boolean[][][] visited;
	// 가지고 있는 키
	int keys = 0;

//	000000
	public Minsik(int y, int x, int moveCnt) {
		this.y = y;
		this.x = x;
		this.moveCnt = moveCnt;
		this.visited = new boolean[50][50][0b1111111];
		this.keys = 0;
		visited[y][x][0] = true;
	}

	public Minsik(int y, int x, int moveCnt, boolean[][][] visited, int keys) {
		this.y = y;
		this.x = x;
		this.moveCnt = moveCnt;
		this.visited = visited;
		this.keys = keys;
	}

	// 민식이가 방향으로 이동할 수 있는 지 확인
	boolean canMove(Direction dir, Character[][] map) {
		int ny = this.y + dir.getDy();
		int nx = this.x + dir.getDx();
		int N = map.length;
		int M = map[0].length;

		if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx][keys] || map[ny][nx].equals('#')) {
			return false;
		}

		if (Character.isUpperCase(map[ny][nx])) {
			int bit = map[ny][nx] - 'A';
			return (keys & (1 << bit)) != 0;
		}

		return true;
	}

	// 방향으로 이동하는 민식이를 return
	Minsik move(Direction dir, Character[][] map) {
		int ny = this.y + dir.getDy();
		int nx = this.x + dir.getDx();
		int newKeys = this.keys;

		if (Character.isLowerCase(map[ny][nx])) {
			int bit = map[ny][nx] - 'a';
			newKeys |= (1 << bit);
		}

		visited[ny][nx][newKeys] = true;

		return new Minsik(ny, nx, this.moveCnt + 1, visited, newKeys);
	}

	@Override
	public String toString() {
		return "[y=" + y + ", x=" + x + ", moveCnt=" + moveCnt + "]";
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int startY;
	static int startX;
	static Character[][] map;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Character[N][M];

		for (int i = 0; i < N; i++) {
			String mapSt = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = mapSt.charAt(j);
				if (map[i][j].equals('0')) {
					startY = i;
					startX = j;
				}
			}
		}

		ArrayDeque<Minsik> que = new ArrayDeque<>();
		que.add(new Minsik(startY, startX, 0));

		while (!que.isEmpty()) {
			Minsik minsik = que.poll();
//			System.out.println(minsik);

			for (Direction dir : Direction.values()) {
				if (minsik.canMove(dir, map)) {
					Minsik nextMinsik = minsik.move(dir, map);
					if (map[nextMinsik.y][nextMinsik.x].equals('1')) {
						System.out.println(nextMinsik.moveCnt);
						return;
					}

					que.offer(nextMinsik);
				}
			}
		}
		System.out.println(-1);
	}
}
