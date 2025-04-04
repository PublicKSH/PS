import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int result;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[3][N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0][1] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					continue;
				}
				// 가로로 오는 경우
				if (j - 1 >= 0 && map[i][j - 1] != 1) {
					dp[0][i][j] += dp[0][i][j - 1] + dp[2][i][j - 1];
				}
				// 세로로 오는 경우
				if (i - 1 >= 0 && map[i - 1][j] != 1) {
					dp[1][i][j] += dp[1][i - 1][j] + dp[2][i - 1][j];
				}

				// 대각선으로 오는 경우
				if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j] != 1 && map[i][j - 1] != 1 && map[i - 1][j - 1] != 1) {
					dp[2][i][j] += dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
				}
			}
		}
		System.out.println(dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1]);
	}
}