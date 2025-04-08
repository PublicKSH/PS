import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		Arrays.fill(parents, -1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 만약 a, b 가 이미 집합에 포함되어 있다면?
			if (!union(a, b)) {
				System.out.println(i+1);
				return;
			}
			
		}
		System.out.println(0);
	}

	public static boolean union(int u, int v) {
		u = find(u);
		v = find(v);

		if (u == v) {
			return false;
		}

		// v 의 랭크가 더 크면
		if (parents[v] < parents[u]) {
			int temp = v;
			v = u;
			u = temp;
		}
		if (parents[u] == parents[v]) {
			parents[u]--;
		}
		// v를 u의 자식으로 만들기
		parents[v] = u;
		return true;
	}

	public static int find(int x) {
		// 루트 노드면 return
		if (parents[x] < 0) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
}