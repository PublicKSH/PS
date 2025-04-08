import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		int kingNum = Integer.parseInt(st[0]);
		int queenNum = Integer.parseInt(st[1]);
		int rookNum = Integer.parseInt(st[2]);
		int bishopNum = Integer.parseInt(st[3]);
		int knightNum = Integer.parseInt(st[4]);
		int pawnNum = Integer.parseInt(st[5]);
		
		System.out.printf("%d ", 1 - kingNum);
		System.out.printf("%d ", 1 - queenNum);
		System.out.printf("%d ", 2 - rookNum);
		System.out.printf("%d ", 2 - bishopNum);
		System.out.printf("%d ", 2 - knightNum);
		System.out.printf("%d", 8 - pawnNum);
	}
}
