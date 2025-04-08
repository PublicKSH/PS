import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int m;
	static int h;
	static int[][] parent;
	static int[] depth;
	static ArrayList<Integer>[] graph;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
		// 높이가 2^i 인 부모를 저장
		parent = new int[n + 1][h];
		depth = new int[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		// parent[][0], depth[] 를 초기화
		init(1, 0, 0);
		// parent[][i]를 초기화
		initParents();

		// lca 구현
		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a, b)).append("\n");
		}

		System.out.println(sb.toString());
	}

	// parent[][0]를 초기화
	static void init(int cur, int h, int pa) {
		depth[cur] = h;
		parent[cur][0] = pa;
		for (int nextNode : graph[cur]) {
			// if (nextNode != pa) => 부모로 거슬러 올라가지 않도록 하는 함수
			if (nextNode != pa) {
				init(nextNode, h + 1, cur);
			}
		}
	}

	// parent[][0]를 초기화 하고 parent[][i]를 초기화 하는 함수
	static void initParents() {
		for (int i = 1; i <= h - 1; i++) {
			for (int j = 1; j <= n; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	public static int lca(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];

		// ah 가 더 깊은 노드가 되도록 바꾸기
		if (ah < bh) {
			int temp = b;
			b = a;
			a = temp;
		}

		// a와 b의 높이를 맞추기 (2^i 씩 올라가면서)
		for (int i = h - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[a][i];
			}
		}
		if (a == b)
			return a;

		// 공통 조상을 찾으러 올라갑니다 
		for (int i = h - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
}
