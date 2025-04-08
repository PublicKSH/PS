import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// [s][e]
		boolean[][] dp = new boolean[N][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		// dp 배열 초기화 O(n^2/2) = 2,000,000
		for (int s = N - 1; s >= 0; s--) {
			for (int e = s; e < N; e++) {
				if (s == e) {
					dp[s][e] = true;
				} else if (arr[s] == arr[e]) {
					if (e - s == 1) {
						dp[s][e] = true;
					}
					else if (dp[s + 1][e - 1]) {
						dp[s][e] = true;
					}
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (dp[s - 1][e - 1]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
