import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "(y : " + y + " x : " + x + ")";
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int result;
	static int[][] map;
	static ArrayList<Point> chicken;
	static ArrayList<Point> house;
	static Point[] combChicken;

	static public void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		combChicken = new Point[M];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					house.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		comb(0, 0);
		System.out.println(result);
	}

	static public void comb(int depth, int start) {
		if (depth == M) {
			result = Math.min(result, calcChickenDist());
			return;
		} 
//		else if (depth < M) {
//			result = Math.min(result, calcChickenDist());
//		}

		for (int i = start; i < chicken.size(); i++) {
			combChicken[depth] = chicken.get(i);
			comb(depth + 1, i + 1);
			combChicken[depth] = null;
		}
	}

	static public int calcChickenDist() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int minDist = Integer.MAX_VALUE;
			Point housePoint = house.get(i);
			for (int j = 0; j < M; j++) {
				Point chikenPoint = combChicken[j];

				if (chikenPoint == null) {
					minDist = 0;
					break;
				} else {
					minDist = Math.min(minDist,
							Math.abs(housePoint.y - chikenPoint.y) + Math.abs(housePoint.x - chikenPoint.x));
				}
			}
			sum += minDist;
		}

		return sum;
	}
}
