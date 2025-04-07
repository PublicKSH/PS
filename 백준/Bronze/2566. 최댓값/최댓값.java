import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] st;
		int n = 9, m = 9;
		int[][] arr = new int[n][m];
		int resultR= 0;
		int resultC = 0;
		int resultMax = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (resultMax < arr[i][j]) { 
					resultMax = arr[i][j];
					resultR = i + 1;
					resultC = j + 1;
				}
			}
		}
		

		System.out.println("" + resultMax);
		System.out.println("" + resultR + " " + resultC);
	}
}
