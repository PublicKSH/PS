import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());

		ArrayDeque<Balloon> deque = new ArrayDeque<>();

		// 이번에는 deque 의 add, remove, get을 사용해서 문제 풀어보

		String[] st = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			deque.addLast(new Balloon(i + 1, Integer.parseInt(st[i])));
		}

		while (!deque.isEmpty()) {
			Balloon balloon = deque.removeFirst();
			sb.append(balloon.index).append(" ");

			if (deque.isEmpty()) {
				break;
			}

			if (balloon.paper >= 0) {
				for (int i = 0; i < balloon.paper - 1; i++) {
					deque.addLast(deque.removeFirst());
				}
			} else {
				// index 가 음수인 경우
				for (int i = 0; i > balloon.paper; i--) {
					deque.addFirst(deque.removeLast());
				}
			}
		}
		System.out.println(sb);
	}

	public static class Balloon {
		int index;
		int paper;

		Balloon(int index, int paper) {
			this.index = index;
			this.paper = paper;
		}
	}
}