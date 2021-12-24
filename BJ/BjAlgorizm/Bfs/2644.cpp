#include <bits/stdc++.h>
using namespace std;



bool visited[101];
vector<int> graph[101];
int dist[101] = {0};

int bfs(int start, int end) {
    queue<int> q;
    q.push(start);

    while(!q.empty()) {
        int x = q.front();
        q.pop();

        if(x == end)
            return dist[end];
        
        vector<int>::size_type size = graph[x].size();

        for (int i=0; i!=size; i++) {
            int y = graph[x][i];

            if (!dist[y]) { // 만약 dist[y] == 0 일시 방문안했다는 것 -> 고로 큐에 넣어줌
                q.push(y);
                dist[y] = dist[x] + 1;
            }
        }
    }
    return -1;
}


int main()
{
    int n;
    int p1, p2; // person 1,2
    int m;
    // 입력
    cin >> n;
    cin >> p1 >> p2;
    cin >> m;
    for (int i=0; i!=m; i++) {
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }


    cout << bfs(p1,p2);
    
    return 0;
}