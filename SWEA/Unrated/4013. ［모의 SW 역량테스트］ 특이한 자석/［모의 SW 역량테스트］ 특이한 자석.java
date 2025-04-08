import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Magnatic {

}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K;
	static int[] magnatics;
	static int result;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			magnatics = new int[4];
			result = 0;
			for (int i = 0; i < 4; i++) {
				magnatics[i] = Integer.parseInt(br.readLine().replace(" ", ""), 2);
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int targetIdx = Integer.parseInt(st.nextToken());
				int rotateDir = Integer.parseInt(st.nextToken());
				rotateTargetMagnatic(targetIdx - 1, rotateDir);
			}

			for (int i = 0; i < 4; i++) {
				if (getBitAt(magnatics[i], 7) == 1) {
					result += (1 << i);
				}
			}
			System.out.printf("#%d %d\n", t, result);
		}
	}

	public static String to8BitBinaryString(int b) {
		return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
	}

	public static void rotateTargetMagnatic(int targetIdx, int rotateDir) {
		int[] rotateDirs = new int[4];
		rotateDirs[targetIdx] = rotateDir;

		// 왼쪽으로 전파
		for (int i = targetIdx; i > 0; i--) {
			if (getBitAt(magnatics[i], 1) != getBitAt(magnatics[i - 1], 5)) {
				rotateDirs[i - 1] = -rotateDirs[i];
			} else {
				break;
			}
		}

		// 오른쪽으로 전파
		for (int i = targetIdx; i < 3; i++) {
			if (getBitAt(magnatics[i], 5) != getBitAt(magnatics[i + 1], 1)) {
				rotateDirs[i + 1] = -rotateDirs[i];
			} else {
				break;
			}
		}

		// 실제 회전 적용
		for (int i = 0; i < 4; i++) {
			if (rotateDirs[i] != 0) {
				magnatics[i] = rotate(magnatics[i], rotateDirs[i]);
			}
		}

		return;
	}

	public static int rotate(int magnatic, int rotateDir) {
		if (rotateDir == 1) {
			int lsb = magnatic & 1;
			return (magnatic >> 1) + (lsb << 7);
		} else {
			int msb = (magnatic >> 7) & 1;
			return ((magnatic << 1) & 0b11111111) + msb;
		}
	}

	public static int getBitAt(int value, int position) {
		return (value >> position) & 1;
	}

}