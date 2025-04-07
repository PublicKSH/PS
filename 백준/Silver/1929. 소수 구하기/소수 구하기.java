import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int MAX = 1000000;
	static boolean[] isPrime = new boolean[MAX + 1];
	
	static {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i*i <= MAX; i++) {
			if (isPrime[i]) {
				for (int j = i*i; j <= MAX; j +=i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] inputStrArr = br.readLine().split(" ");
		int m = Integer.parseInt(inputStrArr[0]), n = Integer.parseInt(inputStrArr[1]);
	
		for (int i = m; i<=n; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
	}
}
