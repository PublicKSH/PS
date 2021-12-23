//15분 고민후 답 확인 
//접근자체는 비슷함 구현을 해봤으면 맞았을거같다.
#include <bits/stdc++.h>

using namespace std;

int RGB[1001][3]; //각각 R,G,B로 칠했을때 최소의 수
int n;
int R,G,B;
int main() {
	cin >> n;
	cin >> R >> G >> B;
	RGB[1][0] = R;
	RGB[1][1] = G;
	RGB[1][2] = B;
	
	for (int i=2; i<=n; i++) {
		cin >> R >> G >> B;
		//집을 빨간색으로 칠했을때
		RGB[i][0] = min(RGB[i-1][1],RGB[i-1][2]) + R;
		//집을 초록색으로 칠했을때
		RGB[i][1] = min(RGB[i-1][0],RGB[i-1][2]) + G;
		//집을 파란색으로 칠했을때
		RGB[i][2] = min(RGB[i-1][0],RGB[i-1][1]) + B;
	}
	cout << min(RGB[n][0],min(RGB[n][1],RGB[n][2]));
	
	return 0;
}