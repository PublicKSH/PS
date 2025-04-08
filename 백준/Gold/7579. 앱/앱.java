import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] memory;
	static int[] cost;
	// [idx][cost] = cost 당 가질수 있는 최대 메모리
	// [idx]memory] = memory를 얻기위한 최소 코스트 -> memory가 1000만이라 시간에서 불이익 발생
	static int[] dp;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memory = new int[N];
		cost = new int[N];
		// 10001 => cost는 100까지 이고 100개 까지 있을 수 있다.
		dp = new int[10001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		// 바텀 업
		for (int i = 0; i < N; i++) {
			for (int j = 10000; j >= 0; j--) {
				if (j >= cost[i]) {
					dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
				}
			}
		}
		
		int cost = 0;
		while(dp[cost] < M) {
			cost++;
		}

		System.out.println(cost);
	}

}
