import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]), k = Integer.parseInt(st[1]);

		int[] arr = new int[n];
		int arrIndex = 0;
		for (int i = 1; i <= n; i++) {
			if (arrIndex == k) {
				break;
			}
			if (n % i == 0) {
				arr[arrIndex] = i;
				arrIndex++;
			}
		}
		
		// 만약 N의 약수의 개수가 K개보다 적어서 K번째 약수가 존재하지 않을 결우에는 0 => arr는 기본적으로 0으로 초기화 되기 때문에 처리
		System.out.println(arr[k-1]);
	}
}
