import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		int th = (int) Math.ceil(Math.log(N + 1) / Math.log(2)) + 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		tree = new int[1 << th];
		M = Integer.parseInt(br.readLine());
		arr[0] = Integer.MAX_VALUE;
		init(1, 1, N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int ql = Integer.parseInt(st.nextToken());
			int qr = Integer.parseInt(st.nextToken());
			if (q == 1) {
				update(1, 1, N, ql, qr);
			} else {
				System.out.println(query(1, 1, N, ql, qr));
			}
		}
		return;
	}

	public static void init(int node, int s, int e) {
		if (s == e) {
			tree[node] = s;
			return;
		}

		init(node * 2, s, (s + e) / 2);
		init(node * 2 + 1, (s + e) / 2 + 1, e);
		if (arr[tree[node * 2]] == arr[tree[node * 2 + 1]]) {
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		} else if (arr[tree[node * 2]] < arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}
	}

	public static int query(int node, int s, int e, int ql, int qr) {
		if (e < ql || s > qr) {
			// arr[0] = 10억
			return 0;
		}

		if (ql <= s && e <= qr) {
			return tree[node];
		}

		int l = query(node * 2, s, (s + e) / 2, ql, qr);
		int r = query(node * 2 + 1, (s + e) / 2 + 1, e, ql, qr);
		if (arr[l] == arr[r]) {
			return Math.min(l, r);
		} else if (arr[l] < arr[r]) {
			return l;
		} else {
			return r;
		}
	}

	public static void update(int node, int s, int e, int idx, int value) {
		if (e < idx || s > idx) {
			return;
		}

		
		
		if (idx <= s && e <= idx) {
			arr[s] = value;
			return;
		}

		update(node * 2, s, (s + e) / 2, idx, value);
		update(node * 2 + 1, (s + e) / 2 + 1, e, idx, value);
		if (arr[tree[node * 2]] == arr[tree[node * 2 + 1]]) {
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		} else if (arr[tree[node * 2]] < arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}
	}
}