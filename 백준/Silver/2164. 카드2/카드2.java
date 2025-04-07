// 틀린부분 -> 출력에 System.out.println() 사용시 시간초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer(); 
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			que.offer(i+1);
		}
		
		while (que.size() != 1) {
			que.poll();
			que.offer(que.poll());
		}
		
		
		System.out.println(que.peek());
	}
}