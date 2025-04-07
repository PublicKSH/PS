import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Train {
	int cnt;
	ArrayList<Point> pointList;

	Train() {
		this.pointList = new ArrayList<>();
	}

	Train(Train train) {
		this.pointList = new ArrayList<>();
		for (Point p : train.pointList) {
			this.pointList.add(new Point(p.y, p.x));
		}
	}

	@Override
	public String toString() {
		return pointList.toString();
	}

	boolean isTrainWidth() {
		if (pointList.get(0).y == pointList.get(1).y && pointList.get(2).y == pointList.get(2).y) {
			return true;
		}
		return false;
	}

	void turn() {
		if (this.isTrainWidth()) {
			this.pointList.get(0).y = this.pointList.get(1).y - 1;
			this.pointList.get(0).x = this.pointList.get(1).x;
			this.pointList.get(2).y = this.pointList.get(1).y + 1;
			this.pointList.get(2).x = this.pointList.get(1).x;
		} else {
			this.pointList.get(0).y = this.pointList.get(1).y;
			this.pointList.get(0).x = this.pointList.get(1).x - 1;
			this.pointList.get(2).y = this.pointList.get(1).y;
			this.pointList.get(2).x = this.pointList.get(1).x + 1;
		}
	}
}

class Point {
	int y;
	int x;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "(" + y + ", " + x + ")";
	}
}

public class Main {
	static int N;
	static int[][] map;
	// U D L R
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Train train = new Train();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) == 'B') {
					map[i][j] = 2;
					train.pointList.add(new Point(i, j));
				} else if (line.charAt(j) == 'E') {
					map[i][j] = -2;
				} else {
					map[i][j] = line.charAt(j) - '0';
				}
			}
		}

		bfs(train);
		System.out.println(result);
	}

	public static void bfs(Train train) {
		// boolean[0] -> 가로, boolean[1] -> 세로
		boolean[][][] visited = new boolean[2][N][N];
		ArrayDeque<Train> que = new ArrayDeque<>();
		if (train.isTrainWidth()) {
			visited[0][train.pointList.get(1).y][train.pointList.get(1).x] = true;
		} else {
			visited[1][train.pointList.get(1).y][train.pointList.get(1).x] = true;
		}
		que.offer(train);

		while (!que.isEmpty()) {
			Train nowTrain = que.poll();
			if (checkResult(nowTrain)) {
				result = nowTrain.cnt;
				break;
			}
			// 이동
			Train nextTrain;
			for (int i = 0; i < 4; i++) {
				nextTrain = move(i, nowTrain);
				if (nextTrain != null) {
					if (nextTrain.isTrainWidth()) {
						if (!visited[0][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x]) {
							visited[0][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x] = true;
							nextTrain.cnt = nowTrain.cnt + 1;
							que.offer(nextTrain);
						}
					} else {
						if (!visited[1][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x]) {
							visited[1][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x] = true;
							nextTrain.cnt = nowTrain.cnt + 1;
							que.offer(nextTrain);
						}
					}
				}
			}
			// 회전
			if (turn(nowTrain) != null) {
				nextTrain = turn(nowTrain);
				if (nextTrain != null) {
					if (nextTrain.isTrainWidth()) {
						if (!visited[0][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x]) {
							visited[0][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x] = true;
							nextTrain.cnt = nowTrain.cnt + 1;
							que.offer(nextTrain);
						}
					} else {
						if (!visited[1][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x]) {
							visited[1][nextTrain.pointList.get(1).y][nextTrain.pointList.get(1).x] = true;
							nextTrain.cnt = nowTrain.cnt + 1;
							que.offer(nextTrain);
						}
					}
				}
			}
		}
	}

	static boolean checkResult(Train train) {
		for (Point p : train.pointList) {
			if (map[p.y][p.x] != -2) {
				return false;
			}
		}
		return true;
	}

	// command : U, D, L, R, T (0,1,2,3,4)
	static Train move(int command, Train train) {
		Train nextTrain = new Train(train);
		int di = command;

		for (Point p : nextTrain.pointList) {
			p.y = p.y + directions[di][0];
			p.x = p.x + directions[di][1];
		}

		// 움직일 수 있는지 확인
		boolean canMove = true;
		for (Point p : nextTrain.pointList) {
			if (p.y < 0 || p.x < 0 || p.y >= N || p.x >= N || map[p.y][p.x] == 1) {
				canMove = false;
			}
		}
		if (canMove) {
			return nextTrain;
		} else {
			return null;
		}
	}

	static Train turn(Train train) {
		Train nextTrain = new Train(train);

		nextTrain.turn();

		// 3 * 3에 나무가 있엇는지
		boolean canTurn = true;
		Point midP = nextTrain.pointList.get(1);
		for (int i = midP.y - 1; i <= midP.y + 1; i++) {
			for (int j = midP.x - 1; j <= midP.x + 1; j++) {
				if (i < 0 || j < 0 || i >= N || j >= N || map[i][j] == 1) {
					canTurn = false;
				}
			}
		}
		if (canTurn) {
			return nextTrain;
		} else {
			return null;
		}
	}
}
