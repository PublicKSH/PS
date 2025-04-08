import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] arr;
	static long[] tree;
	static long[] lazy;

	public static void main(String args[]) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int th = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[1 << (th + 1)];
		lazy = new long[1 << (th + 1)];
		init(1, 0, N - 1);

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if (q == 2) {
				int x = Integer.parseInt(st.nextToken());
				System.out.println(query(1, 0, N - 1, x-1, x-1) + arr[x-1]);
			} else {
				int ql = Integer.parseInt(st.nextToken());
				int qr = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				update(1, 0, N - 1, ql - 1, qr - 1, k);
			}
		}
	}

	public static void init(int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[s];
			return;
		}

		init(node * 2, s, (s + e) / 2);
		init(node * 2 + 1, (s + e) / 2 + 1, e);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void updateLazy(int node, int s, int e) {
		if (lazy[node] != 0 && s != e) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
			lazy[node] = 0;
		}
	}

	public static long query(int node, int s, int e, int ql, int qr) {
		updateLazy(node, s, e);
		if (s > qr || e < ql) {
			return 0;
		}

		if (ql <= s && e <= qr) {
			return lazy[node];
		}

		return query(node * 2, s, (s + e) / 2, ql, qr) + query(node * 2 + 1, (s + e) / 2 + 1, e, ql, qr);
	}

	public static void update(int node, int s, int e, int ql, int qr, int value) {
		updateLazy(node, s, e);
		if (s > qr || e < ql) {
			return;
		}

		if (ql <= s && e <= qr) {
			if (s != e) {
				lazy[node * 2] += value;
				lazy[node * 2 + 1] += value;
			} else {
				lazy[node] += value;
			}
			return;
		}

		update(node * 2, s, (s + e) / 2, ql, qr, value);
		update(node * 2 + 1, (s + e) / 2 + 1, e, ql, qr, value);
	}

}
