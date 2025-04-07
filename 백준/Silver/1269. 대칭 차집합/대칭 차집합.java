import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] strArr = br.readLine().split(" ");
		int n = Integer.parseInt(strArr[0]), m = Integer.parseInt(strArr[1]);
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();
		strArr = br.readLine().split(" ");
		for (int i =0; i <n; i++) {
			setA.add(Integer.parseInt(strArr[i]));
		}
		strArr = br.readLine().split(" ");
		for (int i =0; i <m; i++) {
			setB.add(Integer.parseInt(strArr[i]));
		}
		

		HashSet<Integer> retain = new HashSet<>();
		retain.addAll(setA);
		retain.retainAll(setB);
		HashSet<Integer> result = new HashSet<>();
		result.addAll(setA);
		result.addAll(setB);
		result.removeAll(retain);
		System.out.println(result.size());
	}
}