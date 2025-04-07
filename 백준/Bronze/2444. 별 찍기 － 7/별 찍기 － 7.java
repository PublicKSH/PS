import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				System.out.printf(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.printf("*");
			}
			System.out.printf("\n");
		}

		for (int i = 0; i < 2 * n - 1; i++) {
			System.out.printf("*");
		}
		System.out.printf("\n");
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - i - 2; j >= 0; j--) {
				System.out.printf(" ");
			}
			for (int j = 2 * i; j >= 0; j--) {
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
	}
}
