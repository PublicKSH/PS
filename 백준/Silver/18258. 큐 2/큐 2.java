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

		ArrayDeque<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			switch (st[0]) {
			case "push":
				que.offer(Integer.parseInt(st[1]));
				break;
			case "pop":
				if (que.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(que.poll()).append('\n');
				}
				break;
			case "size":
				sb.append(que.size()).append('\n');
				break;
			case "empty":
				if (que.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				if (que.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(que.peek()).append('\n');
				}
				break;
			case "back":
				if (que.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(que.peekLast()).append('\n');
				}
				break;
			default:
				break;

			}
		}
		
		System.out.println(sb);
	}
}