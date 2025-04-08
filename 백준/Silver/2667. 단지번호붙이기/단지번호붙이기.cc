#include <bits/stdc++.h>

using namespace std;

int n;
int graph[26][26];

static int house_num = 0;
bool dfs(int x, int y) {
	//범위를 벗어나는 경우 바로 종료
	if (x<0 || x>=n || y<0 || y>=n)
		return false;
	//방문하지 않은 노드가 있으면 방문하게 한다.
	if (graph[x][y] == 1) {
		//방문처리
		house_num++;
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
	cin >> n;
	for (int i=0; i!=n; i++) {
		for (int j=0; j!=n; j++) {
			scanf("%1d", &graph[i][j]);
		}
	}
	
	int result = 0;
	vector<int> count;
	for (int i=0; i!=n; i++) {
		for (int j=0; j!=n; j++) {
			if (dfs(i,j)) {
				result++;
				count.push_back(house_num);
			}
			house_num = 0;
		}
	}
	cout << result << endl;
	sort(count.begin(), count.end());
	for (vector<int>::size_type i=0; i!=count.size(); i++) {
		cout << count[i] << endl;
	}
	return 0;
}