import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int tSet = 0;
		for (int i = 0; i < 6; i++) {
			tSet += Math.ceil(arr[i] / (double) T);
		}

		System.out.println(tSet);
		System.out.println(N / P + " " + N % P);
	}
}