import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int s;
	int e;
	long num;
	long lazy;
	// 등차 수열 : a + (n-1)d
	// n : (e-s) + 1
	// 등차 수열의 합 : n*(2*a + (n-1)*d)/2
	long a;
	long d;

	// 수열 더하기
	void sumSeq(long a, long d) {
		int n = (e - s) + 1;
		num += n * (2 * a + (n - 1) * d) / 2;
	}

	void updateLazy(long a2, long d2) {
		this.a += a2;
		this.d += d2;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int N;
	static int Q;
	static Node[] tree;

	// lazy를 int[]로 관리하는게 맞아?
	public static void main(String args[]) throws Exception {
		N = Integer.parseInt(br.readLine());
		int th = (int) (Math.ceil(Math.log(N) / Math.log(2)));
		arr = new int[N];
		tree = new Node[1 << (th + 1)];
		for (int i = 0; i < (1 << (th + 1)); i++) {
			tree[i] = new Node();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 0, N - 1);

		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if (q == 1) {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				update(1, 0, N - 1, l - 1, r - 1);

			} else {
				int x = Integer.parseInt(st.nextToken());
				System.out.println(query(1, 0, N - 1, x - 1, x - 1));
			}
		}
		return;
	}

	public static void init(int node, int s, int e) {
		if (s == e) {
			tree[node].s = s;
			tree[node].e = e;
			tree[node].num = arr[s];
			return;
		}

		init(node * 2, s, (s + e) / 2);
		init(node * 2 + 1, (s + e) / 2 + 1, e);
		tree[node].num = tree[node * 2].num + tree[node * 2 + 1].num;
		tree[node].s = tree[node * 2].s;
		tree[node].e = tree[node * 2 + 1].e;
	}

	// todo: ql, qr을 x로 바꾸어 보자(연습)
	public static long query(int node, int s, int e, int ql, int qr) {
		update_lazy(node, s, e);
		if (e < ql || s > qr) {
			return 0;
		}

		if (ql <= s && e <= qr) {
			return tree[node].num;
		}

		long left = query(node * 2, s, (s + e) / 2, ql, qr);
		long right = query(node * 2 + 1, (s + e) / 2 + 1, e, ql, qr);
		return left + right;
	}

	public static void update_lazy(int node, int s, int e) {
		// tree[node].lazy => 있으면
		// tree[node].num => update 하고
		// tree[node*2],tree[node*2+1] 에 내려줌
		if (tree[node].d != 0) {
			tree[node].sumSeq(tree[node].a, tree[node].d);
			// lazy 반영
			if (s != e) {
				// 오른쪽 노드에 lazy 내려주기
				tree[node * 2].updateLazy(tree[node].a, tree[node].d);
				// 오른쪽 노드에 lazy 내려주기
				tree[node * 2 + 1].updateLazy(tree[node].a + (tree[node * 2].e - tree[node * 2].s + 1) * tree[node].d,
						tree[node].d);
			}

			// lazy 초기화
			tree[node].a = 0;
			tree[node].d = 0;
		}

	}

	public static void update(int node, int s, int e, int ql, int qr) {
		update_lazy(node, s, e);
		if (e < ql || s > qr) {
			return;
		}

		if (ql <= s && e <= qr) {
			tree[node].sumSeq(s - ql + 1, 1);
			if (s != e) {
				// 왼쪽 노드에 lazy 내려주기
				tree[node * 2].updateLazy(s - ql + 1, 1);
				// 오른쪽 노드에 lazy 내려주기
				tree[node * 2 + 1].updateLazy(tree[node * 2 + 1].s - ql + 1, 1);
			}
			return;
		}

		update(node * 2, s, (s + e) / 2, ql, qr);
		update(node * 2 + 1, (s + e) / 2 + 1, e, ql, qr);
	}

}
