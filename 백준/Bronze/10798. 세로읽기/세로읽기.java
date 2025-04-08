import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String st;
		int n = 5, m = 15;
		Character[][] arr = new Character[n][m];
		for (int i = 0; i < n; i++) {
			st = br.readLine();
			for (int j = 0; j < st.length(); j++) {
				arr[i][j] = st.charAt(j);
			}
		}
				
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				// null 은 특별한 리터럴이야 ==, != 으로 사용가능(상수 값이라서)
				// Character는 referenceType이라 기본적으로 null 로 초기화
				if (arr[i][j] != null) {
					System.out.printf(arr[i][j].toString());
				}
			}
		}
		
	}
}
