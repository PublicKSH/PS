import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//상(0), 하(1), 좌(2), 우(3)
enum Direction {
	U, D, L, R;

	public Direction getOpposite() {
		switch (this) {
		case U:
			return D;
		case D:
			return U;
		case L:
			return R;
		case R:
			return L;
		}
		// 문제에선 return null은 발생하지 않음
		return null;
	}

	// 상/하 (수직)
	public boolean isVertical() {
		return this == U || this == D;
	}

	// 좌/우 (수평)
	public boolean isHorizontal() {
		return this == L || this == R;
	}

}

class Atom {
	public Atom(int num, int x, int y, Direction dir, int k) {
		super();
		this.num = num;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.k = k;
	}

	int num;
	int x;
	int y;
	Direction dir;
	int k;
}

class Crash implements Comparable<Crash> {
	@Override
	public String toString() {
		return "[time=" + time + ", a=" + a + ", b=" + b + "]";
	}

	public Crash(double time, int aNum, int bNum) {
		super();
		this.time = time;
		this.a = aNum;
		this.b = bNum;
	}

	double time;
	int a;
	int b;

	@Override
	public int compareTo(Crash o) {
		return Double.compare(this.time, o.time);
	}

}

//모든 원자들 끼리 충돌 시간을 기록 1,000 * 1,000
// 충돌 시간 순으로 빼면서(pq사용) 결과 값 계산 -> 이미 삭제된 원자면 무시 log(1,000*1,000)
public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int result;
	static int N;
	static Atom[] atoms;
	static PriorityQueue<Crash> pq;
	// 원자 번호 / 시간
	static HashMap<Integer, Double> timeMap;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			atoms = new Atom[N];
			pq = new PriorityQueue<>();
			timeMap = new HashMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Direction dir = Direction.values()[Integer.parseInt(st.nextToken())];
				int k = Integer.parseInt(st.nextToken());
				atoms[i] = new Atom(i, x, y, dir, k);
			}

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					// 1. 방향이 같다 => 절대 충돌하지 않는다
					if (atoms[i].dir.equals(atoms[j].dir)) {
						continue;
					}
					// 2. 방향이 반대일 때
					else if (atoms[i].dir.getOpposite().equals(atoms[j].dir)) {
						// 상/하 일때 => x값이 같다 && U 원자의 y 값이 D 원자의 y보다 작다
						if (atoms[i].dir.isVertical()) {
							Atom upAtom = atoms[i];
							Atom downAtom = atoms[j];
							if (atoms[i].dir.equals(Direction.D)) {
								upAtom = atoms[j];
								downAtom = atoms[i];
							}

							if (upAtom.x == downAtom.x && upAtom.y < downAtom.y) {
								pq.offer(new Crash(Math.abs(upAtom.y - downAtom.y) / (double) 2, atoms[i].num,
										atoms[j].num));
							}
						}
						// 좌/우 일때 => y값이 같다 && R 원자의 x 값이 L 원자의 x보다 작다
						else {
							Atom leftAtom = atoms[i];
							Atom rightAtom = atoms[j];
							if (atoms[i].dir.equals(Direction.R)) {
								leftAtom = atoms[j];
								rightAtom = atoms[i];
							}

							if (leftAtom.y == rightAtom.y && rightAtom.x < leftAtom.x) {
								pq.offer(new Crash(Math.abs(leftAtom.x - rightAtom.x) / (double) 2, atoms[i].num,
										atoms[j].num));
							}
						}
					}
					// 3. 방향이 크로스일 때
					else {
						// 1. 두점의 교차점을 구함
						Atom verticalAtom = atoms[i].dir.isVertical() ? atoms[i] : atoms[j];
						Atom horizontalAtom = atoms[i].dir.isHorizontal() ? atoms[i] : atoms[j];
						int x = verticalAtom.x;
						int y = horizontalAtom.y;
						// 2. 두 점 모두 교차점으로 이동하고 있다. && 두 점모두 교차점 까지의 거리가 같다.
						int verticalDist = Math.abs(y - verticalAtom.y);
						int horizontalDist = Math.abs(x - horizontalAtom.x);

						// 수평 원자가 교차점으로 가고 있는지
						// boolean verticalAtomToCross =
						boolean verticalAtomToCross = (verticalAtom.dir == Direction.U && y > verticalAtom.y)
								|| (verticalAtom.dir == Direction.D && y < verticalAtom.y);

						boolean horizontalAtomToCross = (horizontalAtom.dir == Direction.L && x < horizontalAtom.x)
								|| (horizontalAtom.dir == Direction.R && x > horizontalAtom.x);
						// 동시에 도착 && 방향이 교차점으로 향함
						if (verticalAtomToCross && horizontalAtomToCross && verticalDist == horizontalDist) {
							pq.offer(new Crash(verticalDist, atoms[i].num, atoms[j].num));
						}
					}
				}
			}
			// 상(0), 하(1), 좌(2), 우(3)

			while (!pq.isEmpty()) {
				Crash crash = pq.poll();
				if (!timeMap.containsKey(crash.a) && !timeMap.containsKey(crash.b)) {
					timeMap.put(crash.a, crash.time);
					timeMap.put(crash.b, crash.time);
					result += atoms[crash.a].k;
					result += atoms[crash.b].k;
				}
				// 아래는 3중 충돌 처리 코드
				else if (!timeMap.containsKey(crash.a) && timeMap.containsKey(crash.b)
						&& timeMap.get(crash.b) == crash.time) {
					timeMap.put(crash.a, crash.time);
					result += atoms[crash.a].k;
				} else if (!timeMap.containsKey(crash.b) && timeMap.containsKey(crash.a)
						&& timeMap.get(crash.a) == crash.time) {
					timeMap.put(crash.b, crash.time);
					result += atoms[crash.b].k;
				}

			}

			System.out.printf("#%d %d\n", t, result);
		}
	}
}
