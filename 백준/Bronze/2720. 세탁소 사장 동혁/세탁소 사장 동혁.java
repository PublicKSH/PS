import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		int cent = 0;
		int remain = 0;
		final int QUATER = 25;
		final int DIME= 10;
		final int NICKEL = 5;
		final int PENNY = 1;
		int[] centUnits = {QUATER, DIME, NICKEL, PENNY};
		for (int tc = 0; tc < t; tc++) {
			cent = Integer.parseInt(br.readLine());
			for (int centUnit : centUnits) {
				System.out.printf("%d ", cent/centUnit);
				cent %= centUnit;
			}
			System.out.println();
		}
	}
}
