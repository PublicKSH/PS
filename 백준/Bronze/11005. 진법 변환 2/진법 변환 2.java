import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int b = Integer.parseInt(st[1]);
		StringBuffer result = new StringBuffer();
		// B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다. => int 로 처리가능
		// 'A' = 65
		// 'A' - 55
		// '0' = 48
		// '9' = 57
		
		// stack 을 쓰거나
		// sb를 뒤집거나
		while (n > 0) {
			int remain = n%b;
			n /= b;
			
			if (remain >= 0 && remain <= 9) {
				result.append((char)(remain + 48));
			} else {
				result.append((char)(remain + 55));	
			}
		}

		System.out.printf(result.reverse().toString());
	}
}