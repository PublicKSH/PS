import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// N log N => 1,000,000
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		int min = Integer.MAX_VALUE;
		int resultS = 0;
		int resultE = 0;
		while (start < end) {
			int sum = arr[start] + arr[end];

			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				resultS = arr[start];
				resultE = arr[end];
			}

			if (sum > 0) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(resultS + " " + resultE);
	}
}

//- 99 -2 -1 4 98
