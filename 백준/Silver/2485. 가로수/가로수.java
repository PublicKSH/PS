import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		// 가로수간의 차이를 저장하는 배열
		int[] difArr = new int[n - 1];
		int result = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// n >= 3
		for (int i = 0; i < n - 1; i++) {
			difArr[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(difArr);
		

		// 최대 공배수를 구하기
		int gcdNum = gcd(difArr[0], difArr[1]);
		for (int i=2; i < n-1; i++) {
			gcdNum = gcd(gcdNum, difArr[i]);
		}

		for (int i = 0; i < n - 1; i++) {
			result += difArr[i]/gcdNum - 1;
		}
		System.out.print(result);
		// 놓친게 어디일까?

	}

	// 최대 공배수를 구하는 문제
	public static int gcd(int a, int b) {
		int r;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
