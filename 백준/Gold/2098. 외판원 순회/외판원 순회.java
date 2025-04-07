import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	// [i][bitMap] bitMask에서 방문하지 않은 도시들을 모두 방문한 뒤 0 번도시로 돌아오는 최소 비용
	// dp[0][001] -> dp[1][011] -> dp[2][111]
	// -> dp[2][101] -> dp[1][111]
	static int[][] dp;
	static int fullVisited;
	static int N;
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][1 << N];
		fullVisited = (1 << N) - 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// -1 로 초기화 해야한다
		// INF로 하면 못가는 경우에 바로  return 해야 하는데 그게 아니라 계속 들어가면서 탐색을 진행해서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < (1 << N); j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 1));
//		System.out.println(Arrays.deepToString(dp));
	}

	public static int dfs(int x, int bitMask) {
//		System.out.println(x + " " + bitMask);
		// 모두 방문한 경우라면 -> 다시 x에서 0으로 돌아가는 거리
		// 이미 방문했다면
		if (dp[x][bitMask] != -1) {
			return dp[x][bitMask];
		}
		if (bitMask == fullVisited) {
			if (map[x][0] == 0) {
				return INF;
			} else {
				return map[x][0];
			}
		}

		dp[x][bitMask] = INF;
		for (int i = 0; i < N; i++) {
			// 방문하지 않은 도시인지 확인
			if ((bitMask & (1 << i)) == 0 && map[x][i] != 0) {
				dp[x][bitMask] = Math.min(dp[x][bitMask], dfs(i, (1 << i) | bitMask) + map[x][i]);
			}
			// 방문 하지 않은 도시면서 도시 사이의 통신이 가능한 경우
		}

		return dp[x][bitMask];
	}
}