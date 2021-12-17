//왕실의 나이트
#include <bits/stdc++.h>
using namespace std;

//1. 입력받은 영어를 좌표로 바꾸기
//2-1. 바꾼 좌표에서 8가지 경우를 전부 움직여 보면서 안되는 경우 찾기

string pos;
int cnt=0;
int dx[8] = {-1,1,-2,2,-1,1,-2,2};
int dy[8] = {-2,2,-1,1,2,-2,1,-1};

int main() {
    cin >> pos;
    // 왼쪽 위를 0,0으로 계산
    int x = pos[0] - 'a';
    int y = pos[1] - '0' -1;
   
    for (int i=0; i<8; i++) {
        // 체스판을 넘어가는지 알아보기 위한 변수
        int nx = dx[i];
        int ny = dy[i];
        // 체스판을 넘어가지 않으면 증가
        if (nx+x >= 0 && nx+x <= 7 && ny+y >= 0 && ny+y <= 7)
            cnt++;
    }
    cout << cnt << " ";
	return 0;
}