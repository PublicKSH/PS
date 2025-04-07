import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Brick {
	int id;
	int baseArea;
	int height;
	int weight;

	public Brick(int id, int baseArea, int height, int weight) {
		this.id = id;
		this.baseArea = baseArea;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", baseArea=" + baseArea + ", height=" + height + ", weight=" + weight + "]";
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Brick[] bricks;
	static int maxHeight;
	static int[] dp;
	static ArrayList<Integer> resultList;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		bricks = new Brick[N + 1];
		bricks[0] = new Brick(0, 0, 0, 0);
		dp = new int[N + 1];
		maxHeight = -1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int baseArea = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			bricks[i] = new Brick(i, baseArea, height, weight);
		}

		// 밑면의 넓이가 같거나 무게가 같은 벽돌은 없음
		// 밑면의 넓이 내림차순 정렬
		Arrays.sort(bricks, new Comparator<Brick>() {
			@Override
			public int compare(Brick b1, Brick b2) {
				return b1.baseArea - b2.baseArea;
			}
		});

		// 밑면의 넓이는 정렬되었으니 고려할 필요가 없다
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (bricks[i].weight > bricks[j].weight) {
					dp[i] = Math.max(dp[i], bricks[i].height + dp[j]);
				}
			}
		}

		for (int i =0; i<=N; i++) {
			maxHeight = Math.max(maxHeight, dp[i]);
		}
		
		resultList = new ArrayList<>();
		for (int i = N; i > 0; i--) {
			if (maxHeight == dp[i]) {
				maxHeight -= bricks[i].height;
				resultList.add(bricks[i].id);
			}
		}

		System.out.println(resultList.size());
		for (int i = resultList.size() - 1; i >= 0; i--) {
			System.out.println(resultList.get(i));
		}
	}
}
