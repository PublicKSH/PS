import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;
	static final int INF = 1_000_000_000;

	static public void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫줄 초기화
		dp[0][0] = map[0][0];
		for (int j = 1; j < M; j++) {
			dp[0][j] = dp[0][j - 1] + map[0][j];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = -1 * INF;
			}
		}
//		System.out.println(0 + ", " + Arrays.toString(dp[0]));
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 위에서 내려옴 그리고 왼쪽, 오른쪽으로 dp 진행
				// 최대값을 갱신할 수 있을 때만 진행
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + map[i][j]);
				int temp = dp[i - 1][j] + map[i][j];
				int lSum = temp;
				int rSum = temp;
				for (int k = j - 1; k >= 0; k--) {
					// 왼쪽으로 가면서 최대값 갱신 할 수 있을 때만 진행
					lSum += map[i][k];
//					if (dp[i][k] < lSum) {
//						dp[i][k] = lSum;
//					} else {
//						break;
//					}
					dp[i][k] = Math.max(dp[i][k], lSum);
				}

				for (int k = j + 1; k < M; k++) {
					// 오른으로 가면서 최대값 갱신 할 수 있을 때만 진행
					rSum += map[i][k];
//					if (dp[i][k] < rSum) {
//						dp[i][k] = rSum;
//					} else {
//						break;
//					}
					dp[i][k] = Math.max(dp[i][k], rSum);
				}
//				System.out.println(i + ", " + Arrays.toString(dp[i]));
			}
		}

		System.out.println(dp[N - 1][M - 1]);
		return;
	}

}
