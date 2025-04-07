// 풀이시간 10분 => 스위핑 문제 1945, 2170 두개 풀고 바로 풀어서 그런것 같다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 문제 접근 방식 
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<Point> pointList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			pointList.add(new Point(Integer.parseInt( st[0]), 1));
			pointList.add(new Point(Integer.parseInt( st[1]), -1));
		}
		
		pointList.sort(getPointCom());
		int sum = 0;
		int result = 0;
		for (Point p : pointList) {
			result = Math.max(sum, result);
			sum += p.isLeft;
		}
		
		System.out.println(result);
	}
	
	public static class Point {
		int x;
		int isLeft;
		
		Point(int x, int isLeft) {
			this.x = x;
			this.isLeft = isLeft;
		}
	}
	
	public static Comparator<Point> getPointCom() {
		return new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				int compareX = Integer.compare(p1.x, p2.x);
				
				if (compareX == 0) {
					// -1 이 먼저와야함 -> 선분 점에서 겹치는건 겹치는게 아니라
					return Integer.compare(p1.isLeft, p2.isLeft);
				} else {
					return compareX;
				}
			}
		};
	}
}