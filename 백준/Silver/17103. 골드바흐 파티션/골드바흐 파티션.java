import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int MAX = 1000000;
	static boolean[] isPrime = new boolean[MAX + 1];

	static {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= MAX; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> primeArr = new ArrayList<>();

		for (int i = 1; i <= MAX; i++) {
			if (isPrime[i]) {
				primeArr.add(i);
			}
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 0; i < primeArr.size(); i++) {
				if (primeArr.get(i) > n/2) {
					break;
				}
				if (isPrime[n - primeArr.get(i)]) {
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}