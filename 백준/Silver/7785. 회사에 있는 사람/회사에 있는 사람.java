// boj 19532
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> hashmap = new HashMap<>();
		String name;
		String log;
		String[] inputStrArr;
		for (int i = 0; i < n; i++) {
			inputStrArr = br.readLine().split(" ");
			name = inputStrArr[0];
			log = inputStrArr[1];
			if (log.equals("enter")) {
				hashmap.put(name, name);
			} else { // "leave"
				hashmap.remove(name);
			}
		}

		String[] returnString = hashmap.values().stream().sorted(Comparator.reverseOrder()).toArray(String[]::new);
		System.out.println(Arrays.toString(returnString).replaceAll("[\\[\\],]", ""));
	}
}