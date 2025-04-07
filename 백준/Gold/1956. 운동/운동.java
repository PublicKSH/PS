// 플로이드 워셜 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int INF = (int) 1e9;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = INF;

	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		int V = Integer.parseInt(st[0]);
		int E = Integer.parseInt(st[1]);

		// 기본적으로 0으로 초기
		int[][] floydArr = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i == j) {
					continue;
				} else {
					floydArr[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < E; i++) {
			int[] intSt = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
			floydArr[intSt[0] - 1][intSt[1] - 1] = intSt[2];
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					floydArr[i][j] = Math.min(floydArr[i][j], floydArr[i][k] + floydArr[k][j]);
				}
			}
		}
		// 여기까지 연산횟수 70,000,000 => 1초 내외

		// 이제 조합()으로 최단 싸이클 찾기 조합의 연산 횟수 400*400 = 160000
		int[] output = new int[2];
		combination(0, 0, V, 2, output, floydArr);

		
		// 총연산 1억 내외 => 2초 내에 통과
		if(result == INF) {
			System.out.print(-1);
		} else {
			System.out.print(result);
		}
		

	}

	public static void combination(int start, int depth, int n, int r, int[] output, int[][] floydArr) {
		if (depth == r) {
			result = Math.min(result, floydArr[output[0]][output[1]] + floydArr[output[1]][output[0]]);
			return;
		}

		for (int i = start; i < n; i++) {
			output[depth] = i;
			combination(i + 1, depth + 1, n, r, output, floydArr);
		}
	}
}