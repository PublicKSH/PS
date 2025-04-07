
// 처음 시도 실패 -> double 형 때문
// 또 다각형이 오목한 경우도 존재 -> 삼각형으로 나누기 보단 신발끈 공식 사용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] xList = new long[n + 1];
		long[] yList = new long[n + 1];
		long sumA = 0;
		long sumB = 0;
		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			xList[i] = Long.parseLong(st[0]);
			yList[i] = Long.parseLong(st[1]);
		}

		xList[n] = xList[0];
		yList[n] = yList[0];

		for (int i = 0; i < n; i++) {
			sumA += xList[i] * yList[i + 1];
			sumB += xList[i + 1] * yList[i];
		}

		System.out.printf("%.1f", Math.abs(sumA - sumB) / 2.0);
	}
}