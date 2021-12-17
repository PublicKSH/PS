//실버1 7576번 토마토
#include <bits/stdc++.h>
using namespace std;
//"인접한" 토마토이므로 bfs사용

int graph[1001][1001];
int m,n;
int Max = 0;
// 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
// 미로탐색과 같은형식으로
int bfs() {
    //1. 익은 토마토가 들어있는 좌표를 전부 q에 넣는다.
    queue<pair<int, int> > q;
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            if(graph[i][j] == 1) 
                q.push({i,j});
        }
    }
    
    //2. 상하좌우로 토마토를 익힌다. 이떄 범위를 넘어가거나 -1을 만나면 무시
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i=0; i!=4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            //범위 넘어가면 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            //통이 비었으면 무시
            if (graph[nx][ny] == -1) continue;
            //처음 만나는 통일시 토마토를 익힌다.
            if (graph[nx][ny] == 0) {
                graph[nx][ny] = graph[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }

    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if (graph[i][j] == 0) {
                return -1;
            }
            else if (Max < graph[i][j]) Max = graph[i][j];
        }
    }

    if (Max == 1)
        return 0;
    else
        return Max-1; //첫날은 제외
}

int main() {
    cin >> m >> n;
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            scanf("%d",&graph[i][j]);
        }
    }

    cout << bfs();
    
    return 0;
}