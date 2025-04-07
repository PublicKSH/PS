import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] strArr = br.readLine().split(" ");
		int n = Integer.parseInt(strArr[0]), m = Integer.parseInt(strArr[1]);
		HashMap<String, Integer> hashMap = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {			
			String str = br.readLine();
			hashMap.put(str, 1);
		}
		for (int i = 0; i < m; i++) {			
			String str = br.readLine();
			Integer isExist = hashMap.get(str);
			if (Objects.nonNull(isExist)) {
				arr.add(str);
			}
		}
		
		System.out.println(arr.size());
		arr.sort(Comparator.naturalOrder());
		for (String name : arr) {
			System.out.println(name);
		}
	}
}
