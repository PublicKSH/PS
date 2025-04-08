#include <bits/stdc++.h>

using namespace std;

int n, m, v;
int count = 0;
vector<int> graph[1001];

bool dfs_visited[1001]; //해당 노드를 방문했는지 확인하기 위함
void dfs(int x) {
	dfs_visited[x] = true;
	::count += 1;
	//방문하지 않은 노드를 재귀적으로 반문
	for (int i=0; i!=graph[x].size(); i++) {
		int y = graph[x][i];
		if (!dfs_visited[y]) dfs(y);
	}
}
int main() {
	cin >> n >> m;
	for (int i=0; i!=m; i++) {
		int x, y;
		cin >> x >> y;
		graph[x].push_back(y);
		graph[y].push_back(x);
	}
	for (int i=0; i<=n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}
	dfs(1);
	cout << ::count-1;
	return 0;
}