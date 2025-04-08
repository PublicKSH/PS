import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");
		// 현재 줄서 있는 곳
		ArrayDeque<Integer> stack1 = new ArrayDeque<>();
		// 한 명 씩 설 수 있는 곳
		ArrayDeque<Integer> stack2 = new ArrayDeque<>();
		for (int i = N-1; i >=0; i--) {
			stack1.push(Integer.parseInt(st[i]));
		}

		int nowNum = 1;
		while(!stack1.isEmpty()) {
			if (stack1.peek().equals(nowNum)) {
				stack1.pop();
				nowNum++;
			} else if (!stack2.isEmpty() && stack2.peek().equals(nowNum)) {
				stack2.pop();
				nowNum++;
			}
			else {
				stack2.push(stack1.pop());
			}
		}

		// stack2Size의 size()는 동적으로 변하니까 for 문안에 두면 안된다.
		int stack2Size = stack2.size();
		for (int i = 0; i < stack2Size; i++) {
			if (stack2.peek().equals(nowNum)) {
				nowNum++;
				stack2.pop();
			} else {
				break;
			}
		}

		if (stack2.isEmpty()) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}