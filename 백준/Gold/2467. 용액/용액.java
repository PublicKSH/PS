import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] potionList = new long[n];
		String[] st = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			potionList[i] = Long.parseLong(st[i]);
		}

		int startIndex = 0;
		int endIndex = n - 1;
		int resultStartIndex = startIndex;
		int resultEndIndex = endIndex;
		long minAbs = Math.abs(potionList[endIndex] + potionList[startIndex]);
		
		while (startIndex < endIndex) {
			long tempAbs = Math.abs(potionList[endIndex] + potionList[startIndex]);
			if (tempAbs <= minAbs) {
				resultEndIndex = endIndex;
				resultStartIndex = startIndex;
				minAbs = tempAbs;
			}
			
			if (potionList[endIndex] + potionList[startIndex] > 0) {
				endIndex--;
			} else {
				startIndex++;
			}
		}
		
		System.out.println(potionList[resultStartIndex] + " " + potionList[resultEndIndex]);
	}
}