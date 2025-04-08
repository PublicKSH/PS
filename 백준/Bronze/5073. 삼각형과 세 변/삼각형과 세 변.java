import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	// static으로 변수를 선언해 버리면 -> 메모리 이점이 있다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		while (true) {

			String[] strArr = br.readLine().split(" ");
			int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arr);
			// a <= b <= c;
			int a = arr[0];
			int b = arr[1];
			int c = arr[2];
			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			if (a + b > c) {
				if (a == b && b == c) {
					System.out.println("Equilateral");
				} else if (a == b || b == c || c == a) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
			} else {
				System.out.println("Invalid");
			}

		}

	}
}
