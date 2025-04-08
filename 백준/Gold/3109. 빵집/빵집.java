import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R;
	static int C;
	static int result;
	static String[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		result = 0;
		map = new String[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}

		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				result++;
			}
		}
		System.out.println(result);
	}

	public static boolean dfs(int y, int x) {
		if (y < 0 || x < 0 || y >= R | x >= C || visited[y][x] || map[y][x].equals("x")) {
			return false;
		}
		visited[y][x] = true;
		if (x == C - 1) {
			return true;
		}
		// 항상 위로 가는게 이득
		return dfs(y - 1, x + 1) || dfs(y, x + 1) || dfs(y + 1, x + 1);
	}
}
