#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

int n, m, t;
int s, g, h; 
int dijk_s[2001]; //s를 시작으로 하는 다익스트라
int	dijk_g[2001]; //g를 시작으로 하는 다익스트라
int dijk_h[2001]; //h를 시작으로 하는 다익스트라
// 목표와 그래프 정보를 저장하는 vector
vector<int> targets; //목표지들
vector<pair<int,int> > graph[2001]; //그래프

void dijkstra(int start,int* arr) {
	priority_queue<pair<int, int> > pq; //기본적으로 max-heap이다.
	//시작 노드로 가기 위한 최단경로는 0으로 설정하여, 큐에 삽입
	pq.push({0,start});
	arr[start] = 0;
	while(!pq.empty()) { //큐가 비어있지 않다면
		//가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
		int dist = -pq.top().first; // 현재 노드까지의 비용
		int now = pq.top().second; // 현재 노드
		pq.pop();
		//현재 노드가 이미 처리된 적이 있는 노드라면 무시
		if (arr[now] < dist) continue;
		//현재 노드와 연결된 다른 인접한 노드들을 확인
		for (int i=0; i < graph[now].size(); i++) {
			int cost = dist + graph[now][i].second;
			//현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
			if (cost < arr[graph[now][i].first]) {
				arr[graph[now][i].first] = cost;
				pq.push(make_pair(-cost, graph[now][i].first));
			}
		}
	}
}

int main() {
	//입출력 속도 증가
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int T;
	cin >> T;
	while (T!=0) {
		// 최단거리 그래프 초기화
		targets.clear();
		for (int i=0; i!=2001; i++) {
			graph[i].clear();
		}
		fill(dijk_s,dijk_s+2001,INF);
		fill(dijk_g,dijk_g+2001,INF);
		fill(dijk_h,dijk_h+2001,INF);
		// 변수 입력받기
		cin >> n >> m >> t;
		cin >> s >> g >> h;
		for (int i=0; i!=m; i++) {
			int a, b, d;
			cin >> a >> b >> d;
			graph[a].push_back({b,d});
			graph[b].push_back({a,d});
		}
		for (int i=0; i!=t; i++) {
			int x;
			cin >> x;
			targets.push_back(x);
		}
		// s,g,h에 대한 다익스트라 진행
		dijkstra(s,dijk_s);
		dijkstra(g,dijk_g);
		dijkstra(h,dijk_h);
		// targets 정렬
		sort(targets.begin(), targets.end());
		// targets 의 요소가 조건을 만족하면 출력 아니면 출력 안함
		/* 조건
			목적지 인덱스를 k라 하면 
			dijk_s[k] == dijk_s[g] + dijk_g[h] + dijk_h[k] 또는
			dijk_s[k] == dijk_s[h] + dijk_h[g] + dijk_g[k] 가 성립해야한다.
		*/
		
		for (vector<int>::size_type i=0; i!=targets.size(); i++) {
			int k = targets[i];
			if (dijk_s[k] == dijk_s[g] + dijk_g[h] + dijk_h[k] || dijk_s[k] == dijk_s[h] + dijk_h[g] + dijk_g[k])
				cout << k << " ";
		}
		cout << "\n";
		T--;
	}
	
	return 0;
}