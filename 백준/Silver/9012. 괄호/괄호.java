import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayDeque<Integer> stack;
	final static char LEFT_PER = '(';
	final static char RIGHT_PER = ')';
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		
		for (int testCase = 0; testCase < T; testCase++) {
			String s = br.readLine();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			// 문자열의 첫번째 문자가 ( 로 시작하지 않으면 NO
			if (s.charAt(0) != LEFT_PER) {
				System.out.println("NO");
				continue;
			}
			
			stack.push(s.charAt(0));
			
			for (int i=1; i <s.length(); i++) {
				if(!stack.isEmpty() && stack.peek().equals(LEFT_PER) && s.charAt(i) == RIGHT_PER) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
			
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
					
			}
		}
		
		
	}
}