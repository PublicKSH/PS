import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		// 최빈값을 계산하기 위한 배열 최대절대값이 4000을 넘지 않아서 가능 (음수 0 양수)
		// +4000을 해서 계산
		int[] numCountArr = new int[4000 + 1 + 4000];
		ArrayList<Integer> numArr = new ArrayList<>();
		int sum = 0;
		for(int i=0; i< N; i++) {
			int inputInt = Integer.parseInt(br.readLine());
			sum += inputInt;
			numArr.add(inputInt);
			numCountArr[inputInt + 4000]++;
		}
		
		Collections.sort(numArr);
		// 최빈 값 찾기
		// 가장 많이 등장한 횟수 찾기
		int numMaxCount = Integer.MIN_VALUE;
		for (int i=0; i < 8001; i++) {
			numMaxCount = numCountArr[i] > numMaxCount ? numCountArr[i] : numMaxCount;
		}
		// 가장 많이 등장한 숫자 찾기
		int[] numMaxCountArr = new int[2];
		int numMaxCountArrIndex = 0;
		for (int i=0; i < 8001; i++) {
			if (numCountArr[i] == numMaxCount) {
				numMaxCountArr[numMaxCountArrIndex++] = i - 4000;
			}
			if (numMaxCountArrIndex == 2) {
				break;
			}
		}
		
		System.out.println(Math.round(sum/(double)N));
		System.out.println(numArr.get(N/2));
		if (numMaxCountArrIndex == 1) {
			System.out.println(numMaxCountArr[0]);
		} else {
			System.out.println(numMaxCountArr[1]);
		}
		
		System.out.println(numArr.get(N-1) - numArr.get(0));
	}
}