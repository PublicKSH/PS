//15900번
#include <bits/stdc++.h>
using namespace std;


int n;
int check = 0; // 리프노드에서 루트노드로의 간선 개수
bool visited[500001]; 
vector<int> graph[500001]; 
int Cnt[500001]; // 리프노드에서 루트노드로의 거리
void dfs(int x) {
	visited[x] = true;
    //간선의 개수가 1개면 리프노드이다 이때 루트노드(1)은 제외
    if (x != 1 && graph[x].size() == 1) {
        check += Cnt[x];
    }
    Cnt[x]++;
	for (vector<int>::size_type i=0; i < graph[x].size(); i++) {
		int y = graph[x][i];
		if (!visited[y]) { Cnt[y]=Cnt[x]; dfs(y); }
    }
}

int main(void) {
    cin >> n;
    for (int i=0; i!=n-1; i++) {
        int a,b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

	dfs(1);
    if(check %2 == 1)
        cout << "Yes";
    else
        cout << "No";
	return 0;
}