import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1) {
				break;
			}
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					arr.add(i);
				}
			}

			int sum = 0;
			for (int i = 0; i < arr.size()-1; i ++) {
				sum += arr.get(i);
			}
			if (sum == n) {
				arr.remove(arr.size()-1);
				System.out.printf("%d = ", n);
				System.out.println(arr.toString().replaceAll("[\\[\\]]", "").replaceAll("[,]", " +"));
			}
			else {
				System.out.printf("%d is NOT perfect.\n",n);
			}
		}
	}
}
