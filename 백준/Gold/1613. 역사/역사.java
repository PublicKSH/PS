// 플로이드 워셜 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static final int INF = (int) 1e9;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] intst = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = intst[0]+1, k = intst[1];
		int[][] floyd = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				floyd[i][j] = INF;
			}
		}

		for (int i = 0; i < n; i++) {
			floyd[i][i] = 0;
		}

		for (int i = 0; i < k; i++) {
			intst = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			floyd[intst[0]][intst[1]] = 1;
		}

		// i -> a -> j
		for (int a = 0; a < n; a++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					floyd[i][j] = Math.min(floyd[i][j], floyd[i][a] + floyd[a][j]);
				}
			}
		}

		int s = Integer.parseInt(br.readLine());

		for (int i = 0; i < s; i++) {
			intst = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int a = intst[0];
			int b = intst[1];
			if (floyd[a][b] == INF && floyd[b][a] == INF) {
				System.out.println(0);
			} else if (floyd[a][b] < floyd[b][a]) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
		}
	}
}