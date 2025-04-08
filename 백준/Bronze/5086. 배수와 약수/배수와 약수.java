import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		while (true) {
			String[] st = br.readLine().split(" ");
			int n = Integer.parseInt(st[0]), m = Integer.parseInt(st[1]);
			
			if (n==0 && m==0) {
				break;
			}
			if (n < m && m % n == 0) {
				System.out.println("factor");
			} else if (n > m && n % m == 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}	
		}
		
	}
}
