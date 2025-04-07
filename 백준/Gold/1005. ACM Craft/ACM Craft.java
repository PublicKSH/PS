import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int INF = 1_000_000_000;
	static int[] inDegree;
	static int[] arr;
	static int[] result;
	static int target;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];
			result = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			inDegree = new int[N + 1];
			graph = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				inDegree[b]++;
				graph.get(a).add(b);
			}
			target = Integer.parseInt(br.readLine());

			ArrayDeque<Integer> que = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) {
					result[i] = arr[i];
					que.offer(i);
				}
			}

			while (!que.isEmpty()) {
				int now = que.poll();

				for (int next : graph.get(now)) {
					inDegree[next]--;
					// 아래 부분 다시 작성해야함
					result[next] = Math.max(result[next], arr[next] + result[now]);
					if (inDegree[next] == 0) {
						que.offer(next);
					}
				}
			}

			System.out.println(result[target]);
		}
	}
}