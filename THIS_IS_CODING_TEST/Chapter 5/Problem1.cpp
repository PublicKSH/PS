//음료수 얼려먹기
#include <bits/stdc++.h>
using namespace std;

int n, m;
int graph[1000][1000];
int result = 0;
bool dfs(int x, int y) {
    // 범위를 넘어갈 시에 즉시 종료
    if (x >= n || x < 0 || y >= m || y < 0)
        return false;
    // 만약 현제 노드를 방문하지 않았으면
    if (graph[x][y] == 0) {
        // 방문처리
        graph[x][y] = 1;
        // 주변의 방문하지 않은 노드들 전부 방문처리
        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);

        return true;
    }
    return false;
}

int main() {
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            scanf("%1d",&graph[i][j]);
        }
    }

    for(int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if(dfs(i,j))
                result++;
        }
    }

    cout << result;
	return 0;
}

