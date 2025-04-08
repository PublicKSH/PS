import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		
		
		for (int t =0; t< tc; t++) {
			long n = Long.parseLong(br.readLine());
			
			// n모다 크거나 같은 소수가 나올때 까지 계산
			// 메모리 제한으로 에라토스 사용시 메모리 에러 발생
			if (n ==0 || n==1) {
				System.out.println(2);
				continue;
			}
			
			// n >= 2
			while(true) {
				if (isPrime(n)) {
					System.out.println(n);
					break;
				}
				n++;
			}
		}
	}
	
	static boolean isPrime(long n) {
		for (long i=2; i*i <= n; i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
