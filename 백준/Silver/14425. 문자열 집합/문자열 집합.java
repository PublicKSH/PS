// boj 19532
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStrArr = br.readLine().split(" ");
		HashMap<String, Integer> set = new HashMap<>();
		int n = Integer.parseInt(inputStrArr[0]), m = Integer.parseInt(inputStrArr[1]);
		int result = 0;
		Integer value;
		String key;
		
		for (int i =0; i < n; i++) {
			set.put(br.readLine(), 1);
		}
		
		for (int i =0; i < m; i++) {
			key = br.readLine();
			// hashMap => key를 못찾으면 value 의 defaultValue 를 return
			// integer의 경우 null
			value = set.get(key);
			if(!Objects.isNull(value)) {
				result += 1;
			}
		}
		
		System.out.println(result);
	}
}