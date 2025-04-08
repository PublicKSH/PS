import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	// static으로 변수를 선언해 버리면 -> 메모리 이점이 있다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 세 각의 크기가 모두 60이면, Equilateral
		// 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
		// 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
		// 세 각의 합이 180이 아닌 경우에는 Error
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		if (a + b + c == 180) {
			if (a == b && b ==c) {
				System.out.println("Equilateral");
			} else if (a == b || b == c || c ==a) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		} else {
			System.out.println("Error");
		}
	}
}
