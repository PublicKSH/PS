import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 10,000 * 100,000 = 10억(int 형으로 누적합을 관리 가능)
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		// 누적합 배열, O(N)
		int[] arr = new int[N];
		int[] prefixSumArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		prefixSumArr[0] = arr[0];
		for (int i = 1; i < N; i++) {
			prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
		}

		// 이분 탐색(lowerBound)으로 누적합을 찾음 O(N*logN)
		for (int i = 0; i < N; i++) {
			int l = i;
			int r = N;
			int mid = 0;
			// lower bound
			while (l < r) {
				mid = l + (r - l) / 2;
				// arr[i] 부터 arr[mid] 까지의 누적합
				int prefixSum = prefixSumArr[mid] - prefixSumArr[i] + arr[i];
				if (S <= prefixSum) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if (l < N) {
				result = Math.min(l - i + 1, result);
			}

		}

		if (result == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {

			System.out.println(result);
		}
	}

}
