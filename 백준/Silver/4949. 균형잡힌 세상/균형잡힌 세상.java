import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		while (true) {
			String s = br.readLine();
			if (s.equals(".")) {
				break;
			}

			// 괄호를 담는 리스트 -> indexOf 사용을 위해 ArrayList()로 생
			List<Character> perList = new ArrayList<>(Arrays.asList('(', ')', '[', ']'));
			ArrayDeque<Character> stack = new ArrayDeque<>();
			for (int i = 0; i < s.length(); i++) {
				if (perList.indexOf(s.charAt(i)) != -1) {
					if (!stack.isEmpty() && perList.indexOf(s.charAt(i)) % 2 == 1
							&& perList.indexOf(s.charAt(i)) - perList.indexOf(stack.peek()) == 1) {
						stack.pop();
					} else {
						stack.push(s.charAt(i));
					}
				}
			}
			
			if (stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}