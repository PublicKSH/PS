import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Brick {
	int y;
	int x;
	int num;

	public Brick(int y, int x, int num) {
		this.y = y;
		this.x = x;
		this.num = num;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] originMap;
	static int result;
	static int N;
	static int W;
	static int H;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			result = (int) 1e9;
			originMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					originMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] sequence = new int[N];
			dfs(0, sequence);
			System.out.printf("#%d %d\n", t, result);
		}
	}

	public static void dfs(int depth, int[] sequence) {
		if (depth == N) {
			// 1. 원본 맵 복사
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = originMap[i][j];
				}
			}
			// 2. drop N 번 진행
			for (int i = 0; i < N; i++) {
				map = drop(sequence[i], map);
			}

			// 3. 남은 벽돌 개수 새기
			result = Math.min(result, getBrickCount(map));
			return;
		}

		for (int i = 0; i < W; i++) {
			sequence[depth] = i;
			dfs(depth + 1, sequence);
		}
	}

	// 블럭이 1이면 -> 그냥 삭제
	// 블럭이 1초과면 -> 연쇄 삭제
	public static int[][] drop(int dropPoint, int[][] map) {
		ArrayDeque<Brick> que = new ArrayDeque<>();
		// 1. 공이 떨어지면서 처음 부딪히는 블럭 찾기
		for (int i = 0; i < H; i++) {
			if (map[i][dropPoint] != 0) {
				if (map[i][dropPoint] != 1) {
					que.offer(new Brick(i, dropPoint, map[i][dropPoint]));
				}
				map[i][dropPoint] = 0;
				break;
			}
		}

		while (!que.isEmpty()) {
			Brick brick = que.poll();

			// 가로열
			for (int i = brick.y - brick.num + 1; i < brick.y + brick.num; i++) {
				int j = brick.x;
				if (i < 0 || j < 0 || i >= H || j >= W || map[i][j] == 0) {
					continue;
				}

				if (map[i][j] != 1) {
					que.offer(new Brick(i, j, map[i][brick.x]));
				}
				map[i][j] = 0;

			}
			// 세로열
			for (int j = brick.x - brick.num + 1; j < brick.x + brick.num; j++) {
				int i = brick.y;
				if (i < 0 || j < 0 || i >= H || j >= W || map[i][j] == 0) {
					continue;
				}

				if (map[i][j] != 1) {
					que.offer(new Brick(i, j, map[i][j]));
				}
				map[i][j] = 0;

			}
		}
		// 블럭 정렬
		int[][] tempMap = new int[H][W];
		for (int j = 0; j < W; j++) {
			int y = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					tempMap[y--][j] = map[i][j];
				}
			}
		}

		return tempMap;
	}

	public static int getBrickCount(int[][] map) {
		int sum = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0) {
					sum++;
				}
			}
		}
		return sum;
	}
}
