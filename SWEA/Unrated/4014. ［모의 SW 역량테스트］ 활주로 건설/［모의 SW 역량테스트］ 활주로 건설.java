import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int result;
	static int N;
	static int X;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 가로열
			for (int i = 0; i < N; i++) {
				result += canBuildAirstrip(map[i]);
			}

			// 세로열
			for (int j = 0; j < N; j++) {
				int[] line = new int[N];
				for (int i = 0; i < N; i++) {
					line[i] = map[i][j];
				}
				result += canBuildAirstrip(line);
			}

			System.out.printf("#%d %d\n", t, result);
		}
	}

	public static int canBuildAirstrip(int[] line) {
//		System.out.println("start : " + Arrays.toString(line));
		boolean[] runway = new boolean[N];
		// 왼쪽 -> 오른쪽으로 이동
		// 1. 못올라 가는 경우 (높이 차이가 나는 경우)
		// 1-1.높이 차이가 2면 return fail
		// 1-2. 높이 차이가 1이면 활주로를 건설
		// 1-2-1. 활주로 건설이 불가능하면 (범위 초과, 높낮이 달라짐, 이미 건설함) return fail

		for (int i = 0; i < line.length - 1; i++) {
			// 1. 못올라 가는 경우 (높이 차이가 나는 경우)
			if (Math.abs(line[i] - line[i + 1]) > 0) {
				// 1-1.높이 차이가 2면 return fail
				if (Math.abs(line[i] - line[i + 1]) >= 2) {
					return 0;
				}
				// 1-2. 높이 차이가 1이면 활주로를 건설
				if (line[i] > line[i + 1]) {
					// 내려가야하는경우
					int startH = line[i + 1];
					for (int j = i + 1; j < i + 1 + X; j++) {
						// 1-2-1. 활주로 건설이 불가능하면 (범위 초과, 높낮이 달라짐, 이미 건설함) return fail
						if (j >= N || line[j] != startH || runway[j] == true) {
							return 0;
						}
						runway[j] = true;
					}
				} else {
					// 올라가야하는경우
					int startH = line[i];
					for (int j = i; j > i - X; j--) {
						// 1-2-1. 활주로 건설이 불가능하면 (범위 초과, 높낮이 달라짐, 이미 건설함) return fail
						if (j < 0 || line[j] != startH || runway[j] == true) {
							return 0;
						}
						runway[j] = true;
					}
				}
			}
		}

		return 1;
	}
}
