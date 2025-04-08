import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// [r : 0, g : 1, b : 2][]
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		cost = new int[3][N];
//		dp = new int[3][N];
		int result = 1_000_000_000;
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			dp = new int[3][N];
			for (int k = 0; k < 3; k++) {
				if (k == i) {
					dp[k][0] = cost[k][0];
				} else {
					dp[k][0] = 1_000_000_000;
				}
			}
			
			int temp = cost[i][N - 1];
			cost[i][N - 1] = 1_000_000_000;

			for (int j = 1; j < N; j++) {
				dp[0][j] = cost[0][j] + Math.min(dp[1][j - 1], dp[2][j - 1]);
				dp[1][j] = cost[1][j] + Math.min(dp[0][j - 1], dp[2][j - 1]);
				dp[2][j] = cost[2][j] + Math.min(dp[0][j - 1], dp[1][j - 1]);
			}
			
			for (int k = 0; k < 3; k++) {
				result = Math.min(result, dp[k][N - 1]);
			}
			
			cost[i][N - 1] = temp;
		}

		System.out.println(result);
	}
}
