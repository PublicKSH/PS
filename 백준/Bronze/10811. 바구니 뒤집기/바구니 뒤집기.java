
// boj 5597
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		// String[]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input string 을 다루기 위한 String 객체
		String[] st;
		st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]), m = Integer.parseInt(st[1]);
		int i, j, k;
		// 0 으로 초기화 되어있음 -> primitive []
		int[] result = new int[n];
		int temp;
		for (int index = 0; index < n; index++) {
			result[index] = index + 1;
		}

		for (int index = 0; index < m; index++) {
			st = br.readLine().split(" ");

			i = Integer.parseInt(st[0]);
			j = Integer.parseInt(st[1]);

			// 1. for 문 사용해서 역순
			// 2. Arrays utils 사용해서 역순

			// array.clone -> array가 primitive array이니까 깊은 복사
			while (j > i) {
				temp = result[i - 1];
				result[i - 1] = result[j - 1];
				result[j - 1] = temp;
				i++;
				j--;
			}

		}
		System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));

	}
}
