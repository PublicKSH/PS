import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	// static으로 변수를 선언해 버리면 -> 메모리 이점이 있다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] xArr;
	static int[] yArr;
	static String[] strArr;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		xArr = new int[n];
		yArr = new int[n];
		for (int i = 0; i < n; i++) {
			strArr = br.readLine().split(" ");
			xArr[i] = Integer.parseInt(strArr[0]);
			yArr[i] = Integer.parseInt(strArr[1]);
		}
		
		int maxX = Arrays.stream(xArr).max().getAsInt();
		int minX = Arrays.stream(xArr).min().getAsInt();
		int maxY = Arrays.stream(yArr).max().getAsInt();
		int minY = Arrays.stream(yArr).min().getAsInt();
		
		System.out.println((maxY-minY) * (maxX-minX));
	}
}
