import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long startPoint = 2;
		for (int i=0; i < n; i++) {
			startPoint = startPoint*2 -1;
		}
		
		System.out.print(startPoint*startPoint);
	}
}
