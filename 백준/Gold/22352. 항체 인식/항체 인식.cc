#include <bits/stdc++.h>
using namespace std;


int n,m;
int x,y;
int now = 0; // first의 기존 정수 
int dif = 0; // first와 second 그래프의 다른부분의 정수
int first[31][31]; //처음상태의 그래프
int second[31][31]; //두번째 생태의 그래프
// 첫번째 상태와 두번째 상태의 그래프를 비교해서 다른 부분 찾으면 return한뒤
// 다른부분을 dfs를 이용하여 처음상태의 그래프도 똑같이 만든다
// 이후 두번째 그래프와 비교해서 다르다면 -> NO 같다면 Yes를 출력

//바뀐 그래프와 second가 같은 그래프인지 확인
bool Same() {
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            if (first[i][j] != second[i][j]) return false;
        }
    }
    return true;
}
//dfs 함수
void dfs(int x, int y) { 
    // 범위를 넘어갈 시에 즉시 종료
    if (x >= n || x < 0 || y >= m || y < 0)
        return;
    // 만약 현재 노드가 dif가 아니라면
    // 오류가 있을 수 있음 주변노드가 원래 dif인경우도 생각
    if (first[x][y] == now) {
        // 방문처리
        first[x][y] = dif;
        // 주변의 방문하지 않은 노드들 전부 방문처리
        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);
    }
}

void Solved() {
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            if (first[i][j] != second[i][j]) {
                now = first[i][j];
                dif = second[i][j];
                dfs(i,j);
                return;
            }
        }
    }
}

int main() {
    cin >> n >> m;
    // first 입력
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            int x;
            cin >> x;
            first[i][j] = x;
        }
    }
    //second 입력
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            int x;
            cin >> x;
            second[i][j] = x;
        }
    }

    //dfs 
    Solved();

    //결과 출력
    if (Same())
        cout << "YES";
    else
        cout << "NO";
    return 0;
}