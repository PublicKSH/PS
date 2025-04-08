import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int INF = 9;
//			(int) 1e9;
	static int[][] floyd;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			floyd = new int[N + 1][N + 1];
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if (i != j) {
						floyd[i][j] = INF;
					}
				}
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// a > b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				floyd[a][b] = 1;
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (floyd[i][k] + floyd[k][j] < INF) {
							floyd[i][j] = 1;
						}
					}
				}
			}

			int result = N;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (floyd[i][j] != 1 && floyd[j][i] != 1) {
						result--;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
