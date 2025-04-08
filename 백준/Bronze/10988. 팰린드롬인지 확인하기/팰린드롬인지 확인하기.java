import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuffer str = new StringBuffer(sc.nextLine());
		
		int startIndex = 0;
		int endIndex = str.length()-1;
		int result = 1;
		while (startIndex < endIndex) {
			// char 은 primitive type이기 때문에 == 을 써도 상관 없다.
			if (str.charAt(startIndex) != str.charAt(endIndex)) {
				result = 0;
			}
			startIndex ++;
			endIndex --;
		}
		
		System.out.println("" + result);
	}
}
