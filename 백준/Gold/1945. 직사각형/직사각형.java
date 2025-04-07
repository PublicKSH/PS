// 풀이시간 2시간
// 스위핑
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

		// 가장 많이 겹치는 기울기 선분의 개수를 구하면 됨

		// 구하는 방법 두가지를 생각 첫번째는 좌측 상단 기울기를 이동하면서 그때마다 겹치는 선분의 길이 채크
		// 두번째는 기울기의 범위를 줄여가는 방식으로 계산 => 하지만 기울기의 범위를 줄이면 나중에 다시 계산되어야하는 겹치는 선분개수에 영향을
		// 주어서 틀린 접근 방법

		// 1. 기울기 기준으로 직시각형 LIST 정렬, O => NLogN
//		List<Rectangle> recList = new ArrayList<>();
//		
//		for (int i =0; i< N; i++) {
//			String[] st = br.readLine().split(" ");
//			recList.add(new Rectangle(Integer.parseInt(st[0]),Integer.parseInt(st[1]),Integer.parseInt(st[2]),Integer.parseInt(st[3])));
//		}
//		recList.sort(getRecComparator());
//		
//		for (Rectangle rec : recList) {
//			System.out.println(rec.bri);
//		}
		// 2. 좌측 상단 기울기를 이동하면서 그때마다 겹치는 선분의 개수 체크

		// ============ 여기까지 풀었을때 직사각형 class 로는 개수 체크가 힘듦을 깨닳음 결국 필요한건 -> 좌측상단기울기 우측 하단
		// 기울기만 있으면 됨

		List<Inclination> inclinationList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			inclinationList.add(new Inclination(Integer.parseInt(st[0]), Integer.parseInt(st[3]), 1));
			inclinationList.add(new Inclination(Integer.parseInt(st[2]), Integer.parseInt(st[1]), -1));
		}
		inclinationList.sort(getIncCompartor());

		// 스위핑
		int result = 0;
		int sum = 0;
		for (Inclination inc : inclinationList) {
//			System.out.println(inc.inclination + " " + inc.isLeftTop);
			sum += inc.isLeftTop;
			result = Math.max(result, sum);
			
		}
		System.out.println(result);
	}

	public static class Inclination {
		double inclination;
		int isLeftTop; // 좌측 상단이면 + 우측 하단이면 - 를 해줘야 해서 1, 0으로 지정

		Inclination(int x, int y, int isLeftTop) {
			this.inclination = (double)y / x;
			this.isLeftTop = isLeftTop;
		}
	}

	// 큰것이 먼저
	public static Comparator<Inclination> getIncCompartor() {
		return new Comparator<Inclination>() {
			@Override
			public int compare(Inclination l1, Inclination l2) {
				int compareInclination = Double.compare(l1.inclination, l2.inclination);
				if (compareInclination != 0) {
					return compareInclination * -1;
				} else {
					return Integer.compare(l1.isLeftTop, l2.isLeftTop)  * -1;
				}
			}
		};
	}

	// 직사각형을 지나는 선분의 기울기는 직사각형 왼쪽 위 끝점을 지나는 기울기와 오른쪽 아래 끝점을 지나는 기울기 사이에만 있으면 된다.
//	public static class Rectangle{
//		// 네 점의 좌
//		int xbl;
//		int ybl;
//		int xtr;
//		int ytr;
//		
//		// 좌측 상단 기울기 top left
//		double tli;
//		// 우측 하단 기울기 bottom right
//		double bri;
//		
//		Rectangle(int xbl, int ybl, int xtr, int ytr) {
//			this.xbl = xbl;
//			this.ybl = ybl;
//			this.xtr = xtr;
//			this.ytr = ytr;
//			this.tli = ytr/(double)xbl;
//			this.bri = ybl/(double)xtr;
//		}
//	}
//	
//	public static Comparator<Rectangle> getRecComparator(){
//		return new Comparator<Rectangle>() {
//			@Override
//			public int compare(Rectangle r1, Rectangle r2) {
//				int compareBri = Double.compare(r1.bri, r2.bri);
//				if (compareBri != 0) {
//					return compareBri;
//				}
//				else {
//					return Double.compare(r1.tli, r2.tli) * -1;
//				}
//			}
//		};
//	}
}