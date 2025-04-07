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
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			inDegree[b]++;
			graph.get(a).add(b);
		}

		// 결과 que
		ArrayDeque<Integer> resultQue = new ArrayDeque<>();
		// 위상정렬을 위한 que
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				que.offer(i);
			}
		}

		while (!que.isEmpty()) {
			int now = que.poll();
			resultQue.offer(now);

			for (int num : graph.get(now)) {
				inDegree[num]--;
				if (inDegree[num] == 0) {
					que.offer(num);
				}
			}
		}

		while (!resultQue.isEmpty()) {
			System.out.print(resultQue.poll() + " ");
		}
	}
}