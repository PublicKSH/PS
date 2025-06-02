import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

class Num {
	long num;
	int count;

	public Num(long num, int count) {
		super();
		this.num = num;
		this.count = count;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long targetNum;
	static HashSet<Long> visited;

	public static void main(String args[]) throws Exception {
		targetNum = Long.parseLong(br.readLine());
		visited = new HashSet<>();

		ArrayDeque<Num> que = new ArrayDeque<>();
		Num firstNum = new Num(targetNum, 0);
		que.offer(firstNum);
		visited.add(firstNum.num);

		while (true) {
			Num nowNum = que.poll();
//			System.out.println("num : " + nowNum.num + ", cnt : " + nowNum.count);
			if (nowNum.num == 1) {
				System.out.println(nowNum.count);
				return;
			}
			if (nowNum.num % 3 == 0 && !visited.contains(nowNum.num / 3)) {
				visited.add(nowNum.num / 3);
				que.offer(new Num(nowNum.num / 3, nowNum.count + 1));
			}
			if (nowNum.num % 2 == 0 && !visited.contains(nowNum.num / 2)) {
				visited.add(nowNum.num / 2);
				que.offer(new Num(nowNum.num / 2, nowNum.count + 1));
			}
			if (!visited.contains(nowNum.num - 1)) {
				visited.add(nowNum.num - 1);
				que.offer(new Num(nowNum.num - 1, nowNum.count + 1));
			}
		}
	}
}
