import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] strArr = br.readLine().split(" ");
		int n = Integer.parseInt(strArr[0]), m = Integer.parseInt(strArr[1]);

		HashMap<String, String> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {			
			String str = br.readLine();
			hashMap.put(str, i + 1 + "");
			hashMap.put(i + 1+ "", str);
		}
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			System.out.println(hashMap.get(str));
		}
	}
}