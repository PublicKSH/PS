// 틀린부분 -> 출력에 System.out.println() 사용시 시간초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer(); 
	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		StringBuffer result = new StringBuffer();
		int N = Integer.parseInt(st[0]);
		int K = Integer.parseInt(st[1]);

		Queue<Integer> que = new ArrayDeque<>();
		result.append("<");
		for (int i = 0; i < N; i++) {
			que.offer(i+1);
		}
		
		while (que.size() != 1) {
			for (int i=0; i<K-1; i++) {
				que.offer(que.poll());
			}
			result.append(que.poll()).append(", ");
		}
		
		result.append(que.poll()).append(">");
		System.out.println(result);
	}
}