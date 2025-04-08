import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxScore = -1;
	static int action[][] = new int[51][9];
	static int order[] = new int[9];
	static boolean visit[] = new boolean[10];

	static void makeOrder(int k) {
		// 문제 코드 1 : k == 8 이 되면 안됬음 -> k == 9 가 되어야함 k가 8일 경우 0 1 2 3 4 5 6 7 0 (8 번째 선수가 없음 8번 째 선수만 아웃을 가지고 있었을 떄 무한루프 발생 - 8번째 선수의 아웃을 못가져옴)
		if (k == 9) {
			calcScore();
			return;
		}
		if (k == 3) {
			makeOrder(k + 1);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!visit[i]) {
				order[k] = i;
				visit[i] = true;
				makeOrder(k + 1);
				visit[i] = false;
			}
		}
	}

	static void calcScore() {
		int outCnt, act, i = 0;
		int score = 0, x;
		for (int round = 0; round < N; round++) {
			outCnt = 0;
			
			x = 0;
			while (outCnt < 3) {
				act = action[round][order[i]];
				i = (i + 1) % 9;
				if (act == 0) { // 아웃
					outCnt++;
				} else { // 안타 이상
					// 문제 코드 2 : (1 << (x - 1)) 가 아닌 (1 << (act - 1)) 임
					x = (x << act) | (1 << (act- 1)); // 주자 이동
					score += Integer.bitCount((x >> 3)); // 홈에 들어온 주자 수 세기
					x &= 7; // 3루 이하 주자만 유지 (0111)
				}
			}
		}

		maxScore = Math.max(maxScore, score);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				action[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order[3] = 0;
		visit[0] = true;
		makeOrder(0);
		System.out.println(maxScore);
	}
}