
// boj 19532
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStrArr = br.readLine().split(" ");
		int a = Integer.parseInt(inputStrArr[0]);
		int b = Integer.parseInt(inputStrArr[1]);
		int c = Integer.parseInt(inputStrArr[2]);
		int d = Integer.parseInt(inputStrArr[3]);
		int e = Integer.parseInt(inputStrArr[4]);
		int f = Integer.parseInt(inputStrArr[5]);
		int x;
		int y;

		for (x = -999; x < 1000; x++) {
			for (y = -999; y < 1000; y++) {
				if (a * x + b * y == c && d * x + e * y == f) {
					System.out.printf("%d %d", x, y);
					return;
				}
			}
		}
	}
}