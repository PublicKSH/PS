import java.io.*;
import java.util.*;

// 해설을 보았습니다.... 
// 풀이 방법은 총 3가지 1. 분할 정복 2. 분할정복 + 세그먼트 트리 3. 단조 스텍
// 세그먼트 트리 + 분할 정복을 통해서 풀이 진행

// arr[0] * 1000000 => arr이 int형이면 오버플로우 나타나서 틀립니다
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static long[] arr;
	static int[] tree;

	public static void main(String[] args) throws Exception {
			N = Integer.parseInt(br.readLine());

			arr = new long[N];
			int treeHeight = (int) (Math.ceil(Math.log(N) / Math.log(2)));
			tree = new int[1 << (treeHeight + 1)];
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}

			init(1, 0, N - 1);
			System.out.println(getMaxArea(0, N - 1));
	}

	// 분할 정복
	public static long getMaxArea(int start, int end) {

		int min = getQuery(1, 0, N - 1, start, end);
//		System.out.println(min + ", " + start + ", " + end);
		long area = arr[min] * (end - start + 1);
		// min을 기준으로 왼쪽 오른쪽 분할 탐색
		if (min - 1 >= start) {
			long leftMaxArea = getMaxArea(start, min - 1);
			area = Math.max(area, leftMaxArea);
		}

		if (min + 1 <= end) {
			long rightMaxArea = getMaxArea(min + 1, end);
			area = Math.max(area, rightMaxArea);
		}

		return area;
	}

	// 세그먼트 트리
	public static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}

		init(node * 2, start, (start + end) / 2);
		init(node * 2 + 1, (start + end) / 2 + 1, end);
		if (arr[tree[node * 2]] < arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}
	}

	public static int getQuery(int node, int start, int end, int ql, int qr) {
		if (ql > end || qr < start) {
			return -1;
		}

		if (start >= ql && qr >= end) {
			return tree[node];
		}

		int left = getQuery(node * 2, start, (start + end) / 2, ql, qr);
		int right = getQuery(node * 2 + 1, (start + end) / 2 + 1, end, ql, qr);
		if (left == -1) {
			return right;
		}
		if (right == -1) {
			return left;
		}
		if (arr[left] < arr[right]) {
			return left;
		} else {
			return right;
		}
	}
}