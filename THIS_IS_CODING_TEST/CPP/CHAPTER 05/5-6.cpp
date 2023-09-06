#include <bits/stdc++.h>
using namespace std;
#define INF 999999999 //무한의 비용 선언
//인접 행렬 방식 예제

int graph[3][3] = {
        {0,7,5},
        {7,0,INF},
        {5,INF,0}
    };

// 그래프 출력
int main() {
     for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cout << graph[i][j] << ' ';
        }
        cout << '\n';
    }
    
	return 0;
}

