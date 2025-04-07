
// 집합의 표현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parents = new int[10001];

	public static void main(String[] args) throws IOException {
		int[] IIA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ArrayList<Edge> eList = new ArrayList<>();

		int v = IIA[0], e = IIA[1];

		for (int i = 0; i < v; i++) {
			parents[i] = -1;
		}

		for (int i = 0; i < e; i++) {
			IIA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			eList.add(new Edge(IIA[0], IIA[1], IIA[2]));
		}

		// 시간 복잡도 ElogE
		Collections.sort(eList);

		int result = 0;
		int cnt = 0;
		for (int i = 0; i < e; i++) {
			Edge nowEdge = eList.get(i);

			if (!isDiffGroup(nowEdge.u, nowEdge.v)) {
				continue;
			}

			result += nowEdge.w;
			cnt++;

			if (cnt == v - 1) {
				break;
			}
		}

		System.out.println(result);
	}

	static int find(int x) {
		if (parents[x] < 0) {
			return x;
		}
		parents[x] = find(parents[x]);
		return parents[x];
	}

	// isDiffGroup 같은 그룹이면 true 아니면 false를 return
	// union by rank (작은 트리를 큰트리에 합친다.
	static boolean isDiffGroup(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);

		// 같은 그룹
		if (rootU == rootV) {
			return false;
		}

		if (parents[rootU] == parents[rootV]) {
			parents[rootU]--;
		}

		// u가 속한 집합의 트리가 v 가 속한 집합의 크기보다 크면
		if (parents[rootU] < parents[rootV]) {
			parents[rootV] = rootU;
		} else {
			parents[rootU] = rootV;
		}

		return true;
	}

	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		// 가중치
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
