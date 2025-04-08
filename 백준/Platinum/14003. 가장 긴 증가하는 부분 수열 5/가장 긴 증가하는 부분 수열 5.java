import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int num;
	Node next;
	Node prev;

	Node(int num) {
		this.num = num;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			// arr[i] 이 list 에 들어갈 위치(arr[i] 보다 크거나 같은 값이 처음 나오는 위치)를 이분탐색으로 찾음
			int s = 0;
			int e = list.size();
			int mid = 0;
			while (s < e) {
				// T, F 구간으로 나누기
				mid = (s + e) / 2;
				if (list.get(mid).num < arr[i]) {
					s = mid + 1;
				} else {
					e = mid;
				}
			}

			if (s == list.size()) {
				list.add(new Node(arr[i]));
				if (list.size() > 1) {
					list.get(list.size() - 1).prev = list.get(list.size() - 2);
				}
			} else {
				list.set(s, new Node(arr[i]));	
				
				if (s > 0) {
					list.get(s).prev = list.get(s -1);
				}
			}
		}
		
		System.out.println(list.size());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		Node indexNode = list.get(list.size() - 1);
		while(indexNode != null) {
			stack.push(indexNode.num);
			indexNode = indexNode.prev;
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}