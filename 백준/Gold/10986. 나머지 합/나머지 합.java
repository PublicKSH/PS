
// 모듈러 연산, 구간합, 조합(경우의 수만)
// 틀린부분 10^9 를 보고 long 형태를 떠올리지 못함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] intst = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		String[] st = br.readLine().split(" ");
		int n = intst[0], m = intst[1];
		long[] dp = new long[n + 1];
		long[] modDp = new long[m];

		for (int i = 0; i < n; i++) {
			dp[i + 1] = (Long.parseLong(st[i]) % m + dp[i] % m) % m;
			modDp[(int) dp[i + 1]]++;
		}

		long result = modDp[0];

		for (int i = 0; i < m; i++) {
			if (modDp[i] > 1) {
				result += (modDp[i] * (modDp[i] - 1)) / 2;
			}
		}

		System.out.println(result);
	}
}
