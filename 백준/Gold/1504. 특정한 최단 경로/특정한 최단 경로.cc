//플로이드워셜 알고리즘
#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

int n, m;
long long int graph[801][801];

int main() {
	cin >> n >> m;
	// 최단거리 테이블 초기화
	for (int i=0; i<801; i++) {
		fill(graph[i],graph[i]+801,INF);
	}
	
	//자기 자신에서 자기 자신으로 가는 테이블 모두 0으로 초기화
	for (int a=1; a<=n; a++) {
		for (int b=1; b<=n; b++) {
			if (a == b) graph[a][b] = 0;
		}
	}
	
	//각 간선에 대한 정보를 입력받아, 그값으로 초기화
	for (int i=0; i!=m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a][b] = graph[b][a] = c;
	}
	
	//플로이드 워셜 알고리즘 진행
	for (int k=1; k<=n; k++) {
		for (int a=1; a<=n; a++) {
			for (int b=1; b<=n; b++) {
				graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b]);
			}
		}
	}
	
	//반드시 지나야 하는 정점 2개
	int v1, v2;
	cin >> v1 >> v2;
	
	//1->v1->v2->n 과 1->v2->v1->n 중 작은값
	int distance = min(graph[1][v1] + graph[v1][v2] + graph[v2][n], graph[1][v2] + graph[v2][v1] + graph[v1][n]);
	
	if(graph[1][v1]==INF||graph[v1][v2]==INF||graph[v2][n]==INF)
		cout << "-1\n";
	else
		cout << distance << endl;
	
	return 0;
}