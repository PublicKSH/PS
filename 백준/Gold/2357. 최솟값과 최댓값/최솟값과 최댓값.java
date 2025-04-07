import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] maxTree, minTree;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		maxTree = new int[N * 4 + 1];
		minTree = new int[N * 4 + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(getMinQuery(1, 0, N - 1, a-1, b-1) + " " + getMaxQuery(1, 0, N - 1, a-1, b-1));
		}
	}

	public static void init(int node, int nodeStart, int nodeEnd) {
		if (nodeStart == nodeEnd) {
			minTree[node] = arr[nodeStart];
			maxTree[node] = arr[nodeStart];
			return;
		}

		init(node * 2, nodeStart, (nodeStart + nodeEnd) / 2);
		init(node * 2 + 1, (nodeStart + nodeEnd) / 2 + 1, nodeEnd);
		maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
		minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
	}

	public static int getMinQuery(int node, int nodeStart, int nodeEnd, int a, int b) {
		// 범위를 넘어가면 return
		if (b < nodeStart || nodeEnd < a) {
			return Integer.MAX_VALUE;
		}

		// 범위 안에 있으면 Ok
		if (nodeStart >= a && nodeEnd <= b) {
			return minTree[node];
		}

		int left = getMinQuery(node * 2, nodeStart, (nodeStart + nodeEnd) / 2, a, b);
		int right = getMinQuery(node * 2 + 1, (nodeStart + nodeEnd) / 2 + 1, nodeEnd, a, b);
		return Math.min(left, right);
	}

	public static int getMaxQuery(int node, int nodeStart, int nodeEnd, int a, int b) {
		// 범위를 넘어가면 return
		if (b < nodeStart || nodeEnd < a) {
			return 0;
		}

		// 범위 안에 있으면 Ok
		if (nodeStart >= a && nodeEnd <= b) {
			return maxTree[node];
		}

		int left = getMaxQuery(node * 2, nodeStart, (nodeStart + nodeEnd) / 2, a, b);
		int right = getMaxQuery(node * 2 + 1, (nodeStart + nodeEnd) / 2 + 1, nodeEnd, a, b);
		return Math.max(left, right);
	}
}
