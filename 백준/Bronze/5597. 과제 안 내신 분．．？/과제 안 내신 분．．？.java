// boj 5597
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		// String[]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input string 을 다루기 위한 String 객체
		
		int[] result = new int[30];
		int studentNum;
		for (int i = 0; i < 28; i++) {
			studentNum = Integer.parseInt(br.readLine());
			result[studentNum-1] = 1;
		}
		
		for (int i = 0; i < 30; i++) {
			if (result[i] == 0) {
				System.out.println(i+1);
			}
		}
	}
}
