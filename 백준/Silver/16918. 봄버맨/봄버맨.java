import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N;
	static int R;
	static int C;
	static int[][] originMap;
	static int[][] secondMap;
	static int[][] thirdMap;

	public static void main(String[] args) throws Exception {
		// --------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		originMap = new int[R][C];
		secondMap = new int[R][C];
		thirdMap = new int[R][C];
		// 캐릭터가 존재하는 위치

		if (N == 1) {
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				System.out.println(line);
			}
			return;
		}

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == '.') {
					originMap[i][j] = -1;
					secondMap[i][j] = -1;
				} else {
					originMap[i][j] = 1;
					secondMap[i][j] = 1;
				}
			}
		}

		// boom
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (originMap[i][j] == 1) {
					secondMap[i][j] = 1;

					for (int di = 0; di < 4; di++) {
						int nx = i + direction[di][0];
						int ny = j + direction[di][1];

						if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
							continue;
						}
						secondMap[nx][ny] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (secondMap[i][j] == -1) {
					thirdMap[i][j] = 1;

					for (int di = 0; di < 4; di++) {
						int nx = i + direction[di][0];
						int ny = j + direction[di][1];

						if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
							continue;
						}
						thirdMap[nx][ny] = 1;
					}
				}
			}
		}

		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		} else if (N % 4 == 1) {
			printMap(thirdMap, 2);
		} else if (N % 4 == 3) {
			printMap(secondMap, 1);
		}

	}

	// mapType 1 : second, 2 : third, 
	public static void printMap(int[][] map, int mapType) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (mapType == 2) {
					if (map[i][j] == 1) {
						sb.append('.');
					} else {
						sb.append('O');
					}
				}
				if (mapType == 1) {
					if (map[i][j] == 1) {
						sb.append('.');
					} else {
						sb.append('O');
					}
				}

			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
