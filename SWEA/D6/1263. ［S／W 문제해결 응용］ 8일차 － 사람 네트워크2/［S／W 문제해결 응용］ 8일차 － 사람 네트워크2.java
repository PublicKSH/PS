import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] floyd;
	static int[] cc;
	static int N;
	static int INF = (int) 1e9;
	static int result;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			result = INF;
			floyd = new int[N][N];
			cc = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					floyd[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && floyd[i][j] == 0) {
						floyd[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (floyd[i][j] == INF) {
						cc[i] = INF;
						continue;
					}
					cc[i] += floyd[i][j];
				}
				result = Math.min(result, cc[i]);
			}

			System.out.printf("#%d %d\n", t, result);
		}
	}
}
