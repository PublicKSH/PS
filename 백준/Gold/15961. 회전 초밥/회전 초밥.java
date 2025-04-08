import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
	public Node(int sushi) {
		this.sushi = sushi;
	}

	int sushi;
	Node next;
	Node prev;
}

// 그냥 롤링하면서 초밥 먹는게 풀이 속도가 더 빠를 것 같습니당...
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int d;
	static int k;
	static int c;
	static Node[] sushiTable;
	static int result = 0;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushiTable = new Node[N];
		for (int i = 0; i < N; i++) {
			int sushi = Integer.parseInt(br.readLine());
			sushiTable[i] = new Node(sushi);
		}

		// double linked list 연결
		for (int i = 0; i < N; i++) {
			sushiTable[i].next = sushiTable[(i + 1) % N];
			sushiTable[i].prev = sushiTable[(i - 1 + N) % N];
		}

		// 최초로 초밥 먹기
		Node head = sushiTable[0];
		Node tail = sushiTable[k - 1];
		map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			addSushi(sushiTable[i].sushi);
		}
		// 보너스 초밥은 뱃속에 넣고 시작
		addSushi(c);
		result = Math.max(result, map.keySet().size());

		for (int i = 0; i < N - 1; i++) {
			// 스시 빼기
			removeSushi(head.sushi);
			// 스시먹기
			addSushi(tail.next.sushi);

			
			result = Math.max(result, map.keySet().size());
			
			head = head.next;
			tail = tail.next;
		}

		System.out.println(result);
	}
	
	static void addSushi(int sushi) {
		if (map.containsKey(sushi)) {
			map.put(sushi, map.get(sushi) + 1);
		} else {
			map.put(sushi, 1);
		}
	}
	
	static void removeSushi(int sushi) {
		if (map.get(sushi) == 1) {
			map.remove(sushi);
		} else {
			map.put(sushi, map.get(sushi) - 1);
		}
	}
}
