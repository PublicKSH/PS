// 메모리 제한 4MB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static int bitMasking = 0;

	public static void main(String[] args) throws IOException {
		int m = Integer.parseInt(br.readLine());
		String[] st;
		int x;
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			switch (st[0]) {
			case "add":
				x = Integer.parseInt(st[1]);
				bitMasking |= (1 << x);
				break;
			case "remove":
				x = Integer.parseInt(st[1]);
				bitMasking &= ~(1 << x);
				break;
			case "check":
				x = Integer.parseInt(st[1]);
				sb.append((bitMasking & (1 << x)) != 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st[1]);
				bitMasking ^= (1 << x);
				break;
			case "all":
				bitMasking = ((1<<21) - 1);
				break;
			case "empty":
				bitMasking = 0;
				break;
			}
		}
		
		System.out.println(sb);
	}
}
