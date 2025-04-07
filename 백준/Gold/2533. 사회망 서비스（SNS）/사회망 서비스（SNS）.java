import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 부모가 얼리 어답터이면 -> 자식은 얼리 어답터가 아니여도됨
	// 부모가 얼리 어답터가 아니면 -> 자식은 must 얼리 어답터여야함
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static ArrayList<ArrayList<Integer>> tree;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];
		tree = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		dfs(1, 0);
		System.out.println(Math.min(dp[1][1], dp[1][0]));
	}

	public static void dfs(int node, int parent) {
		dp[node][0] = 0;
		dp[node][1] = 1;

		for (int n : tree.get(node)) {
			if (parent != n) {
				dfs(n, node);
			}
		}

		dp[parent][0] += dp[node][1];
		dp[parent][1] += Math.min(dp[node][0], dp[node][1]);
	}
}
