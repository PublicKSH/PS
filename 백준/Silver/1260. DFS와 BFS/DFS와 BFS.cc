#include <bits/stdc++.h>

using namespace std;

int n, m, v;
vector<int> graph[1001];

bool dfs_visited[1001]; //해당 노드를 방문했는지 확인하기 위함
void dfs(int x) {
	dfs_visited[x] = true;
	cout << x << ' ';
	//방문하지 않은 노드를 재귀적으로 반문
	for (int i=0; i!=graph[x].size(); i++) {
		int y = graph[x][i];
		if (!dfs_visited[y]) dfs(y);
	}
}
bool bfs_visited[1001]; //해당 노드를 방문했는지 확인하기 위함
void bfs(int start) {
	queue<int> q;
	q.push(start);
	//해당노드를 방문처리
	bfs_visited[start] = true;
	//큐가 빌때까지 반복
	while(!q.empty()) {
		//큐에서 원소 하나를 뽑아서 출력
		int x = q.front();
		q.pop();
		cout << x << ' ';
		// 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
		for (int i=0; i!=graph[x].size(); i++) {
			int y = graph[x][i];
			if (!bfs_visited[y]) {
				bfs_visited[y] = true;
				q.push(y);
			}
		}
	}
}


int main() {
	cin >> n >> m >> v;
	for (int i=0; i!=m; i++) {
		int x, y;
		cin >> x >> y;
		graph[x].push_back(y);
		graph[y].push_back(x);
	}
	for (int i=0; i<=n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}
	dfs(v);
	cout << endl;
	bfs(v);
	return 0;
}