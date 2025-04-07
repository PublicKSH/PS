// 스위핑
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 스위핑
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());		
		List<Line> lineList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			lineList.add(new Line(Integer.parseInt(st[0]), Integer.parseInt(st[1])));
		}
		
		// 정렬, O => NLogN
		lineList.sort(getLineComparator());
		
		// 라인 합치기, O => N
		//선분이 다 합쳐지면 result 추가
		int result = 0;
		int startIndex = lineList.get(0).startX;
		int endIndex = lineList.get(0).endX;
		for (int i =0; i < lineList.size(); i++) {
			if (lineList.get(i).startX <= endIndex) {
				if (lineList.get(i).endX > endIndex) {
					endIndex = lineList.get(i).endX;
				}

			}
			else {
				// 선분이 안 합쳐지면 합쳐진 선분 값 계산후 새로운 선분 계산
				result += endIndex - startIndex; 
				startIndex = lineList.get(i).startX;
				endIndex = lineList.get(i).endX;
			}
		}
		
		// 남은 선분 합치기
		result += endIndex - startIndex; 
		
		System.out.println(result);
	}
	
	public static class Line {
		int startX;
		int endX;
		
		Line(int x, int y) {
			this.startX = x;
			this.endX = y;
		}
	}
	
	// x는 그대로 같으면 y는 반대로
	public static Comparator<Line> getLineComparator() {
		return new Comparator<Line>() {
			@Override
			public int compare(Line l1, Line l2) {
				int compareX = Integer.compare(l1.startX, l2.startX);
				if (compareX != 0) {
					return compareX;
				}
				else {
					return Integer.compare(l1.endX, l2.endX) * -1;
				}
			}
		};
	}
}