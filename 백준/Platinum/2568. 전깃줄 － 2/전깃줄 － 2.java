import java.io.*;
import java.util.*;

class Line {
	int aIdx;
	int bIdx;
	Line prev;
	Line next;

	public Line(int aIdx, int bIdx) {
		this.aIdx = aIdx;
		this.bIdx = bIdx;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
//	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		ArrayList<Line> list = new ArrayList<>();
		ArrayList<Line> lis = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int aIdx = Integer.parseInt(st.nextToken());
			int bIdx = Integer.parseInt(st.nextToken());
			list.add(new Line(aIdx, bIdx));
		}

		// SORT -> NlogN
		list.sort(new Comparator<Line>() {
			@Override
			public int compare(Line l1, Line l2) {
				return l1.aIdx - l2.aIdx;
			}
		});

		// LIS -> NlogN
		for (int i = 0; i < N; i++) {
			// lowerBonnd
			int l = 0;
			int r = lis.size();
			int mid = 0;
			while (l < r) {
				mid = l + (r - l) / 2;
				if (lis.get(mid).bIdx >= list.get(i).bIdx) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}

			// LIS 연결
			if (l > lis.size() - 1) {
				lis.add(list.get(i));
				// 추가한 전기줄 앞에 연결할 전깃줄이 있다면
				if (lis.size() != 1) {
					lis.get(lis.size() - 1).prev = lis.get(lis.size() - 2);
				}
			} else {
				lis.set(l, list.get(i));
				if (l != 0) {
					lis.get(l).prev = lis.get(l - 1);
				}

			}
		}
		System.out.println(N - lis.size());
		Line line = lis.get(lis.size() - 1);
		HashSet<Integer> set = new HashSet<>();
		while(line != null) {
			set.add(line.aIdx);
			line = line.prev;
		}

		for (int i = 0; i < N; i++) {
			if (!set.contains(list.get(i).aIdx)) {
				System.out.println(list.get(i).aIdx);
			}
		}
		
	}
}
