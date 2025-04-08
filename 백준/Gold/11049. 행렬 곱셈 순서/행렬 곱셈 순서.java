import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = INF;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 행렬의 범위 길이
		for (int i = 0; i < N; i++) {
			for (int s = 0; s < N - i; s++) {
				int e = s + i;
				if (i == 0) {
					dp[s][e] = 0;
				} else if (i == 1) {
					dp[s][e] = arr[s][0] * arr[s][1] * arr[e][1];
				} else {
					for (int j = s; j < e; j++) {
						dp[s][e] = Math.min(dp[s][e], dp[s][j] + dp[j + 1][e] + arr[s][0] * arr[j][1] * arr[e][1]); 
					}
				}
			}
		}

		System.out.println(dp[0][N - 1]);
	}
}