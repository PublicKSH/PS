//미로 탈출
#include <bits/stdc++.h>
using namespace std;

int n, m;
int graph[201][201];

// 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

//dfs로 특정 노드를 방문하고 연결된 모든 노드들도 방문처리함
int bfs(int x, int y) {
	queue<pair<int, int> > q;
    q.push({x,y});
    //큐가 빌때까지 반복하기
    while (q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        //상하좌우로 위치 확인
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //범위를 넘어가면 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            //괴물을 만나면 무시
            if (graph[nx][ny] == 0) continue;
            //해당 노드를 처음방문시 최단 거리 기록
            if (graph[nx][ny] == 1) {
                graph[nx][ny] = graph[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }
    return graph[n-1][m-1];
}
int main() {
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            scanf("%1d",&graph[i][j]);
        }
    }


    cout << bfs(0,0) << endl;
	return 0;
}