import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int K;
	static int[] coins;
	static int[] dp;
	static int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		dp = new int[K + 1];
		Arrays.fill(dp, INF);
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if (coins[i] <= K) {
				dp[coins[i]] = 1;
			}
		}

		for (int i = 1; i <= K; i++) {
			for (int c : coins) {
				if (i - c >= 0) {
					dp[i] = Math.min(dp[i], dp[i - c] + 1);
				}
			}
		}
		if (dp[K] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
	}
}