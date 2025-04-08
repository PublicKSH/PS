import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int K;
	static int[] cost;
	static int[] volume;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			volume = new int[N + 1];
			cost = new int[N + 1];
			dp = new int[N + 1][K + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				volume[i] = v;
				cost[i] = c;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= K; j++) {
					if (j  < volume[i]) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume[i]] + cost[i]);
					}
				}
			}

			System.out.printf("#%d %d\n", t, dp[N][K]);
		}
	}
}