import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[] dp;
	static int result;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			// 1. dp lis
			// N = Integer.parseInt(br.readLine());
			// arr = new int[N + 1];
			// dp = new int[N + 1];
			// st = new StringTokenizer(br.readLine());
			// result = 0;
			// for (int i = 1; i <= N; i++) {
			// arr[i] = Integer.parseInt(st.nextToken());
			// }

			//
			// for (int i = 1; i <= N; i++) {
			// for (int j = 0; j < i; j++) {
			// if (arr[i] > arr[j]) {
			// dp[i] = Math.max(dp[i], dp[j] + 1);
			// }
			// }
			// }
			//
			// for (int i = 0; i <= N; i++) {
			// if (result < dp[i])
			// result = dp[i];
			// }

			// 2. dp + 이분탐색 lis
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer> list = new ArrayList<>();
			list.add(arr[0]);

			for (int i = 1; i < N; i++) {
				int s = 0;
				int e = list.size();
				int mid = 0;

				while (s < e) {
					mid = (s + e) / 2;
					if (list.get(mid) < arr[i]) {
						s = mid + 1;
					} else {
						e = mid;
					}
				}

				if (e == list.size()) {
					list.add(arr[i]);
				} else {
					list.set(e, arr[i]);
				}
			}
			System.out.printf("#%d %d\n", t, list.size());
		}
	}
}