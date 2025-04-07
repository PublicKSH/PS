
// 백준 2239
// 접근법 -> 시간 제한 2초 이며 스도쿠 라는 특성상 넣을 수 있는 숫자가 한정되어있다 보니
// 구현으로 푸는 방법으로 접근
// 스택으로 백트레킹으로 풀어볼까?
// 각 구역 사용할 수 있는 숫자는 제한되어있음 어떻게 관리를 할 수 있을까? -> 그냥 전부 찾아보자!

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] board = new int[9][9];
	static int zeroCount = 0;
	static ArrayList<Point> zeroPoint = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String s;
		for (int i = 0; i < 9; i++) {
			s = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = Character.getNumericValue(s.charAt(j));
				if (board[i][j] == 0) {
					zeroPoint.add(new Point(i, j));
					zeroCount++;
				}
			}
		}

		backtracking(0);
	}

	// x,y에 num가 올 수 있는지
	public static boolean isPossible(int x, int y, int num) {
		// 행
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == num) {
				return false;
			}
		}
		// 열
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == num) {
				return false;
			}
		}
		// 정사각형
		int newX = (int) (x / 3) * 3;
		int newY = (int) (y / 3) * 3;
		for (int i = newX; i < newX+3; i++) {
			for (int j = newY; j < newY + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

	// backTrack
	public static void backtracking(int depth) {
		if (depth == zeroCount) {
			for(int[] board1D : board) {
				System.out.println(Arrays.toString(board1D).replaceAll("[\\[\\],]", "").replaceAll(" ", ""));
			}
			System.exit(0);
		}

		for (int i = 1; i < 10; i++) {
			Point nowP = zeroPoint.get(depth);
			if (isPossible(nowP.x, nowP.y, i)) {
				board[nowP.x][nowP.y] = i;
				backtracking(depth + 1);
				board[nowP.x][nowP.y] = 0;
			}
		}
	}
}
