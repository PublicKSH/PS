// 메모리 제한 4MB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int x = Integer.parseInt(br.readLine());

		System.out.println(Integer.bitCount(x));
	}
}
