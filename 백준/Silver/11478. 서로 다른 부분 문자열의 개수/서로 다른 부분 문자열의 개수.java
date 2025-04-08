import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer(br.readLine());
		HashMap<String, String> hashMap = new HashMap<>();

		for (int i = 0; i < sb.length(); i++) {
			for (int j = i; j < sb.length(); j++) {
				hashMap.put(sb.substring(i, j+1), "0");
			}
		}
		System.out.println(hashMap.size());
	}
}
