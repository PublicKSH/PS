#include <bits/stdc++.h>

using namespace std;

int T, m, n, k;
int graph[51][51]; //dfs를 돌리면 초기화 된다.

bool dfs(int x, int y) {
	//범위를 벗어나는 경우 바로 종료
	if (x<0 || x>=m || y<0 || y>=n)
		return false;
	//방문하지 않은 노드가 있으면 방문하게 한다.
	if (graph[x][y] == 1) {
		//방문처리
		graph[x][y] = 0;
		//상하좌우의 dfs를 재귀적으로 호출
		dfs(x-1, y);
		dfs(x, y-1);
		dfs(x+1, y);
		dfs(x, y+1);
		return true;
	}
	return false;
}

int main() {
	cin >> T;
	while (T!=0) {
		cin >> m >> n >> k;
		int result = 0;
		for (int i=0; i!=k; i++) {
			int x,y;
			cin >> x >> y;
			graph[x][y] = 1;
		}
		for (int i=0; i!=m; i++) {
			for (int j=0; j!=n; j++) {
				if (dfs(i,j)) result++;
			}
		}
		cout << result << endl;
		T--;
	}
	return 0;
}