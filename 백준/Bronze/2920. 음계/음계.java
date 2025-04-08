import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		int[] ascArr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] desArr = { 8, 7, 6, 5, 4, 3, 2, 1 };
		boolean isASC = true;
		boolean isDES = true;
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 8; i++) {
			if (arr[i] != ascArr[i]) {
				isASC = false;
			}
			if (arr[i] != desArr[i]) {
				isDES = false;
			}
		}

		if (isASC) {
			System.out.println("ascending");
		} else if (isDES) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}