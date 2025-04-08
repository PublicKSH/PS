
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
			ArrayList<Character> keys = new ArrayList<>();
			ArrayList<Character> documents = new ArrayList<>();
			Character[][] map = new Character[h + 2][w + 2];
			for (int i = 0; i < h + 2; i++) {
				for (int j = 0; j < w + 2; j++) {
					map[i][j] = '.';
				}
			}

			for (int i = 1; i < h + 1; i++) {
				String s = br.readLine();
				for (int j = 1; j < w + 1; j++) {
					map[i][j] = s.charAt(j - 1);
				}
			}

//			for (Character[] arr1d : map) {
//				System.out.println(Arrays.toString(arr1d));
//			}
			String s = br.readLine();
			if (!s.equals("0")) {
				for (int i = 0; i < s.length(); i++) {
					keys.add(s.charAt(i));
				}
			}

			// 1. 가지고 있는 키를 통해 열수 있는 문 모두 열기
			while (true) {
//				System.out.println("cycle");
				openDoor(map, keys);
				boolean isNotDone = getDocumentsAndKeys(map, keys, documents);
				if (!isNotDone) {
					break;
				}

//				System.out.println();
//				for (Character[] arr1d : map) {
//					System.out.println(Arrays.toString(arr1d));
//				}
			}

			// 2. 할 수 있는 모든행동 진행(키 획득, 문서 획득 등등)

			System.out.printf("%d\n", documents.size());
		}

	}

	static void openDoor(Character[][] map, ArrayList<Character> keys) {
		if (keys.size() == 0) {
			return;
		}
		int h = map.length;
		int w = map[0].length;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (Character.isAlphabetic(map[i][j]) && keys.contains(Character.toLowerCase(map[i][j]))) {
					map[i][j] = '.';
				}
			}
		}
	}

	static boolean getDocumentsAndKeys(Character[][] map, ArrayList<Character> keys, ArrayList<Character> documents) {
		int startKeysSize = keys.size();
		int startDocumentsSize = documents.size();
		int h = map.length;
		int w = map[0].length;

		// bfs로 진행
		int startX = 0;
		int startY = 0;
		boolean[][] visited = new boolean[h][w];

		// 처음 좌표 넣기
		ArrayDeque<Point> que = new ArrayDeque<>();
		que.offer(new Point(startX, startY));
		visited[startX][startY] = true;

		while (!que.isEmpty()) {
			Point nowPoint = que.poll();
			int x = nowPoint.x;
			int y = nowPoint.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= h || ny >= w || nx < 0 || ny < 0 || visited[nx][ny] || map[nx][ny].equals('*')
						|| Character.isUpperCase(map[nx][ny])) {
					continue;
				}

				if (Character.isLowerCase(map[nx][ny])) {
					keys.add(map[nx][ny]);
					map[nx][ny] = '.';
				}

				if (map[nx][ny].equals('$')) {
					documents.add(map[nx][ny]);
					map[nx][ny] = '.';
				}
				que.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}

		// 만약 아무런 활동도 이루지 않았다면
		if (startKeysSize == keys.size() && startDocumentsSize == documents.size()) {
			return false;
		}
		return true;
	}

	public static class Point {
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x;
		int y;

	}
}
