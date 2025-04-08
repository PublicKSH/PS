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
		int[] result = new int[n];
		int a,b;
		int temp;
		for (int i = 0; i < n; i++) {
			result[i] = i+1;
		}
		
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			a = Integer.parseInt(st[0]);
			b = Integer.parseInt(st[1]);
			if (a == b) {
				continue;
			}
			
			temp = result[a-1];
			result[a-1] = result[b-1];
			result[b-1] = temp; 
		}
		
		System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
	}
}
