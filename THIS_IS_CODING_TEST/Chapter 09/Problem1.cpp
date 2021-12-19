//플로이드워셜 알고리즘
#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

int n, m;
int graph[101][101];

int main() {
	cin >> n >> m;
	// 최단거리 테이블 초기화
	for (int i=0; i<101; i++) {
		fill(graph[i],graph[i]+101,INF);
	}
	
	//자기 자신에서 자기 자신으로 가는 테이블 모두 0으로 초기화
	for (int a=1; a<=n; a++) {
		for (int b=1; b<=n; b++) {
			if (a == b) graph[a][b] = 0;
		}
	}
	
	//각 간선에 대한 정보를 입력받아, 그값으로 초기화
	//이 문제의 경우 노드에서 노드사이의 거리를 1로 정한다.
	for (int i=0; i!=m; i++) {
		int a, b;
		cin >> a >> b;
		graph[a][b] = graph[b][a] = 1;
	}
	
	//플로이드 워셜 알고리즘 진행
	for (int k=1; k<=n; k++) {
		for (int a=1; a<=n; a++) {
			for (int b=1; b<=n; b++) {
				graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b]);
			}
		}
	}
	
	//거처갈 노드(k)와 가야할 노드(x)의 거리입력 받기
	int x, k; 
	cin >> x >> k;
	
	int distance = graph[1][k] + graph[k][x];
	
	if (distance >= INF)
		cout << "-1\n";
	else
		cout << distance << "\n";
	
	return 0;
}