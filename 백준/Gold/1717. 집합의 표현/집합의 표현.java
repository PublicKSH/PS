
// 집합의 표현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] parents = new int[1000001];

	public static void main(String[] args) throws IOException {
		int[] IIA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = IIA[0], m = IIA[1];

		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			IIA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int operator = IIA[0];
			int a = IIA[1];
			int b = IIA[2];
			if (operator == 0) {
				union(a,b);
			} else {
				if (find(a) == find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
					
			}
		}
	}

	// 같은 집합에 있는지만 확인하니까 경로 압축만 진행(union by rank 사용 x)
	static void union(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);
		
		if (rootU == rootV) {
			return;
		}
		
		// 집합 u를 집합 v에 합침
		parents[rootU] = rootV;
	}

	// find 에서 경로 압축 진행
	public static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		parents[x] = find(parents[x]);
		return parents[x];
	}
}
