import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
				k = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		SegmentTree segTree = new SegmentTree(arr);
//		System.out.println(segTree);
		for (int i = 0; i < k + m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				segTree.update(b - 1, c);
//				System.out.println(segTree);
			} else {
				System.out.println(segTree.getSum(b - 1, (int) c));
//				System.out.println(segTree);
			}
		}
	}
}

// 해당 세그먼트 트리는 기본적인(교환법칙이 성립하는 연산)인 경우만 가능
class SegmentTree {
	long[] tree;
	int n; // arr length

	SegmentTree(long[] arr) {
		n = arr.length;
		tree = new long[2 * n];
		for (int i = 0; i < n; i++) {
			tree[i + n] = arr[i];
		}

		for (int i = n - 1; i > 0; i--) {
			tree[i] = tree[i << 1] + tree[i << 1 | 1];
		}
	}

	// index i의 값을 x로 바꿈
	void update(int i, long x) {
		tree[i += n] = x;

		while ((i = i >> 1) != 0) {
			tree[i] = tree[i << 1] + tree[i << 1 | 1];
		}
	}

	// [i, r)
	long getSum(int i, int r) {
		long result = 0;

		for (i += n, r += n; i != r; i >>= 1, r >>= 1) {
			if (i % 2 == 1) {
				result += tree[i++];
			}
			if (r % 2 == 1) {
				result += tree[--r];
			}
		}

		return result;
	}

	public String toString() {
		return Arrays.toString(tree);
	}
}