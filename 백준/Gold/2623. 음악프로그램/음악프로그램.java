import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] inDegree = new int[N + 1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K - 1; j++) {
				int b = Integer.parseInt(st.nextToken());
				inDegree[b]++;
				graph.get(a).add(b);
				a = b;
			}
		}
		
		
		ArrayDeque<Integer> que = new ArrayDeque<>();
		ArrayDeque<Integer> result = new ArrayDeque<>();
		for (int i =1; i<=N; i++) {
			if (inDegree[i] == 0) {
				que.offer(i);	
			}
		}
		
		while (!que.isEmpty()) {
			int now = que.poll();
			result.offer(now);
			
			for (int next : graph.get(now)) {
				inDegree[next]--;
				if(inDegree[next] == 0) {
					que.offer(next);
				}
			}
		}
		
		if (result.size() != N) {
			System.out.println(0);
		}
		else {
			while(!result.isEmpty()) {
				System.out.println(result.poll());
			}
		}
		return;
	}
}