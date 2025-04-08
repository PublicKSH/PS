// 플로이드 워셜 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static final int INF = (int) 1e9;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// intst => input 값 제어 배열(for 문이 빠른걸항상 생)
			int[] intst = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
			// 최단거리 테이블 초기화
			int[] distArr = new int[10_001];
			Arrays.fill(distArr, INF);

			int n = intst[0], d = intst[1], c = intst[2];
			ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
			// 그래프 초기화
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<Node>());
			}

			// index를 0이 아닌 1부터 관리하는걸 염두하기
			for (int i = 0; i < d; i++) {
				intst = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

				graph.get(intst[1]).add(new Node(intst[0], intst[2]));
			}

			// 다익스트라 진행
			dijk(c, distArr, graph);
			
			int resultCom = 0;
			int resultTime = 0;
			for (int i =1; i< n+1; i++) {
				if (distArr[i] != INF) {
					resultCom++;
					resultTime = Math.max(resultTime, distArr[i]);
				}
			}
			System.out.println(resultCom + " " + resultTime);
		}

	}

	public static void dijk(int start, int[] distArr, ArrayList<ArrayList<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distArr[start] = 0;

		while (!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int nowIndex = nowNode.index;
			int nowDist = nowNode.dist;

			if (distArr[nowIndex] < nowDist) {
				continue;
			}
			
			// 현재 노드와 연결된 다른 노드 확
			for (int i = 0; i < graph.get(nowIndex).size(); i++) {
				// 현재 노드를 거쳐서 다른 노드로 이동하는 비용
				int cost = distArr[nowIndex] + graph.get(nowIndex).get(i).dist;
				if (cost < distArr[graph.get(nowIndex).get(i).index]) {
					distArr[graph.get(nowIndex).get(i).index] = cost;
					pq.offer(new Node(graph.get(nowIndex).get(i).index, cost));
				}
				// 최단 거리가 갱신되면 갱신시키고 큐에 넣
			}
		}

	}

	public static class Node implements Comparable<Node> {
		int index;
		int dist;

		Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node other) {
			int compareDist = Integer.compare(this.dist, other.dist);
			return compareDist;
		}

	}
}