
// 접근 방법
// 모든 집에 대해서 최소 길의 유지비를 구함 - 트리형태 & 이때 모든 집은 연결이 되어있는 상태
// 만든 트리의 가장 큰 유지비를 지니는 길을 없애기 -> 트리를 자르면 트리여서 모든 집은 연결 되어 있는 상태
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parents = new int[100001];

	public static void main(String[] args) throws IOException {
		int[] IIA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = IIA[0], m = IIA[1];
		ArrayList<Edge> eList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			parents[i] = -1;
		}

		for (int i = 0; i < m; i++) {
			IIA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int a = IIA[0], b = IIA[1], c = IIA[2];
			eList.add(new Edge(a, b, c));
		}

		// 100000 * log(100000)
		Collections.sort(eList);

		// 최소 신장 트리 구하기
		// 최소 신장트리의 최대 간선
		int max = 0;
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			Edge nowNode = eList.get(i);
			if (!isDiffGroup(nowNode.u, nowNode.v)) {
				continue;
			}
//			System.out.println(nowNode.u + " " + nowNode.v + " " + nowNode.w);
			result += nowNode.w;
			max = Math.max(max, nowNode.w);
			cnt++;
			if (cnt == n-1) {
				break;
			}
		}
		
		System.out.println(result - max);
	}

	public static int find(int x) {
		if (parents[x] < 0) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	
	public static boolean isDiffGroup(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v) {
			return false;
		}
		
		// 트리 래밸 올리기
		if (parents[u] == parents[v]) {
			parents[u]--;
		}
		
		// u가 속한 트리가 v가 속한 트리보다 깊다. v 트리를 u 트리 에 포함시키기
		if (parents[u] < parents[v]) {
			parents[v] = u;
		} else {
			parents[u] = v;
		}
		
		
		return true;
	}
	public static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}