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
		int i,j,k;
		// 0 으로 초기화 되어있음 -> primitive []
		int[] result = new int[n];
		
		// 공부 1 for 문으로 array[] 값
		for (int index = 0; index < m; index++) {
			st = br.readLine().split(" ");
			
			i = Integer.parseInt(st[0]);
			j = Integer.parseInt(st[1]);
			k = Integer.parseInt(st[2]);

			Arrays.fill(result, i-1, j, k);
		}
		
				
		System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
	}
}