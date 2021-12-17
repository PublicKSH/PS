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
	for (int i=0; i!=m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		if (graph[a][b] > c)
			graph[a][b] = c;
	}
	
	//플로이드 워셜 알고리즘 진행
	for (int k=1; k<=n; k++) {
		for (int a=1; a<=n; a++) {
			for (int b=1; b<=n; b++) {
				graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b]);
			}
		}
	}
	
	for (int a=1; a<=n; a++) {
		for (int b=1; b<=n; b++) {
			if (graph[a][b] == INF)
				printf("0 ");
			else
				printf("%d ",graph[a][b]);
		}
		cout << "\n";
	}
	return 0;
}