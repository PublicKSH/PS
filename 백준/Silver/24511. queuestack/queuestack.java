// 문제 접근법 -> stack의 값은 초기값인 상태를 그대로 유지한다.
// 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		StringBuffer result = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");
		int[] arrA = new int[N];
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st[i]);
		}
		
		st = br.readLine().split(" ");
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// 거꾸로 Queue에 넣어야함 -> 그래야 맨뒤에 있는것부터 나
		for (int i = N-1; i >= 0; i--) {
			if (arrA[i] == 0) {
				queue.offer(Integer.parseInt(st[i]));	
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = br.readLine().split(" ");
		
		// que인 자료형이 하나도 없는경우에 대한 예외 처
		if (queue.isEmpty()) {
			System.out.println(Arrays.toString(st).replaceAll("[\\[\\],]", ""));
			return;
		}
		for (int i = 0; i < M; i++) {
			sb.append(queue.poll()).append(" ");
			queue.offer(Integer.parseInt(st[i]));
		}
		

		
		System.out.println(sb);
	}
}