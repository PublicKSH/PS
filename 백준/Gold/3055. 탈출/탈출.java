import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static String result = "KAKTUS";

	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		int R = Integer.parseInt(st[0]), C = Integer.parseInt(st[1]);
		int targetX = 0, targetY = 0;
		String[][] map = new String[R][C];
		ArrayDeque<Node> queue = new ArrayDeque<>();

		// 큐에 물노드 넣기 => 물이 먼저 넘쳐야함
		// 큐에 고슴도치노드 넣기
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = String.valueOf(s.charAt(j));
				if (map[i][j].equals("D")) {
					targetX = i;
					targetY = j;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// char 은 primitive니까 == 으로 비교 가능
				if (map[i][j].equals("S")) {
					map[i][j] = String.valueOf(0);
					queue.offer(new Node(i, j));
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// char 은 primitive니까 == 으로 비교 가능
				if (map[i][j].equals("*")) {
					queue.offer(new Node(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
//			if (node.x == targetX && node.y == targetY) {
//				result = map[node.x][node.y];
//				System.out.println(result);
//				return;
//			}
//
//			for (String[] map1D : map) {
//				System.out.println(Arrays.toString(map1D));
//			}
//			System.out.println();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// 1. 범위 체크
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}

				// 2. 다음에 갈곳이 돌이면 무시하기
				if (map[nx][ny].equals("X")) {
					continue;
				}

				if (map[node.x][node.y].equals("*")) {
					if (map[nx][ny].equals(".") || isNumberic(map[nx][ny])) {
						map[nx][ny] = "*";
						queue.offer(new Node(nx, ny));
					}
				}

				if (isNumberic(map[node.x][node.y])) {
					if (map[nx][ny].equals(".")) {
						map[nx][ny] = String.valueOf(Integer.parseInt(map[node.x][node.y]) + 1);
						queue.offer(new Node(nx, ny));
					}
					
					if (map[nx][ny].equals("D")) {
						System.out.println(String.valueOf(Integer.parseInt(map[node.x][node.y]) + 1));
						return;
					}
				}
			}
		}

		System.out.print("KAKTUS");

	}

	static class Node {
		int x;
		int y;
		// D, *, s, ., X
//		Character c;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isNumberic(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}