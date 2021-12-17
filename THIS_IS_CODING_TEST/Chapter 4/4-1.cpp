#include <bits/stdc++.h>
using namespace std;

int n;
string plans;
int x=1, y=1; //초기 좌표설정
// L, R, U, D에 따른 이동 방향 
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char moveTypes[4] = {'L', 'R', 'U', 'D'};

int main() {
	cin >> n;
	
	cin.ignore();
	getline(cin,plans);
	
	for (string::size_type i=0; i!=plans.size(); i++) {
		char move = plans[i];
		
		int nx, ny; //미리 움직여 공간을 벗어나는지 확인하기 위한 변수
		
		for (int j=0; j!=4; j++) {
			if (move == moveTypes[j]) {
				nx = x + dx[j];
				ny = y + dy[j];
			}
		}
		//만약 공간을 넘어간다면 무시
		if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
		//아니라면 x,y를 이동시킨다.
		x = nx;
		y = ny;
	}
	cout << x << " " << y;
	return 0;
}