import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int INF = 1_000_000_000;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		int[][][] dp = new int[5][5][100_000];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 100_000; k++) {
					dp[i][j][k] = INF;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		String[] st = br.readLine().split(" ");
		for (int i = 0; i < st.length; i++) {
			list.add(Integer.parseInt(st[i]));
		}

		// 마지막 0 은 무시
		int N = list.size() - 1;
		// 초깃값 세팅
		dp[0][list.get(0)][0] = 2;
		dp[list.get(0)][0][0] = 2;
		// 100_000 * 5 * 5 = 2_500_000
		for (int i = 1; i < N; i++) {
			int targetNum = list.get(i);
			for (int l = 0; l < 5; l++) {
				for (int r = 0; r < 5; r++) {
					cnt++;
					if (dp[l][r][i - 1] != INF) {
						if (l == targetNum || r == targetNum) {
							dp[l][r][i] = Math.min(dp[l][r][i], dp[l][r][i - 1] + 1);
						} else {
							// 왼발로 누르기
							dp[targetNum][r][i] = Math.min(dp[targetNum][r][i],
									dp[l][r][i - 1] + calcCost(l, targetNum));

							// 오른발로 누르기
							dp[l][targetNum][i] = Math.min(dp[l][targetNum][i],
									dp[l][r][i - 1] + calcCost(r, targetNum));
						}
					}
				}
			}
		}

		// 총 연산 16 * 100_000
		int result = INF;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result = Math.min(result, dp[i][j][N - 1]);
			}
		}
		System.out.println(result);
	}

	public static int calcCost(int s, int e) {
		if (s == 0) {
			return 2;
		}
		if (Math.abs(e - s) == 2) {
			return 4;
		} else {
			return 3;
		}
	}
}
