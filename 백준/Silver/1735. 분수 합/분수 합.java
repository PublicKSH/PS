import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] inputStrArr = br.readLine().split(" ");
		int a1 = Integer.parseInt(inputStrArr[0]), b1 = Integer.parseInt(inputStrArr[1]);
		inputStrArr = br.readLine().split(" ");
		int a2 = Integer.parseInt(inputStrArr[0]), b2 = Integer.parseInt(inputStrArr[1]);
		
		int A = a1*b2 + a2*b1;
		int B = b1*b2;
		int gcd = gcd(A,B);
		System.out.printf("%d %d", A/gcd, B/gcd);
	}

	// 최소 공배수를 구하는 문제
	public static int gcd(int a, int b) {
		int r;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	// 최소 공배수를 구하는 문제
	public int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}