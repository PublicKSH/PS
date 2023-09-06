//구현이 쉬운 다익스트라 알고리즘
#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

// 노드의 개수, 간선의 개수, 시작 노드 번호 각각 n,m,start
// 노드의 개수는 최대 100,000개라고 가정
int n, m, start;
//각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
vector<pair<int, int> > graph[100001];
//방문한 적이 있는치 체크하는 목적의 배열
bool visited[100001];
//최단거리 테이블 만들기
int d[100001];

//방문하지 않은 노드들 중에서 가장 최단거리가 짧은 노드의 번호를 반환
int getSmallestNode() {
	int min_value = INF;
	int index = 0; //최단거리가 가장 짦은 노드(인덱스)
	for (int i=1; i<=n; i++) {
		if (d[i] < min_value && !visited[i]) {
			min_value = d[i];
			index = i;
		}
	}
	return index;
}

void dijkstra(int start) {
	// 시작 노드에 대해서 초기화
	d[start] = 0; 
	visited[start] = true;
	for (int i = 0; i < graph[start].size(); i++) {
		d[graph[start][i].first] = graph[start][i].second;
	}
	// 시작 노드를 제외한 전체 n-1개의 노드에 대해서 반복
	for (int i=0; i < n-1; i++) {
		int now = getSmallestNode();
		visited[now] = true;
		// 현재 노드와 연결된 다른 노드를 확인
		for (int j=0; j < graph[now].size(); j++) {
			// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 최단경로를 변경한다.
			int cost = d[now] + graph[now][j].second;
			if (cost < d[graph[now][j].first]) {
				d[graph[now][j].first] = cost;
			}
		}
	}
}
 
int main() {
	cin >> n >> m >> start;
	
	// 모든 간선의 정보를 입력받기
	for (int i=0; i!=m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		//a번 노드에서 b번 노드로 가는 비용이 cin
		graph[a].push_back({b,c});
	}

	// 최단거리 데이블을 모두 무한으로 초기화
	fill_n(d,100001,INF);
	
	// 다익스트라 알고리즘을 수행
	dijkstra(start);
	
	//모든 노드로 가기위한 최단 거리를 출력
	for (int i=1; i<=n; i++) {
		if (d[i] == INF)
			cout << "INF\n";
		else
			cout << d[i] << "\n";
	}
	
	return 0;
}